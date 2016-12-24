package com.buya2z.beans;


import java.util.ArrayList;

/**
 * Created by Jinu on 12/24/2016.
 */
public class SubCategory extends Category{

    private Category mainCategory ;

    private ArrayList<Category> lowerCategories = new ArrayList<>();

    public Category getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(Category mainCategory) {
        this.mainCategory = mainCategory;
    }

    public ArrayList<Category> getLowerCategories() {
        return lowerCategories;
    }

    public void setLowerCategories(ArrayList<Category> lowerCategories) {
        this.lowerCategories = lowerCategories;
    }

    public void setLowerCategory(Category category) {
        this.lowerCategories.add(category);
    }

    public boolean hasLowerCategories() { return !lowerCategories.isEmpty(); }

    @Override
    public String toString() {
        return super.toString() + (hasLowerCategories() ?" { LOWER-CATEGORIES ==> " + this.lowerCategories +"}" : "");
    }

}
