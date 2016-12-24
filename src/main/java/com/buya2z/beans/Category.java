package com.buya2z.beans;

import java.util.Date;

/**
 * Created by Jinu on 12/24/2016.
 */
public class Category {

    private int id;

    private int parentId;

    private String name;

    private CategoryType type;

    private Date createdAt;

    private Date updatedAt;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
