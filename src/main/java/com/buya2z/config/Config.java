package com.buya2z.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Jinu on 11/26/2016.
 */
public class Config {
    private final static String DB_TYPE = "MYSQL";
    private final static String DB_NAME = "shop";
    private static String dbHost;
    private static String dbPort;
    private static String dbUserName;
    private static String dbPassword;
    private static String baseUrl;
    private static String appName;
    private static String homeDirectory;
    private static String dataDirectory;

    /*
     * Will set the Environment variables for this application based on the platform
     * If the application deployed in openshift then it will set openshift variables
     * If it is local development then local variables will set from the properties file
     */
    static {
        setEnv();
    }

    /*
     * Method for checking the deployment platform
     * If true application is deployed in openshift
     */
    public static boolean isInOpenshift() {
        return System.getenv("OPENSHIFT_MYSQL_DB_HOST") != null;
    }

    /*
     * Method for checking the deployment is done in localhost
     * If true this is deployed in localhost
     */
    public static boolean isInLocal() {
        return System.getenv("OPENSHIFT_MYSQL_DB_HOST") == null;
    }

    /*
     * Return base Url of the application
     * Example
     * Local : http://localhost:8080
     * Openshift : shop-buya2z.rhcloud.com
     */
    public static String getBaseUrl() {
        return Config.baseUrl;
    }

    public static String getDbUrl() {
        String dbUrl = "";
        if(DB_TYPE.equalsIgnoreCase("mysql")) {
            dbUrl = "jdbc:mysql://" + Config.dbHost + ":" + Config.dbPort;
        }
        return dbUrl;
    }

    public static String getDbUserName() {
        return dbUserName;
    }

    public static String getDbPassword() {
        return dbPassword;
    }

    /*
             * Method for Setting the environment variable based on the deployment platform.
             */
    private static void setEnv() {
        if(isInOpenshift() && DB_TYPE.equalsIgnoreCase("mysql")) {
            dbHost = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            dbPort = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
            dbUserName = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
            dbPassword = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
            baseUrl = System.getenv("OPENSHIFT_APP_DNS");
            appName = System.getenv("OPENSHIFT_APP_NAME");
            homeDirectory = System.getenv("OPENSHIFT_HOMEDIR");
            dataDirectory = System.getenv("OPENSHIFT_DATA_DIR");

        } else if(isInLocal()){
            setLocalEnv();
        }
    }

    /*
     * Method for set local environment variables
     * This method reads the properties form the main/resources/config.properties file
     */
    private static void setLocalEnv() {
        final String fileName = "config.properties";
        ClassLoader classLoader = Config.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        FileInputStream configReader = null;
        Properties config = new Properties();
        try {
            configReader = new FileInputStream(file);
            config.load(configReader);
            dbHost = config.getProperty("DB_HOST");
            dbPort = config.getProperty("DB_PORT");
            dbUserName = config.getProperty("DB_USERNAME");
            dbPassword = config.getProperty("DB_PASSWORD");
            baseUrl = config.getProperty("BASE_URL");
            appName = config.getProperty("APP_NAME");
            homeDirectory = config.getProperty("HOME_DIR");
            dataDirectory = config.getProperty("DATA_DIR");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(configReader != null ) {
                try {
                    configReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String toString() {
        return getDbUrl();
    }

}
