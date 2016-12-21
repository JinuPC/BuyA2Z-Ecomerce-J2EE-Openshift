package com.buya2z.config;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by Jinu on 11/26/2016.
 */
public class Database {

    private static final Logger logger = Logger.getLogger(Database.class);

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
        logger.info("Updating Database Schema");
        Schema schema = new Schema();
        schema.setSchema();
        logger.info("Database Schema Updated");
        initPool();
        logger.info("Updating Database Data");
        TableData tableData = new TableData();
        tableData.setTableData();
        logger.info("Database Data Updated");
    }

    private static void initPool() {
        logger.info("Initializing Connection Pool");
        connectionPool = new ArrayList<>(MAX_CONNECTIONS);
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                connectionPool.add(createNewConnection());
            } catch (SQLException e) {
                logger.error("Exception Happened " + e);
            }
        }
        logger.info("Connection pool initialized ");
    }

    private static Connection createNewConnection() throws SQLException {
        logger.info("Creating new Connection");
        String dbUrl = Config.getDbUrl() + "/" + DB_NAME;
        return DriverManager.getConnection(dbUrl, Config.getDbUserName(), Config.getDbPassword());
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            if (connectionPool.isEmpty()) {
                logger.info("Connection pool is empty trying to create new Connection");
                con = createNewConnection();
            }
            con = connectionPool.remove(1);
            if (con.isClosed() || !con.isValid(5)) {
                return getConnection();
            }
        } catch (SQLException e) {
            logger.error("Exception Happened " + e);
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
                    logger.info("Trying to close " + item + " Object ");
                    ((Statement) item).close();
                } catch (SQLException e) {
                    logger.error("Exception Happened " + e);
                }
            }
            if (item instanceof ResultSet) {
                try {
                    logger.info("Trying to close " + item + " Object ");
                    ((ResultSet) item).close();
                } catch (SQLException e) {
                    logger.error("Exception Happened " + e);
                }
            }
            if (item instanceof Connection) {
                try {
                    putConnectionToPool((Connection) item);
                } catch (SQLException e) {
                    logger.error("Exception Happened " + e);
                }
            }
        }
    }

    public static void destroy() {
        try {
            logger.info("Trying to close all connections and remove connection Pool");
            for (Connection connection : connectionPool) {
                logger.info("Closing " + connection + " Connection");
                connection.close();
            }
            connectionPool.clear();
            logger.info("Connection Pool Removed Successfully");
        } catch (SQLException e) {
            logger.error("Exception happened while closing connection Object ", e);
        }
    }

}
