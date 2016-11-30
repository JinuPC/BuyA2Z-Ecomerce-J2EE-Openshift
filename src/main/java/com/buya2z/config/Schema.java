package com.buya2z.config;

import java.sql.*;
import java.util.Map;

/**
 * Created by Jinu on 11/30/2016.
 */
public class Schema {
    private final String DB_NAME;

    Schema() {
        DB_NAME = Config.getDbName();
    }

    public void setSchema() {
        ensureDatabaseExist();
        ensureTablesExist();
    }

    private void ensureDatabaseExist() {
        //One time connection for checking the database and tables are exist.
        //If not exist create everything and close
        try (Connection connection = DriverManager.getConnection(Config.getDbUrl(),
                Config.getDbUserName(), Config.getDbPassword())) {
            if (!dbExists(connection)) {
                createNewDatabase(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean dbExists(Connection connection) throws SQLException {
        boolean dbExists = false;
        try (ResultSet resultSet = connection.getMetaData().getCatalogs()) {
            while (resultSet.next()) {
                String dbName = resultSet.getString(1);
                if (dbName.equalsIgnoreCase(this.DB_NAME)) {
                    dbExists = true;
                    break;
                }
            }
        }
        return dbExists;
    }

    private void createNewDatabase(Connection connection) throws SQLException {
        String query = "CREATE database " + this.DB_NAME;
        try (Statement statement = connection.createStatement()) {
            int updatedCount = statement.executeUpdate(query);
            Logger.print(updatedCount > 0 ? "Database Created Successfully" : "");
        }
    }

    private void ensureTablesExist() {
        Connection connection = null;
        Map<String, String> tableSchema = new TableSchema().getTableSchema();
        try {
            connection = DriverManager.getConnection(
                    Config.getDbUrl() +"/" + DB_NAME,
                    Config.getDbUserName(),
                    Config.getDbPassword()
            );
            for (String tableName : tableSchema.keySet()) {
                if (!tableExist(connection, tableName)) {
                    createTable(connection, tableSchema.get(tableName));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean tableExist(Connection conn, String tableName) throws SQLException {
        boolean tExists = false;
        try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");
                if (tName != null && tName.equalsIgnoreCase(tableName)) {
                    tExists = true;
                    break;
                }
            }
        }
        return tExists;
    }

    private static void createTable(Connection connection, String query) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }


}
