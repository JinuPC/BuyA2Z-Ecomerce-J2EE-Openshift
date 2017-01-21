package com.buya2z.beans.depricated.product;

import com.buya2z.beans.depricated.category.AbstractBean;
import com.buya2z.beans.depricated.category.QueryTransferObject;
import com.buya2z.config.DatabaseTable;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Jinu on 12/26/2016.
 */
public class Feature extends AbstractBean {

    private final Logger LOGGER = Logger.getLogger(Feature.class);

    private int id;

    private int productId;

    private int specificationId;

    private String title;

    private String description;

    private String specificationName;

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

    public int getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(int specificationId) {
        this.specificationId = specificationId;
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

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    public QueryTransferObject getCreateQuery() {
        ArrayList values = new ArrayList();
        StringBuilder query = new StringBuilder("INSERT INTO " + DatabaseTable.getFeatureTableName() + " ( ");
        query.append("feature_title, ");
        values.add(this.title);
        query.append("product_id, ");
        values.add(this.productId);
        query.append("feature_desc, ");
        values.add(this.description);
        query.append("specification_id, ");
        values.add(this.specificationId);
        setTimeStampForCreate(query, values);
        closeQueryString(values.size(), query);
        return new QueryTransferObject(query.toString(), values);
    }

    @Override
    public boolean validate() {
        boolean isValid = true;
        if( !isStringPropertyAssigned(this.title) ) {
            LOGGER.info("Feature Validation failed: title is not assigned");
            isValid = false;
        }
        if( !isStringPropertyAssigned(this.description) ){
            LOGGER.info("Feature Validation failed: description is not assigned");
            isValid = false;
        }
        if( !isIntegerPropertyAssigned(this.specificationId) ) {
            LOGGER.info("Feature Validation failed: Specification id is not assigned");
            isValid = false;
        }
        return isValid;
    }
}
