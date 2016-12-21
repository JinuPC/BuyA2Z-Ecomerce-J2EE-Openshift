package com.buya2z.config;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Map;

/**
 * Created by Jinu on 11/30/2016.
 */
public class Schema {

    private final Logger logger = Logger.getLogger(Schema.class);
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
                logger.info("Database is not exist. Trying to create database " + DB_NAME);
                createNewDatabase(connection);
                logger.info("Database " + DB_NAME + " Created Successfully");
            }
        } catch (SQLException e) {
            logger.error("Exception happened", e);
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
                    logger.info(tableName + " Table not found. Trying to create the table");
                    createTable(connection, tableSchema.get(tableName));
                    logger.info(tableName + " Table Created");
                }

            }
        } catch (SQLException e) {
            logger.error("Exception happened", e);
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Exception happened", e);
                }
            }
            tableSchema.clear();
        }
    }

    public boolean tableExist(Connection conn, String tableName) throws SQLException {
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

    private void createTable(Connection connection, String query) throws SQLException {
        logger.info(query);
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }


}
