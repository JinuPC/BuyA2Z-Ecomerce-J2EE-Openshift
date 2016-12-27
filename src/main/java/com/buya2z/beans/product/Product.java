package com.buya2z.beans.product;

import com.buya2z.beans.AbstractBean;
import com.buya2z.beans.QueryTransferObject;
import com.buya2z.beans.category.Category;
import com.buya2z.beans.user.User;
import com.buya2z.config.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinu on 12/26/2016.
 */
public class Product extends AbstractBean{

    private int id;

    private int createdUserId;

    private String name;

    private User createdBy;

    private Category category;

    private int categoryId;

    private String shortDescription;

    private String thumbnail;

    private boolean onStock;

    private boolean active;

    private double mrp;

    private String specialNotes;

    private ProductRating rating;

    private List<ProductImage> images;

    private List<MainFeature> mainFeatures;

    private List<Feature> features;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id <= 0) {
            throw new RuntimeException("Product id should be greater than 0");
        }
        this.id = id;
    }

    public int getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(int createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isOnStock() {
        return onStock;
    }

    public void setOnStock(boolean onStock) {
        this.onStock = onStock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public ProductRating getRating() {
        return rating;
    }

    public void setRating(ProductRating rating) {
        this.rating = rating;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public List<MainFeature> getMainFeatures() {
        return mainFeatures;
    }

    public void setMainFeatures(List<MainFeature> mainFeatures) {
        this.mainFeatures = mainFeatures;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public QueryTransferObject getProductCreateQuery() {
        ArrayList values = new ArrayList();
        int count = 0;
        StringBuilder query = new StringBuilder("INSERT INTO " + DatabaseTable.getProductTableName() + " ( ");
        query.append("onStock, ");
        count ++;
        values.add(isOnStock());
        query.append("active, ");
        count ++;
        values.add(isActive());

        if(isIntegerPropertyAssigned(getId())) {
            query.append("product_id, ");
            count ++;
            values.add(getId());
        }

        if(isStringPropertyAssigned(getName())) {
            query.append("product_name, ");
            count ++;
            values.add(getName());
        }

        if(isDoublePropertyAssigned(getMrp())) {
            query.append("mrp, ");
            count ++;
            values.add(getMrp());
        }

        if(isStringPropertyAssigned(getShortDescription())) {
            query.append("product_short_desc, ");
            count++;
            values.add(getShortDescription());
        }
        if(isStringPropertyAssigned(getThumbnail())) {
            query.append("product_thumbnail, ");
            count ++;
            values.add(getThumbnail());
        }
        if(isStringPropertyAssigned(getSpecialNotes())) {
            query.append("special_notes, ");
            count++;
            values.add(getSpecialNotes());
        }
        if(isIntegerPropertyAssigned(getCreatedBy().getId())) {
            query.append("created_by, ");
            count++;
            values.add(getCreatedBy().getId());
        }

        if(isIntegerPropertyAssigned(getCategory().getId())) {
            query.append("category_id, ");
            count ++;
            values.add(getCategory().getId());
        }
        count += setTimeStampForCreate(query, values);
        query.append( ") VALUES (");
        for(int i = 1; i <= count; i++) {
            query.append("?,");
        }
        String queryString = query.substring(0, query.length()-1) + ")";
        return new QueryTransferObject(queryString, values);
    }

}
