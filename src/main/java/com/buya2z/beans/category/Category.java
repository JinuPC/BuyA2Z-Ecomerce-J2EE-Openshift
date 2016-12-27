package com.buya2z.beans.category;

import com.buya2z.beans.AbstractBean;

import java.util.Date;

/**
 * Created by Jinu on 12/24/2016.
 */
public class Category extends AbstractBean{

    private int id;

    private int parentId;

    private String name;

    private CategoryType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public boolean isSubCategory() {
        return type == CategoryType.SUB;
    }

    public boolean isMainCategory() {
        return type == CategoryType.MAIN;
    }

    public boolean isLowerCategory() {
        return type == CategoryType.LOWER;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
