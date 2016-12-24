package com.buya2z.model;

import com.buya2z.model.impl.CategoryDAOImpl;

/**
 * Created by Jinu on 12/24/2016.
 */
public class DAOFactory {

    private DAOFactory() {}

    public CategoryDAO getCategoryDAO() {
        return CategoryDAOImpl.getInstance();
    }

}
