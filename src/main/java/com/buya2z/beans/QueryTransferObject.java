package com.buya2z.beans;

import java.util.List;

/**
 * Created by Jinu on 12/26/2016.
 */
public class QueryTransferObject {
    private String query;
    private List values;

    public QueryTransferObject(String query, List values) {
        this.query = query;
        this.values = values;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List getValues() {
        return values;
    }

    public void setValues(List values) {
        this.values = values;
    }
}
