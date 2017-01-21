package com.buya2z.model.jdbcimpl;

import com.buya2z.beans.depricated.category.Category;
import com.buya2z.beans.depricated.category.MainCategory;
import com.buya2z.beans.depricated.category.SubCategory;
import com.buya2z.model.CategoryList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinu on 12/24/2016.
 */
public class CategoryListImpl implements CategoryList{

    private final ArrayList<Category> CATEGORIES;

    CategoryListImpl(ArrayList<Category> categories) {
        this.CATEGORIES = categories;
    }

    @Override
    public Category getCategory(int id) {
        return findCategory(id);
    }

    @Override
    public Category getCategory(String name) {
        return findCategory(name);
    }

    @Override
    public List<Category> getMainCategories() {
        return new ArrayList<Category>(CATEGORIES);
    }

    @Override
    public List<Category> getSubCategories() {
        ArrayList<Category> subCategories = new ArrayList<>();
        for(Category c : CATEGORIES) {
            MainCategory mainCategory = (MainCategory) c;
            subCategories.addAll(mainCategory.getSubCategories());
        }
        return subCategories;
    }

    @Override
    public List<Category> getLowerCategories() {
        List<Category> lowerCategories = new ArrayList<>();
        for(Category c : getSubCategories()) {
            SubCategory subCategory = (SubCategory) c;
            lowerCategories.addAll(subCategory.getLowerCategories());
        }
        return lowerCategories;
    }


    private Category findCategory(int id) {
        for(Category mainCategory : CATEGORIES) {
            if(mainCategory.getId() == id) {
                return mainCategory;
            }
            for(Category subCategory : ((MainCategory)mainCategory).getSubCategories()) {
                if (subCategory.getId() == id) {
                    return subCategory;
                }
                for(Category lowerCategory : ((SubCategory)subCategory).getLowerCategories()) {
                    if(lowerCategory.getId() == id) {
                        return lowerCategory;
                    }
                }
            }
        }
        return null;
    }

    private Category findCategory(String name) {
        for(Category mainCategory : CATEGORIES) {
            if(mainCategory.getName().equalsIgnoreCase(name)) {
                return mainCategory;
            }
            for(Category subCategory : ((MainCategory)mainCategory).getSubCategories()) {
                if (subCategory.getName().equalsIgnoreCase(name)) {
                    return subCategory;
                }
                for(Category lowerCategory : ((SubCategory)subCategory).getLowerCategories()) {
                    if(lowerCategory.getName().equalsIgnoreCase(name)) {
                        return lowerCategory;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return CATEGORIES.toString();
    }
}
