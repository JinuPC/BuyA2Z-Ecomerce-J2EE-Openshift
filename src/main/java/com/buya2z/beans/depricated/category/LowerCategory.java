package com.buya2z.beans.depricated.category;

/**
 * Created by Jinu on 12/24/2016.
 */
public class LowerCategory extends Category {

    private Category subCategory;

    private Category mainCategory;

    public Category getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Category subCategory) {
        this.subCategory = subCategory;
    }

    public Category getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(Category mainCategory) {
        this.mainCategory = mainCategory;
    }
}
