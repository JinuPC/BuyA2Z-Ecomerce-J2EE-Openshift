package com.buya2z.config;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Jinu on 11/26/2016.
 */
public class Database {
    private static final int MAX_CONNECTIONS = 5;
    private static final String DB_NAME = Config.getDbName();
    private static List<Connection> connectionPool;
    private static String tableName = "";

    private Database() {
    }

    /**
     * Check database and tables are exist if not create everything.
     * Also fills some dummy data in to the database<br>
     * Then initialize the connection pool
     */
    public static void init() {
        ensureDatabaseExist();
        initPool();
        ensureTablesExist(getConnection());

    }

    private static void ensureDatabaseExist() {
        //One time connection for checking the database and tables are exist.
        //If not exist create everything and close
        try (Connection connection = DriverManager.getConnection(Config.getDbUrl(),
                Config.getDbUserName(), Config.getDbPassword())) {
            if (!dbExists(connection)) {
                createDatabase(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void ensureTablesExist(Connection connection) {
        Map<String, String> tableSchema = new Tables().getTableSchema();
        try {
            for (String tableName : tableSchema.keySet()) {
                if (!tableExist(connection, tableName)) {
                    createTable(connection, tableSchema.get(tableName));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    private static void createDatabase(Connection connection) throws SQLException {
        String query = "CREATE database " + Database.DB_NAME;
        try (Statement statement = connection.createStatement()) {
            int updatedCount = statement.executeUpdate(query);
            Logger.print(updatedCount > 0 ? "Database Created Successfully" : "");
        }
    }

    private static void createTable(Connection connection, String query) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            int updatedCount = statement.executeUpdate(query);
            Logger.print("Table created Successfully");
        }
    }

    private static boolean dbExists(Connection connection) throws SQLException {
        boolean dbExists = false;
        try (ResultSet resultSet = connection.getMetaData().getCatalogs()) {
            while (resultSet.next()) {
                String dbName = resultSet.getString(1);
                if (dbName.equalsIgnoreCase(Database.DB_NAME)) {
                    dbExists = true;
                    break;
                }
            }
        }
        return dbExists;
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
        close();
        return tExists;
    }

    /**
     * Will close all jdbc Objects silently.<br>
     * If you pass Connection object then it will add reuse the object by adding to the connectionPool
     */
    public static void close(Wrapper... closableItems) {
        for (Object item : closableItems) {
            if (item instanceof Statement) {
                try {
                    ((Statement) item).close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (item instanceof ResultSet) {
                try {
                    ((ResultSet) item).close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (item instanceof Connection) {
                try {
                    ((Connection) item).close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void initPool() {

    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(Config.getDbUrl() + "/" + DB_NAME, Config.getDbUserName() , Config.getDbPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
