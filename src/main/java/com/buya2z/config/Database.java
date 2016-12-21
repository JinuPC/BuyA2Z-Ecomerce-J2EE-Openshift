package com.buya2z.config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jinu on 11/26/2016.
 */
public class Database {
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
        Schema schema = new Schema();
        schema.setSchema();
        initPool();
        TableData tableData = new TableData();
        tableData.setTableData();
    }

    private static void initPool() {
        connectionPool = new ArrayList<>(MAX_CONNECTIONS);
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                connectionPool.add(createNewConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static Connection createNewConnection() throws SQLException {
        String dbUrl = Config.getDbUrl() + "/" + DB_NAME;
        return DriverManager.getConnection(dbUrl, Config.getDbUserName(), Config.getDbPassword());
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            if (connectionPool.isEmpty()) {
                con = createNewConnection();
            }
            con = connectionPool.remove(1);
            if (con.isClosed() || !con.isValid(5)) {
                return getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                    putConnectionToPool((Connection) item);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void destroy() {
        try {
            for (Connection connection : connectionPool) {
                connection.close();
            }
            connectionPool.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
