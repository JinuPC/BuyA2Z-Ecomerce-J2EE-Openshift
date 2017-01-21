package com.buya2z.beans.depricated.product;

import com.buya2z.app.Application;
import com.buya2z.beans.depricated.category.AbstractBean;
import com.buya2z.beans.depricated.category.QueryTransferObject;
import com.buya2z.beans.depricated.category.Category;
import com.buya2z.beans.depricated.user.Seller;
import com.buya2z.beans.depricated.user.User;
import com.buya2z.config.DatabaseTable;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinu on 12/26/2016.
 */
public class Product extends AbstractBean {

    private final Logger LOGGER = Logger.getLogger(Product.class);

    private int id;

    private int createdUserId;

    private String name;

    private Seller createdBy;

    private Category category;

    private int categoryId;

    private String shortDescription;

    private String thumbnail;

    private boolean onStock;

    private boolean active;

    private double mrp;

    private String specialNotes;

    private int stars;

    private List<ProductRating> ratings;

    private List<ProductImage> images;

    private List<MainFeature> mainFeatures;

    private List<Feature> features;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new RuntimeException("Product id should be greater than 0");
        }
        this.id = id;
        setProductIdToImages();
        setProductIdToFeatures();
        setProductIdToMainFeatures();
        setProductIdToRatings();
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

    public void setCreatedBy(Seller createdBy) {
        this.createdBy = createdBy;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        if (category != null) {
            this.categoryId = category.getId();
        }
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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public List<ProductRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<ProductRating> ratings) {
        this.ratings = ratings;
        setProductIdToRatings();
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
        setProductIdToImages();
    }

    public List<MainFeature> getMainFeatures() {
        return mainFeatures;
    }

    public void setMainFeatures(List<MainFeature> mainFeatures) {
        this.mainFeatures = mainFeatures;
        setProductIdToMainFeatures();
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
        setProductIdToFeatures();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        Category category = Application.getInstance().getCategoryList().getCategory(categoryId);
        if (category != null) {
            this.category = category;
            this.categoryId = category.getId();
        } else {
            throw new RuntimeException("Category id assigned is not valid");
        }
    }

    public QueryTransferObject getCreateQuery() {
        ArrayList values = new ArrayList();
        StringBuilder query = new StringBuilder("INSERT INTO " + DatabaseTable.getProductTableName() + " ( ");
        query.append("onStock, active, product_name, mrp, product_short_desc, product_thumbnail, special_notes, " +
                "created_by, category_id, ");
        values.add(isOnStock());
        values.add(isActive());
        values.add(getName());
        values.add(getMrp());
        values.add(getShortDescription());
        values.add(getThumbnail());
        values.add(getSpecialNotes());
        values.add(getCreatedBy().getId());
        values.add(getCategory().getId());
        setTimeStampForCreate(query, values);
        closeQueryString(values.size(), query);
        return new QueryTransferObject(query.toString(), values);
    }

    private void setProductIdToImages() {
        if (this.mainFeatures != null) {
            for (ProductImage image : this.images) {
                image.setProductId(this.id);
            }
        }
    }

    private void setProductIdToMainFeatures() {
        if (this.mainFeatures != null) {
            for (MainFeature feature : this.mainFeatures) {
                feature.setProductId(this.id);
            }
        }
    }

    private void setProductIdToFeatures() {
        if (this.features != null) {
            for (Feature feature : this.features) {
                feature.setProductId(this.id);
            }
        }
    }

    private void setProductIdToRatings() {
        if (this.ratings != null) {
            for (ProductRating rating : ratings) {
                rating.setProductId(this.id);
            }
        }
    }

    @Override
    public boolean validate() {
        boolean isValidate = true;
        if( !isStringPropertyAssigned(this.name) ) {
            LOGGER.info("Validation Failed At Product: Name not set");
            isValidate = false;
        }
        if( !isStringPropertyAssigned(this.shortDescription) ) {
            LOGGER.info("Validation Failed At Product: Short Description not set");
            isValidate = false;
        }
        if( !isDoublePropertyAssigned(this.mrp) ) {
            LOGGER.info("Validation Failed At Product: MRP not set");
            isValidate = false;
        }
        if( !isStringPropertyAssigned(this.specialNotes) ) {
            LOGGER.info("Validation Failed At Product: Special Notes not set");
            isValidate = false;
        }
        if( this.createdBy == null || !isIntegerPropertyAssigned(this.createdBy.getId() ) ) {
            LOGGER.info("Validation Failed At Product: Seller Details not set");
            isValidate = false;
        }
        if( !isIntegerPropertyAssigned(this.categoryId)) {
            LOGGER.info("Validation Failed At Product: Category not set");
            isValidate = false;
        }
        return isValidate;
    }

}
