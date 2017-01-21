package com.buya2z.beans.depricated.category;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Jinu on 12/26/2016.
 */
public abstract class AbstractBean {

    private Timestamp createdAt;

    private Timestamp updatedAt;

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
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
        return !value.isEmpty();
    }

    protected boolean isIntegerPropertyAssigned(int value) {
        return value > 0;
    }

   protected boolean isBooleanPropertyAssigned(boolean value) {
        return value;
    }

    protected boolean isDoublePropertyAssigned(double value) {
        return value > 0;
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

    protected void putCreationTimestamp(Map<String, Object> columnWithValues) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        columnWithValues.put("created_at", timestamp);
    }
}
