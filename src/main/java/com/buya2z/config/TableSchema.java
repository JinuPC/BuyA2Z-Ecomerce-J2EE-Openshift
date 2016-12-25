package com.buya2z.config;


import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by Jinu on 11/27/2016.
 */
class TableSchema {

    private final Logger logger= Logger.getLogger(TableSchema.class);

    private Map<String, String> tableSchema;

    /*
     * Define Database Schema here
     * call addTable method for add new Table with table name and columns
     * with constraints and data type.
     *
     */
    private void setTableSchema() {
        addTable("user", setColumns(
                "user_id bigint primary key auto_increment",
                "first_name varchar(50) not null",
                "last_name varchar(50)",
                "email varchar(100) not null",
                "phone_number varchar(10) not null",
                "role varchar(10) not null",
                "password varchar(255) not null",
                "status tinyint(1) not null",
                "gender varchar(6) ",
                "updated_at Timestamp ",
                "created_at Timestamp"
        ));
        addTable("address", setColumns(
                "address_id bigint primary key auto_increment",
                "name varchar(50) not null",
                "street varchar(100) not null",
                "landmark varchar(255)",
                "city varchar(100) not null",
                "state varchar(30) not null",
                "pincode varchar(6) not null",
                "phone_number varchar(10)",
                "isdefault boolean",
                "updated_at Timestamp",
                "created_at Timestamp",
                "user_id bigint ",
                "FOREIGN KEY(user_id) REFERENCES user(user_id)"
        ));
        addTable("card", setColumns(
                "card_id bigint primary key auto_increment",
                "card_type varchar(10) not null",
                "card_number varchar(30) not null",
                "expiry_date Date not null",
                "name varchar(40) not null",
                "label varchar(50) not null",
                "updated_at Timestamp",
                "created_at Timestamp",
                "user_id bigint",
                "foreign key(user_id) references user(user_id)"
        ));
        addTable("seller", setColumns(
                "seller_id int primary key auto_increment",
                "tin_number varchar(11) not null",
                "pan_number varchar(10)",
                "company varchar(100)",
                "company_location varchar(100)",
                "business_email varchar(100)",
                "business_phone varchar(10)",
                "business_fax varchar(10)",
                "bank_name varchar(100)",
                "account_number varchar(55)",
                "ifsc_code varchar(11)",
                "bank_branch varchar(50)",
                "description text(50000)",
                "updated_at Timestamp",
                "created_at Timestamp",
                "user_id bigint ",
                "FOREIGN KEY(user_id) REFERENCES user(user_id)"
        ));
        addTable("category", setColumns(
                "category_id int primary key auto_increment",
                "category_name varchar(200) not null",
                "parent_category_id int",
                "category_type varchar(10) not null default 'LOWER' ",
                "updated_at timestamp",
                "created_at timestamp"
        ));
        addTable("product", setColumns(
                "product_id bigint primary key auto_increment",
                "product_name varchar(255) not null",
                "product_short_desc text(50000)",
                "product_image varchar(255)",
                "onstock boolean not null default 0",
                "active boolean not null default 0",
                "mrp decimal(12, 2) not null",
                "special_notes text(3000)",
                "updated_at timestamp",
                "created_at timestamp",
                "created_by bigint not null",
                "category_id int not null",
                "user_id bigint not null",
                "FOREIGN KEY(user_id) REFERENCES user(user_id)",
                "FOREIGN KEY(category_id) REFERENCES category(category_id)"
        ));
        addTable("seller_product", setColumns(
                "sku varchar(20) primary key",
                "stock int not null",
                "base_price decimal(10,2) null",
                "selling_price decimal(10,2) not null",
                "updated_at timestamp",
                "created_at timestamp",
                "product_id bigint",
                "user_id bigint",
                "FOREIGN KEY(user_id) REFERENCES user(user_id)",
                "FOREIGN KEY(product_id) REFERENCES product(product_id)"
        ));
        addTable("main_feature", setColumns(
                "main_feature_id int primary key auto_increment",
                "main_feature_title varchar(200) not null",
                "main_feature_desc varchar(255) not null",
                "product_id bigint not null",
                "updated_at timestamp",
                "created_at timestamp",
                "FOREIGN KEY(product_id) REFERENCES product(product_id)"
        ));
        addTable("specification", setColumns(
                "specification_id int primary key auto_increment",
                "specification_name varchar(100) not null",
                "updated_at timestamp",
                "created_at timestamp"
        ));
        addTable("feature", setColumns(
                "feature_id bigint primary key auto_increment",
                "feature_title varchar(200) not null",
                "feature_desc varchar(255) not null",
                "updated_at timestamp",
                "created_at timestamp",
                "specification_id int",
                "product_id bigint not null",
                "foreign key(product_id) references product(product_id)",
                "foreign key(specification_id) references specification(specification_id)"
        ));
        addTable("warranty", setColumns(
                "warranty_id int primary key auto_increment",
                "warranty_summary text(3000) not null",
                "warranty_type varchar(250) not null",
                "warranty_cover varchar(50) ",
                "not_covered varchar(100)",
                "updated_at timestamp",
                "created_at timestamp",
                "product_id bigint not null",
                "foreign key(product_id) references product(product_id)"
        ));
        addTable("rating", setColumns(
                "rating_id bigint primary key auto_increment",
                "rating tinyint not null",
                "updated_at timestamp",
                "created_at timestamp",
                "product_id bigint not null",
                "user_id bigint not null",
                "foreign key(user_id) references user(user_id)",
                "foreign key(product_id) references product(product_id)"
        ));
        addTable("comment", setColumns(
                "comment_id bigint primary key auto_increment",
                "comment_title varchar(255) not null",
                "comment_desc text(5000) not null",
                "updated_at timestamp",
                "created_at timestamp",
                "rating_id bigint not null",
                "foreign key(rating_id) references rating(rating_id)"
        ));



    }

    TableSchema() {
        this.tableSchema = new LinkedHashMap<>();
        this.setTableSchema();
        this.setColumns();
    }

    private void addTable(String tableName, String schema) {
        logger.info("Setting " + tableName + " Table Schema");
        String query = makeQuery(tableName, schema);
        tableSchema.put(tableName, query);
    }

    private String setColumns(String... columns) {
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

    public Map<String, String> getTableSchema() {
        return this.tableSchema;
    }

    public void clearSchema() {
        tableSchema.clear();
    }

}
