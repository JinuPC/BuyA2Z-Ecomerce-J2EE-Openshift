package com.buya2z.beans.depricated.product;

import com.buya2z.beans.depricated.category.AbstractBean;
import com.buya2z.beans.depricated.category.QueryTransferObject;

import java.util.List;

/**
 * Created by Jinu on 12/26/2016.
 */
public class ProductRating extends AbstractBean {

    private int productId;

    private int ratingId;

    private int stars;

    private List<Comment> comments;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public QueryTransferObject getCreateQuery() {
        return null;
    }

}
