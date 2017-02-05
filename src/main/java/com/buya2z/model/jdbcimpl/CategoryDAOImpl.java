package com.buya2z.model.jdbcimpl;

import com.buya2z.beans.depricated.category.*;
import com.buya2z.config.depricated.Database;
import com.buya2z.model.CategoryDAO;
import com.buya2z.model.CategoryList;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jinu on 12/24/2016.
 */
public class CategoryDAOImpl implements CategoryDAO {

    private static final CategoryDAOImpl CATEGORY_DAO_INSTANCE = new CategoryDAOImpl();

    private final Logger LOGGER = Logger.getLogger(CategoryDAOImpl.class);

    private final ArrayList<Category> CATEGORIES;

    private CategoryDAOImpl() {
        CATEGORIES = new ArrayList<>();
        initCategoryList();
    }

    private void initCategoryList() {
        CATEGORIES.clear();
        LOGGER.info("Initializing Category List");
        fetchCategories();
        LOGGER.info("Categories initialized : \n" );
    }

    @Override
    public CategoryList getCategoryList() {
        return new CategoryListImpl(CATEGORIES);
    }

    private void fetchCategories() {
        LOGGER.info("Getting All Categories");
        Connection connection = Database.getConnection();
        String query = "SELECT * FROM category ORDER BY parent_category_id";
        LOGGER.info("Trying to get all Category from database");
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            fillCategoryInArrayList(rs);
        } catch (SQLException e) {
            LOGGER.error("Exception Happened", e);
        } finally {
            Database.close(connection);
        }
    }

    private void fillCategoryInArrayList(ResultSet rs) throws SQLException{
        Map<Integer, Category> categoryMap = new HashMap<>();
        while (rs.next()) {
            Category currentCategory = getCategory(rs);
            categoryMap.put(currentCategory.getId(), currentCategory);
            if(currentCategory.isMainCategory()) {
                CATEGORIES.add(currentCategory);
            }
            if(currentCategory.isSubCategory()) {
                MainCategory mainCategory = (MainCategory) categoryMap.get(currentCategory.getParentId());
                mainCategory.setSubCategory(currentCategory);
                ((SubCategory) currentCategory).setMainCategory(mainCategory);
            }
            if(currentCategory.isLowerCategory()) {
                SubCategory subCategory = (SubCategory) categoryMap.get(currentCategory.getParentId());
                subCategory.setLowerCategory(currentCategory);
                ((LowerCategory) currentCategory).setSubCategory(subCategory);
                ((LowerCategory) currentCategory).setMainCategory(subCategory.getMainCategory());
            }
        }
    }

    private Category getCategory(ResultSet rs) throws SQLException{
        Category category = null;
        String categoryType = rs.getString("category_type");
        if(categoryType.equals("main")) {
            category = new MainCategory();
            category.setType(CategoryType.MAIN);
        } else if(categoryType.equals("sub")) {
            category = new SubCategory();
            category.setType(CategoryType.SUB);
        } else if(categoryType.equals("lower")) {
            category = new LowerCategory();
            category.setType(CategoryType.LOWER);
        }
        category.setId(rs.getInt("category_id"));
        category.setParentId(rs.getInt("parent_category_id"));
        category.setName(rs.getString("category_name"));
        category.setCreatedAt(rs.getTimestamp("created_at"));
        category.setUpdatedAt(rs.getTimestamp("updated_at"));
        LOGGER.info("New Category Created " + category.getName());
        return category;
    }

    public static CategoryDAO getInstance() {
        return CATEGORY_DAO_INSTANCE;
    }
}
