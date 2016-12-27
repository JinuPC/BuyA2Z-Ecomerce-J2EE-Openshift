package com.buya2z.beans;

import com.buya2z.beans.product.ProductImage;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Jinu on 12/26/2016.
 */
public abstract class AbstractBean {

    private Date createdAt;

    private Date updatedAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public abstract QueryTransferObject getCreateQuery();

    public boolean validate() {
        return false;
    }

    protected boolean isStringPropertyAssigned(String value) {
        if(value == null) {
            return false;
        }
        if(value.isEmpty()) {
            return false;
        }
        return true;
    }

    protected boolean isIntegerPropertyAssigned(int value) {
        if(value <= 0) {
            return false;
        }
        return true;
    }

    protected boolean isBooleanPropertyAssigned(boolean value) {
        return value;
    }

    protected boolean isDoublePropertyAssigned(double value) {
        if(value > 0) {
            return true;
        }
        return false;
    }

    protected int setTimeStampForCreate(StringBuilder query , List values) {
        int count = 0;
        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        query.append("created_at, ");
        values.add(timestamp);
        count ++;
        query.append("updated_at");
        count ++;
        values.add(timestamp);
        return count;
    }

    protected void closeQueryString(int count, StringBuilder query) {
        query.append( ") VALUES (");
        for(int i = 1; i <= count; i++) {
            query.append("?,");
        }
        query.setLength(query.length() - 1 );
        query.append(")");
    }

    protected boolean validateList(List<? extends AbstractBean> beans) {
        for(AbstractBean bean : beans) {
            if(!bean.validate()) {
                return false;
            }
        }
        return true;
    }
}
