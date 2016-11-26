package com.buya2z.config;

/**
 * Created by Jinu on 11/26/2016.
 */
public class Config {
    private static String host;
    private static String port;
    private static String dns;
    private static String appName;
    private static String homeDirecotry;
    private static String dataDirectory;
    private static String userName;
    private static String password;
    private static String dbUrl;

    static {
        getEnv();
    }

    private static boolean isInOpenshift() {
        return System.getenv("OPENSHIFT_MYSQL_DB_HOST") != null;
    }
    public static boolean isInLocal() {
        return System.getenv("OPENSHIFT_MYSQL_DB_HOST") == null;
    }
    private static void getEnv() {
        if(isInOpenshift()) {
            host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
            userName = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
            password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
            dbUrl = System.getenv("OPENSHIFT_MYSQL_DB_URL");
            dns = System.getenv("OPENSHIFT_APP_DNS");
            appName = System.getenv("OPENSHIFT_APP_NAME");
            homeDirecotry = System.getenv("OPENSHIFT_HOMEDIR");
            dataDirectory = System.getenv("OPENSHIFT_DATA_DIR");

        } else {
            host = "localhost";
            port = "3306";
        }
    }

    public String toString() {
        return "Host => " + host + " port => " + port +
                " AppName => " + appName +
                "DNS =>" + dns +
                "Data Direcotey =>" + dataDirectory +
                "Home Direcotyt =>" + homeDirecotry +
                "user Name=>" + userName +
                "Password =>" + password +
                "db Url =>" + dbUrl ;
    }

}
