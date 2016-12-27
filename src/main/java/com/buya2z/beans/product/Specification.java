package com.buya2z.beans.product;

import com.buya2z.beans.AbstractBean;

/**
 * Created by Jinu on 12/26/2016.
 */
public class Specification extends AbstractBean{
    private int id;

    private String name;

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
}
