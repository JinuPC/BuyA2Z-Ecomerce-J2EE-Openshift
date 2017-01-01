package com.buya2z.beans.product;

import com.buya2z.beans.AbstractBean;
import com.buya2z.beans.QueryTransferObject;

import java.util.Date;

/**
 * Created by Jinu on 12/26/2016.
 */
public class Comment extends AbstractBean{

    private int id;

    private String title;

    private String description;

    private int ratingId;

    public long getId() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    @Override
    public QueryTransferObject getCreateQuery() {
        return null;
    }
}
