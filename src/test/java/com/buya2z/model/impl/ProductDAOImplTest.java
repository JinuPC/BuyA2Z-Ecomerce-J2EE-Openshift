package com.buya2z.model.impl;

import com.buya2z.TestInitializer;
import com.buya2z.app.Application;
import com.buya2z.beans.QueryTransferObject;
import com.buya2z.beans.category.Category;
import com.buya2z.beans.product.Product;
import com.buya2z.beans.user.Seller;
import com.buya2z.beans.user.User;
import com.buya2z.model.DAOFactory;
import com.buya2z.model.ProductDAO;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Jinu on 12/26/2016.
 */
public class ProductDAOImplTest {
    private final ProductDAO productDAO = DAOFactory.getProductDAO();

    public ProductDAOImplTest() {
        TestInitializer.initialize();
    }

    private Product getTestProduct(int id) {
        Category category = Application.getInstance().getCategoryList().getCategory(101);
        System.out.println(category);
        User user = new Seller();
        user.setId(2);
        Product product = new Product();
        product.setId(id);
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

    @Test
    public void testCreate() {
//        for (int i = 1000; i<= 1004 ; i++) {
//            Connection connection =
//        }

    }

    @Test
    public void testGetProductCreateStatement() {

        Product product = new Product();
        product.setId(454);
        product.setName("Test Product");
        product.setShortDescription("This is a testing description");
        product.setThumbnail("some/url");
        product.setMrp(2345.45);
        product.setSpecialNotes("nothing");
        product.setCategoryId(101);
        QueryTransferObject qtj = product.getProductCreateQuery();
        System.out.println(qtj.getQuery());
        System.out.println(qtj.getValues());
    }
}
