package com.buya2z.beans.product;

import com.buya2z.beans.AbstractBean;

/**
 * Created by Jinu on 12/26/2016.
 */
public class Warranty extends AbstractBean {
    private int id;

    private int productId;

    private String summary;

    private String type;

    private String covered;

    private String notCovered;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCovered() {
        return covered;
    }

    public void setCovered(String covered) {
        this.covered = covered;
    }

    public String getNotCovered() {
        return notCovered;
    }

    public void setNotCovered(String notCovered) {
        this.notCovered = notCovered;
    }
}
