package com.buya2z.beans.product;

import com.buya2z.beans.AbstractBean;

/**
 * Created by Jinu on 12/26/2016.
 */
public class MainFeature extends AbstractBean {

    private int productId;

    private int id;

    private String title;

    private String descrption;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }
}
