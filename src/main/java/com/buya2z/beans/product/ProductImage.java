package com.buya2z.beans.product;

import com.buya2z.beans.AbstractBean;

/**
 * Created by Jinu on 12/26/2016.
 */
public class ProductImage extends AbstractBean {

    private int id;

    private String url;

    private boolean isPrimary;

    private int productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
