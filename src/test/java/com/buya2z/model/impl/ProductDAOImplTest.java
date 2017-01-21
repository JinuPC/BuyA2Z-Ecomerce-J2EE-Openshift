package com.buya2z.model.impl;

import com.buya2z.TestInitializer;
import com.buya2z.app.Application;
import com.buya2z.beans.depricated.category.Category;
import com.buya2z.beans.depricated.product.Feature;
import com.buya2z.beans.depricated.product.MainFeature;
import com.buya2z.beans.depricated.product.Product;
import com.buya2z.beans.depricated.product.ProductImage;
import com.buya2z.beans.depricated.user.Seller;
import com.buya2z.model.DAOFactory;
import com.buya2z.model.ProductDAO;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.fail;

/**
 * Created by Jinu on 12/26/2016.
 */
public class ProductDAOImplTest {
    private final Logger LOGGER = Logger.getLogger(ProductDAOImplTest.class);
    private final ProductDAO productDAO = DAOFactory.getProductDAO();

    public ProductDAOImplTest() {
        TestInitializer.initialize();
    }

    private Product getTestProduct(int id) {
        Category category = Application.getInstance().getCategoryList().getCategory(101);
        Seller user = new Seller();
        user.setId(2);
        Product product = new Product();
        if(id > 0) {
            product.setId(id);
        }
        product.setName("Test Product");
        product.setShortDescription("This is a testing description");
        product.setThumbnail("some/url");
        product.setCreatedUserId(2);
        product.setMrp(2345.45);
        product.setSpecialNotes("nothing");
        product.setCategory(category);
        product.setCreatedBy(user);
        return product;
    }

    private ProductImage getTestImage(int diff) {
        ProductImage productImage = new ProductImage();
        productImage.setUrl("slkfdkj/dsklf/sdfj/" + diff);
        productImage.setPrimary(false);
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("image" + diff + ".gif");
        productImage.setReader(is);
        return productImage;
    }

    private Feature getTestFeature(int diff) {
        Feature feature = new Feature();
        feature.setTitle("sdlkjfklsjd" + diff);
        feature.setDescription("didksfjjcreiptin" + diff);
        feature.setSpecificationId(1);
        return feature;
    }

    private MainFeature getTestMainFeature(int diff) {
        MainFeature feature = new MainFeature();
        feature.setDescription("kdslafjdlksjdf" + diff);
        feature.setTitle("lkasjdfkljsf" + diff);
        return feature;
    }

    @Test
    public void testGetCreateQueryInProduct() {
        LOGGER.info("Tesing getCreateQuery() in Product class");
        String expected = "INSERT INTO product ( onStock, " +
                "active, product_name, mrp, product_short_desc," +
                " product_thumbnail, special_notes, created_by, " +
                "category_id, created_at, updated_at) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        Product product = getTestProduct(33);
        String actual = product.getCreateQuery().getQuery();
        if (!expected.equalsIgnoreCase(actual)) {
            fail("Product Create Statement query not matching");
        }
    }

    @Test
    public void testGetCreateQueryInImage() {
        LOGGER.info("Tesing getCreateQuery() in Image class");
        ProductImage image = new ProductImage();
        image.setProductId(33);
        image.setPrimary(true);
        image.setUrl("image/url");
        String expected = "INSERT INTO product_image " +
                "( image_url, is_primary, product_id, created_at, updated_at) " +
                "VALUES (?,?,?,?,?)";
        if(!expected.equalsIgnoreCase(image.getCreateQuery().getQuery())) {
            fail("Test case failed at getCreateQuery() in image");
        }

    }

    @Test
    public void testGetCreateQueryInFeature() {
        LOGGER.info("Tesing getCreateQuery() in Feature class");
        Feature feature = new Feature();
        feature.setProductId(33);
        feature.setSpecificationId(3);
        feature.setTitle("color");
        feature.setDescription("blue");
        String expected = "INSERT INTO feature ( feature_title, product_id," +
                " feature_desc, specification_id," +
                " created_at, updated_at) VALUES (?,?,?,?,?,?)";
        System.out.println(feature.getCreateQuery().getQuery());
        if (!expected.equals(feature.getCreateQuery().getQuery())) {
            fail("Feature getCreateQuery is not matching with test object");
        }
    }

    @Test
    public void testGetCreateQueryInMainFeature() {
        LOGGER.info("Tesing getCreateQuery() in MainFeature class");
        MainFeature mainFeature = new MainFeature();
        mainFeature.setProductId(33);
        mainFeature.setDescription("Main feature Description");
        mainFeature.setTitle("main feature title");
        String expected = "INSERT INTO main_feature ( product_id, main_feature_title," +
                " main_feature_desc, created_at, updated_at) VALUES (?,?,?,?,?)";
        if(!expected.equalsIgnoreCase(mainFeature.getCreateQuery().getQuery())) {
            fail("Test case failed in getCreateQuery in MainFeature");
        }
    }

    @Test
    public void testCreate() {

    }
    @Test
    public void testGetAutoIncrementValue() {
//        String tableName = DatabaseTable.getProductTableName();
//        try {
//            //System.out.println(Database.getAutoIncrementedValue(tableName));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
