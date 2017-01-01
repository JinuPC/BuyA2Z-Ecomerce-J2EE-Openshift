package com.buya2z.beans.product;

import com.buya2z.beans.AbstractBean;
import com.buya2z.beans.QueryTransferObject;
import com.buya2z.config.DatabaseTable;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Jinu on 12/26/2016.
 */
public class MainFeature extends AbstractBean {

    private final Logger LOGGER = Logger.getLogger(MainFeature.class);

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
        StringBuilder query = new StringBuilder("INSERT INTO " + DatabaseTable.getMainFeatureTableName() + " ( ");
        query.append("product_id, ");
        values.add(this.productId);
        query.append("main_feature_title, ");
        values.add(this.title);
        query.append("main_feature_desc, ");
        values.add(this.description);
        setTimeStampForCreate(query, values);
        closeQueryString(values.size(), query);
        return new QueryTransferObject(query.toString(), values);
    }

    @Override
    public boolean validate() {
        boolean isValid = true;
        if( !isStringPropertyAssigned(this.title) ) {
            LOGGER.info("MainFeature Validation failed: title is not assigned");
            isValid = false;
        }
        if( !isStringPropertyAssigned(this.description) ) {
            LOGGER.info("MainFeature Validation failed: Description is not assigned");
            isValid = false;
        }
        return isValid;
    }
}
