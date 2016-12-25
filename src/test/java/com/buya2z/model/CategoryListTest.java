package com.buya2z.model;

import com.buya2z.TestInitializer;
import com.buya2z.beans.category.Category;
import org.junit.Test;

import java.util.List;
import org.apache.log4j.Logger;

import static org.junit.Assert.*;

/**
 * Created by Jinu on 12/24/2016.
 */
public class CategoryListTest {
    private final Logger LOGGER = Logger.getLogger(CategoryListTest.class);
    private CategoryDAO categoryDAO ;
    private CategoryList categoryList ;

    public CategoryListTest() {
        TestInitializer.initialize();
        categoryDAO = DAOFactory.getCategoryDAO();
        categoryList = categoryDAO.getCategoryList();
    }
    @Test
    public void testGetMainCategories() {
        LOGGER.info("Testing GetMainCategories in " + CategoryList.class);
        List<Category> mainCategories = categoryList.getMainCategories();
        //System.out.println(mainCategories);
        if(mainCategories.isEmpty()) {
            fail("Main Category list is empty");
        }
        for(Category c : mainCategories) {
            if(!c.isMainCategory()) {
                fail("Category is not a main Type");
            }
        }
        LOGGER.info("Completed.....");
    }

    @Test
    public void testGetSubCategories() {
        LOGGER.info("Testing getSubCategories in " + CategoryList.class);
        List<Category> subCategories = categoryList.getSubCategories();
        if(subCategories.isEmpty()) {
            fail("SubCategory List is empty");
        }
        for(Category c : subCategories) {
            if(!c.isSubCategory()) {
                fail("Category is not a Sub Type");
            }
        }
        LOGGER.info("Completed.....");
    }

    @Test
    public void testGetLowerCategories() {
        LOGGER.info("Testing getLowerCategories in " + CategoryList.class);
        List<Category> lowerCategories = categoryList.getLowerCategories();
        if(lowerCategories.isEmpty()) {
            fail("SubCategory List is empty");
        }
        for(Category c : lowerCategories) {
            if(!c.isLowerCategory()) {
                fail("Category is not a Sub Type");
            }
        }
        //System.out.println(lowerCategories);
        LOGGER.info("Completed.....");
    }

    @Test
    public void testGetCategory() {
        LOGGER.info("Testing getCategory() in " + CategoryList.class);
        Category categoryWithId = categoryList.getCategory(5);
        assertEquals(5, categoryWithId.getId());
        Category categoryWithName = categoryList.getCategory("MEN");
        assertTrue("MEN".equalsIgnoreCase(categoryWithName.getName()));
    }


}
