package com.buya2z.model.jdbcimpl;

import com.buya2z.beans.QueryTransferObject;
import com.buya2z.beans.product.Feature;
import com.buya2z.beans.product.MainFeature;
import com.buya2z.beans.product.Product;
import com.buya2z.beans.product.ProductImage;
import com.buya2z.config.Database;
import com.buya2z.config.DatabaseTable;
import com.buya2z.model.DAOFactory;
import com.buya2z.model.ImageDAO;
import com.buya2z.model.ProductDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jinu on 12/26/2016.
 */
public class ProductDAOImpl implements ProductDAO{
    private final Logger LOGGER = Logger.getLogger(ProductDAOImpl.class);

    @Override
    public boolean create(Product newProduct) {
        LOGGER.info("Trying to Create a new Product in to database");
        if(!newProduct.validate()) {
            return false;
        }
        ImageDAO dao = DAOFactory.getImageDAO();
        dao.saveProductImages(newProduct.getImages());
        //Setting Product Thumbnail as first image
        newProduct.setThumbnail(newProduct.getImages().get(1).getUrl());

        boolean isCreated = false;
        Connection connection = Database.getConnection();
        try {
            connection.setAutoCommit(false);
            insertProduct(newProduct, connection);
            int autoIncrementedId = Database.getAutoIncrementedId(DatabaseTable.getProductTableName());
            newProduct.setId(autoIncrementedId);
            insertFeatures(newProduct.getFeatures(), connection);
            insertImages(newProduct.getImages(), connection);
            insertMainFeatures(newProduct.getMainFeatures(), connection);
            connection.commit();
            isCreated = true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            LOGGER.error("Exception happened ", e);
        } finally {
            Database.setAutoCommitTrue(connection);
            Database.close(connection);
        }
        LOGGER.info("Product Created....");
        return isCreated;
    }

    private int insertProduct(Product product, Connection connection) throws SQLException{
        LOGGER.info("Inserting Product......");
        int count = doInsert(product.getCreateQuery(), connection);
        LOGGER.info("Inserted......");
        return count;
    }

    private int doInsert(QueryTransferObject queryObject, Connection connection) throws SQLException {
        int updatedCount = 0;
        try(PreparedStatement pstmt = connection.prepareStatement(queryObject.getQuery())) {
            DAOUtil.setPreparedValues(pstmt, queryObject.getValues());
            updatedCount = pstmt.executeUpdate();
        }
        return updatedCount;
    }

    private void insertImages(List<ProductImage> images, Connection connection) throws SQLException {
        LOGGER.info("Inserting Product images");
        for(ProductImage image : images) {
            LOGGER.info("Inserting image with Url" + image.getUrl());
            doInsert(image.getCreateQuery(), connection);
            LOGGER.info("Image inserted");
        }
        LOGGER.info("Product images Inserted...");
    }

    private void insertMainFeatures(List<MainFeature> mainFeatures, Connection connection) throws SQLException {
        LOGGER.info("Inserting MainFeatures for the product");
        for(MainFeature feature : mainFeatures) {
            LOGGER.info("Inserting MainFeature with title " + feature.getTitle() );
            doInsert(feature.getCreateQuery(), connection);
            LOGGER.info("Main Feature Inserted....");
        }
        LOGGER.info("Main Features inserted for the product");
    }

    private void insertFeatures(List<Feature> features, Connection connection) throws SQLException {
        LOGGER.info("Inserting Features for the product");
        for(Feature feature : features) {
            LOGGER.info("Inserting Feature with title " + feature.getTitle() );
            doInsert(feature.getCreateQuery(), connection);
            LOGGER.info(" Feature Inserted....");
        }
        LOGGER.info(" Features inserted for the product");
    }

}
