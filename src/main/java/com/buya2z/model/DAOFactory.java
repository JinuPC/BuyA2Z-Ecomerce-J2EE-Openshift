package com.buya2z.model;

import com.buya2z.model.jdbcimpl.CategoryDAOImpl;
import com.buya2z.model.jdbcimpl.ImageDAOImpl;
import com.buya2z.model.jdbcimpl.ProductDAOImpl;
import com.buya2z.model.jdbcimpl.UserDAOImpl;

/**
 * Created by Jinu on 12/24/2016.
 */
public class DAOFactory {

    private DAOFactory() {}

    public static CategoryDAO getCategoryDAO() {
        return CategoryDAOImpl.getInstance();
    }

    public static ProductDAO getProductDAO() {
        return new ProductDAOImpl();
    }

    public static ImageDAO getImageDAO() {
        return new ImageDAOImpl();
    }

    public static UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

}
