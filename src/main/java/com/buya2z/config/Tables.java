package com.buya2z.config;


import java.util.*;

/**
 * Created by Jinu on 11/27/2016.
 */
class Tables {
    private Map<String, String> tableSchema;

    Tables() {
        tableSchema = new HashMap<>();
        initTables();
    }

    public Map<String, String> getTableSchema() {
        return this.tableSchema;
    }

    /*
     * Define Database Schema here
     * call addTable method for add new Table with table name and columns
     * with constraints and data type.
     *
     */
    private void initTables() {
        addTable("products", setSchema(
                "id int primary key",
                "name varchar(255) not null"
        ));
        addTable("user", setSchema(
                "id int primary key",
                "name varchar(255) not null"
        ));

    }

    private void addTable(String tableName, String schema) {
        String query = makeQuery(tableName, schema);
        tableSchema.put(tableName, query);
    }

    private String setSchema(String... columns) {
        StringBuilder schema = new StringBuilder(" ( ");
        for(String column : columns) {
            schema.append(" " + column + " ,");
        }
        schema.setLength(schema.length() - 1);
        schema.append(" )");

        return schema.toString();
    }

    private String makeQuery(String tableName, String schema) {
        return "CREATE TABLE " + tableName + " " + schema;
    }

    public String toString() {
        return tableSchema.toString();
    }
}
