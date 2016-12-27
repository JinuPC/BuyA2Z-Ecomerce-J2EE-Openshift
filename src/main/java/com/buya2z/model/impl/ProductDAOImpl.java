package com.buya2z.model.impl;

import com.buya2z.beans.QueryTransferObject;
import com.buya2z.beans.product.Product;
import com.buya2z.config.Database;
import com.buya2z.config.DatabaseTable;
import com.buya2z.model.ProductDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Jinu on 12/26/2016.
 */
public class ProductDAOImpl implements ProductDAO{
    private final Logger LOGGER = Logger.getLogger(ProductDAOImpl.class);

    @Override
    public boolean create(Product newProduct) {
        LOGGER.info("Trying to insert a new Product in to database");
        boolean isCreated = false;
        Connection connection = Database.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getProductCreateStatement(newProduct, connection);
            LOGGER.info(preparedStatement);
            preparedStatement.executeUpdate();
            LOGGER.info("New Product Created Successfully");
        } catch (SQLException e) {
            LOGGER.error("Exception happened ", e);
        } finally {
            Database.close(preparedStatement, connection);
        }
        return isCreated;
    }

    private PreparedStatement getProductCreateStatement(Product product, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        QueryTransferObject object = product.getProductCreateQuery();
        preparedStatement = connection.prepareStatement(object.getQuery());
        DAOUtil.setPreparedValues(preparedStatement, object.getValues());
        return preparedStatement;
    }


}
