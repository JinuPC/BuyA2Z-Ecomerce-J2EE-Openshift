package com.buya2z.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Jinu on 12/26/2016.
 */
public class DatabaseTable {

    private static final String PRODUCT;
    private static final String ADDRESS;
    private static final String CARD;
    private static final String CATEGORY;
    private static final String COMMENT;
    private static final String FEATURE;
    private static final String MAIN_FEATURE;
    private static final String SELLER_PRODUCT;
    private static final String PRODUCT_IMAGE;
    private static final String RATING;
    private static final String SELLER;
    private static final String SPECIFICATION;
    private static final String USER;
    private static final String WARRANTY;

    static {
        Properties table = getTableProperty();
        PRODUCT = table.getProperty("PRODUCT");
        ADDRESS = table.getProperty("ADDRESS");
        CARD = table.getProperty("CARD");
        CATEGORY = table.getProperty("CATEGORY");
        COMMENT = table.getProperty("COMMENT");
        FEATURE = table.getProperty("FEATURE");
        MAIN_FEATURE = table.getProperty("MAIN_FEATURE");
        SELLER_PRODUCT = table.getProperty("SELLER_PRODUCT");
        PRODUCT_IMAGE = table.getProperty("PRODUCT_IMAGE");
        RATING = table.getProperty("RATING");
        SELLER = table.getProperty("SELLER");
        SPECIFICATION = table.getProperty("SPECIFICATION");
        USER = table.getProperty("USER");
        WARRANTY = table.getProperty("WARRANTY");

    }

    private static Properties getTableProperty() {
        final String fileName = "database.properties";
        ClassLoader classLoader = DatabaseTable.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        FileInputStream tableReader = null;
        Properties table = new Properties();
        try {
            tableReader = new FileInputStream(file);
            table.load(tableReader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(tableReader != null ) {
                try {
                    tableReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return table;
    }

    private DatabaseTable() {}

    public static String getProductTableName() {
        return PRODUCT;
    }

    public static String getAddressTableName() {
        return ADDRESS;
    }

    public static String getCardTableName() {
        return CARD;
    }

    public static String getCategoryTableName() {
        return CATEGORY;
    }

    public static String getCommentTableName() {
        return COMMENT;
    }

    public static String getFeatureTableName() {
        return FEATURE;
    }

    public static String getMainFeatureTableName() {
        return MAIN_FEATURE;
    }

    public static String getSellerProductTableName() {
        return SELLER_PRODUCT;
    }

    public static String getProductImageTableName() {
        return PRODUCT_IMAGE;
    }

    public static String getRatingTableName() {
        return RATING;
    }

    public static String getSellerTableName() {
        return SELLER;
    }

    public static String getSpecificationTableName() {
        return SPECIFICATION;
    }

    public static String getUserTableName() {
        return USER;
    }

    public static String getWarrantyTableName() {
        return WARRANTY;
    }
}
