package com.buya2z.beans;

import java.util.ArrayList;

/**
 * Created by Jinu on 12/24/2016.
 */
public class MainCategory extends Category{

    private ArrayList<Category> subCategories = new ArrayList<>();

    public ArrayList<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(ArrayList<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public void setSubCategory(Category subCategory) {
        this.subCategories.add(subCategory);
    }

    public boolean hasSubCategories() {
        return !this.subCategories.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString() + (this.hasSubCategories() ? " { SUB-CATEGORIES ===> "+ this.subCategories +" } " : "") + "\n";
    }
}
