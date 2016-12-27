package com.buya2z.beans.product;

import com.buya2z.beans.AbstractBean;
import com.buya2z.beans.QueryTransferObject;
import com.buya2z.config.DatabaseTable;

import java.util.ArrayList;

/**
 * Created by Jinu on 12/26/2016.
 */
public class Feature extends AbstractBean {
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
        int count = 0;
        StringBuilder query = new StringBuilder("INSERT INTO " + DatabaseTable.getFeatureTableName() + " ( ");
        if(isStringPropertyAssigned(this.title)) {
            query.append("feature_title, ");
            values.add(this.title);
            count ++;
        }
        if(isIntegerPropertyAssigned(this.productId)) {
            query.append("product_id, ");
            count++;
            values.add(this.productId);
        }
        if(isStringPropertyAssigned(this.description)) {
            query.append("feature_desc, ");
            count++;
            values.add(this.description);
        }
        if(isIntegerPropertyAssigned(this.specificationId)) {
            query.append("specification_id, ");
            count++;
            values.add(this.specificationId);
        }
        count += setTimeStampForCreate(query, values);
        closeQueryString(count, query);
        return new QueryTransferObject(query.toString(), values);
    }
}
