package com.buya2z.config;


import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created by Jinu on 11/26/2016.
 */
public class Database {

    private static final Logger LOGGER = Logger.getLogger(Database.class);

    private static final int MAX_CONNECTIONS = 5;

    private static final String DB_NAME = Config.getDbName();

    private static List<Connection> connectionPool; //for storing connections

    private Database() {
    }

    /**
     * Check database and tables are exist if not create everything.
     * initialize the connection pool
     * Then fills some dummy data in to the database<br>
     */
    public static void init() {
        LOGGER.info("Updating Database Schema");
        Schema schema = new Schema();
        schema.setSchema();
        LOGGER.info("Database Schema Updated");
        initPool();
        LOGGER.info("Updating Database Data");
        TableData tableData = new TableData();
        tableData.setTableData();
        LOGGER.info("Database Data Updated");
    }

    private static void initPool() {
        LOGGER.info("Initializing Connection Pool");
        connectionPool = new ArrayList<>(MAX_CONNECTIONS);
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                connectionPool.add(createNewConnection());
            } catch (SQLException e) {
                LOGGER.error("Exception Happened " + e);
            }
        }
        LOGGER.info("Connection pool initialized ");
    }

    private static Connection createNewConnection() throws SQLException {
        LOGGER.info("Creating new Connection");
        String dbUrl = Config.getDbUrlWithDatabaseName();
        return DriverManager.getConnection(dbUrl, Config.getDbUserName(), Config.getDbPassword());
    }

    public synchronized static Connection getConnection() {
        Connection con = null;
        try {
            if (connectionPool.isEmpty()) {
                LOGGER.info("Connection pool is empty trying to create new Connection");
                con = createNewConnection();
            }
            con = connectionPool.remove(1);
            if (con.isClosed() || !con.isValid(5)) {
                return getConnection();
            }
        } catch (SQLException e) {
            LOGGER.error("Exception Happened " + e);
        }
        return con;
    }

    private static void putConnectionToPool(Connection con) throws SQLException {
        if (connectionPool.size() > MAX_CONNECTIONS) {
            con.close();
        }
        if (!con.isClosed()) {
            connectionPool.add(con);
        }
    }

    /**
     * Will close all jdbc Objects silently.<br>
     * If you pass Connection object then it will reuse the object by adding to the connectionPool
     */
    public static void close(Wrapper... closableItems) {
        for (Object item : closableItems) {
            if (item instanceof Statement) {
                try {
                    LOGGER.info("Trying to close " + item + " Object ");
                    ((Statement) item).close();
                    LOGGER.info("Closed Successfully...");
                } catch (SQLException e) {
                    LOGGER.error("Exception Happened " + e);
                }
            }
            if (item instanceof ResultSet) {
                try {
                    LOGGER.info("Trying to close " + item + " Object ");
                    ((ResultSet) item).close();
                    LOGGER.info("Closed Successfully...");
                } catch (SQLException e) {
                    LOGGER.error("Exception Happened " + e);
                }
            }
            if (item instanceof Connection) {
                try {
                    putConnectionToPool((Connection) item);
                } catch (SQLException e) {
                    LOGGER.error("Exception Happened " + e);
                }
            }
        }
    }

    public synchronized static int getAutoIncrementedValue(String tableName) throws SQLException{
        Connection connection = Database.getConnection();
        try(Statement statement = connection.createStatement()) {
            String query = "SHOW TABLE STATUS LIKE '" + tableName + "' " ;
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                return resultSet.getInt("Auto_increment");
            }
        }
        return -1;
    }

    public synchronized static int getAutoIncrementedId(String tableName) throws SQLException {
        return getAutoIncrementedValue(tableName) - 1;
    }

    public static void destroy() {
        try {
            removeConnectionPool();
            unRegisterDriver();
        } catch (SQLException e) {
            LOGGER.error("Exception happened while closing Database", e);
        }
    }

    private static void removeConnectionPool() throws SQLException {
        LOGGER.info("Trying to close all connections and remove connection Pool");
        for (Connection connection : connectionPool) {
            LOGGER.info("Closing " + connection + " Connection");
            connection.close();
        }
        connectionPool.clear();
        LOGGER.info("Connection Pool Removed Successfully");
    }

    private static void unRegisterDriver() throws SQLException {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            DriverManager.deregisterDriver(driver);
            LOGGER.info("Jdbc Drivers unregistered Successfully");
        }
    }

    public static void setAutoCommitTrue(Connection con) {
        if(con != null) {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setAutoCommitFalse(Connection con) {
        if(con != null) {
            try {
                con.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
