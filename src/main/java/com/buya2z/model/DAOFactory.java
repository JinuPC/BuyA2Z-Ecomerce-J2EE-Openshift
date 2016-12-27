package com.buya2z.model;

import com.buya2z.beans.product.Product;
import com.buya2z.model.impl.CategoryDAOImpl;
import com.buya2z.model.impl.ImageDAOImpl;
import com.buya2z.model.impl.ProductDAOImpl;

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

//    public static ImageDAO getImageDAO() {
//        //return new ImageDAOImpl();
//    }

}
