package com.buya2z.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jinu on 11/26/2016.
 */
public class Database {
    private final int MAX_CONNECTIONS = 5;
    private final String DB_NAME = Config.getDbName();
    private static List<Connection> connectionPool;
    private static String tableName = "";

    /*
     * Will initialize the database if the database and tables are already exist then,
     * it will create a connection pool with MAX_CONNECTIONS size
     * Otherwise, It will create database and tables
     */
    static {
        init();
        initPool();
    }

    private Database() {}

    private static void init() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUserName(), Config.getDbPassword());
            if(!dbExists(connection)) {

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            Database.close(connection);
        }

    }

    private static boolean dbExists(Connection connection) throws SQLException {
        ResultSet resultSet = connection.getMetaData().getCatalogs();
        while (resultSet.next()) {
            String databaseName = resultSet.getString(1);
            System.out.println( "database name is " +databaseName+"\n\n\n\n");
            tableName = databaseName;
        }
        resultSet.close();
        return false;
    }

    public static boolean tableExist(Connection conn, String tableName) throws SQLException {
        boolean tExists = false;
        try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");
                if (tName != null && tName.equals(tableName)) {
                    tExists = true;
                    break;
                }
            }
        }
        return tExists;
    }

    private static void close(Connection connection) {

    }

    public static String getTableName() {
        return tableName;
    }

    private static void initPool() {

    }

    public static Connection getConnection() {
        return null;
    }

}
