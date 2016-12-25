package com.buya2z.model;

import com.buya2z.beans.category.Category;

import java.util.List;

/**
 * Created by Jinu on 12/24/2016.
 */
public interface CategoryList {

    public List<Category> getMainCategories();
    public List<Category> getSubCategories();
    public List<Category> getLowerCategories();
    public Category getCategory(int id);
    public Category getCategory(String name);

}
