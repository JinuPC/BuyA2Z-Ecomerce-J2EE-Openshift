package com.buya2z.config;

/**
 * Created by Jinu on 11/26/2016.
 */
public class Config {
    private static String host;
    private static String port;
    static {
        getEnv();
    }

    private static boolean isOpenshiftDeployment() {
        return System.getenv("OPENSHIFT_MYSQL_DB_HOST") != null;
    }
    private static void getEnv() {
        if(isOpenshiftDeployment()) {
            host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        } else {
            host = "localhost";
            port = "3306";
        }
    }

    public String toString() {
        return "Host => " + host + " port => " + port;
    }

}
