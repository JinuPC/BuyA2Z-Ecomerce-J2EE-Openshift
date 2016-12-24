package com.buya2z.model.impl;

import com.buya2z.config.Database;
import com.buya2z.model.CategoryDAO;
import org.junit.Test;

/**
 * Created by Jinu on 12/24/2016.
 */
public class CategoryDAOImplTest {
    @Test
    public void testGetAll() {
        Database.init();
        CategoryDAO categoryDAO = CategoryDAOImpl.getInstance();
        System.out.println(categoryDAO.getAll());
    }
}
