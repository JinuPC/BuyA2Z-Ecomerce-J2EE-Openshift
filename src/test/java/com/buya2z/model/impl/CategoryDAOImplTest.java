package com.buya2z.model.impl;

import com.buya2z.TestInitializer;
import com.buya2z.model.CategoryDAO;
import com.buya2z.model.jdbcimpl.CategoryDAOImpl;
import org.junit.Test;

/**
 * Created by Jinu on 12/24/2016.
 */
public class CategoryDAOImplTest {

    public CategoryDAOImplTest() {
        TestInitializer.initialize();
    }
    @Test
    public void testGetAll() {

        CategoryDAO categoryDAO = CategoryDAOImpl.getInstance();
        //System.out.println(categoryDAO.getAll());
    }
}
