package com.buya2z.beans.product;

import com.buya2z.beans.AbstractBean;
import com.buya2z.beans.QueryTransferObject;
import com.buya2z.config.DatabaseTable;

import java.util.ArrayList;

/**
 * Created by Jinu on 12/26/2016.
 */
public class MainFeature extends AbstractBean {

    private int productId;

    private int id;

    private String title;

    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QueryTransferObject getCreateQuery() {
        ArrayList values = new ArrayList();
        int count = 0;
        StringBuilder query = new StringBuilder("INSERT INTO " + DatabaseTable.getMainFeatureTableName() + " ( ");
        if(isIntegerPropertyAssigned(this.productId)) {
            query.append("product_id, ");
            count++;
            values.add(this.productId);
        }
        if(isStringPropertyAssigned(this.title)) {
            query.append("main_feature_title, ");
            values.add(this.title);
            count ++;
        }
        if(isStringPropertyAssigned(this.description)) {
            query.append("main_feature_desc, ");
            count++;
            values.add(this.description);
        }
        count += setTimeStampForCreate(query, values);
        closeQueryString(count, query);
        return new QueryTransferObject(query.toString(), values);
    }
}
