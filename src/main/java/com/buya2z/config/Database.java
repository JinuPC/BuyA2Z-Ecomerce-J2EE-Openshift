package com.buya2z.config;


import com.buya2z.config.dummydata.TableData;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by Jinu on 11/26/2016.
 */
public class Database {

    private static final Logger LOGGER = Logger.getLogger(Database.class);

    private static final String DB_NAME = Config.getDbName();

    private static ConnectionPool connectionPool ;

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
        connectionPool = ConnectionPool.getInstance();
        LOGGER.info("Updating Database Data");
        TableData tableData = new TableData();
        tableData.setTableData();
        LOGGER.info("Database Data Updated");
    }

    public static Connection getConnection() {
       return connectionPool.get();
    }


    private static void putConnectionToPool(Connection con) throws SQLException {
        connectionPool.put(con);
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


    private synchronized static int getAutoIncrementedValue(String tableName) throws SQLException{
        Connection connection = Database.getConnection();
        String query = "SHOW TABLE STATUS LIKE ?" ;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tableName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt("Auto_increment");
            }
        } finally {
            Database.close(connection);
        }
        return -1;
    }

    /**
     *
     * @param tableName
     * @return
     * @throws SQLException
     * Will return the last incremented id of a particular table
     */
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
        connectionPool.remove();
        LOGGER.info("Connection Pool Removed Successfully");
    }

    private static void unRegisterDriver() throws SQLException {
        connectionPool.unRegisterDriver();
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

    public static int getConnectionPoolCount() {
        return connectionPool.size();
    }

}
