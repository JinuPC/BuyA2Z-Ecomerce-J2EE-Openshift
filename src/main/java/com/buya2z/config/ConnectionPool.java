package com.buya2z.config;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by Jinu on 12/29/2016.
 */
final class ConnectionPool {

    private final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private static ConnectionPool instance;

    private final ArrayList<Connection> CONNECTION_POOL;

    private final int MAX_SIZE = 5;

    private ConnectionPool() {
        CONNECTION_POOL = new ArrayList<>(MAX_SIZE);
        initPool();
    }

    private void initPool() {
        LOGGER.info("Initializing Connection Pool");
        for (int i = 0; i < MAX_SIZE; i++) {
            try {
                this.put(createNewConnection());
            } catch (SQLException e) {
                LOGGER.error("Exception Happened " + e);
            }
        }
        LOGGER.info("Connection pool initialized ");
    }

    private Connection createNewConnection() throws SQLException {
        LOGGER.info("Creating new Connection");
        String dbUrl = Config.getDbUrlWithDatabaseName();
        return DriverManager.getConnection(dbUrl, Config.getDbUserName(), Config.getDbPassword());
    }

    public synchronized Connection get() {
        Connection con = null;
        try {
            if (CONNECTION_POOL.isEmpty()) {
                LOGGER.info("Connection pool is empty trying to create new Connection");
                return createNewConnection();
            }
            con = CONNECTION_POOL.remove(CONNECTION_POOL.size() - 1);
            if (con.isClosed() || !con.isValid(5)) {
                return get();
            }
        } catch (SQLException e) {
            LOGGER.error("Exception Happened " + e);
        }
        return con;
    }

    public void put(Connection con) throws SQLException{
        if (CONNECTION_POOL.size() > MAX_SIZE) {
            LOGGER.info("Connection pool is full Closing connection " + con);
            con.close();
        }
        if (!con.isClosed()) {
            CONNECTION_POOL.add(con);
        } else {
            System.out.println("Connection " + con + " is Closed " );
        }
    }

    public int size() {
        return CONNECTION_POOL.size();
    }

    public boolean isEmpty() {
        return CONNECTION_POOL.isEmpty();
    }

    public static ConnectionPool getInstance() {
        if(instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public void remove() {
        for (Connection connection : CONNECTION_POOL) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        CONNECTION_POOL.clear();
        LOGGER.info("All connections are closed...");
    }

    public void unRegisterDriver() throws SQLException {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            LOGGER.info("Trying to unregister Driver " + driver);
            DriverManager.deregisterDriver(driver);
        }
        LOGGER.info("Jdbc Drivers unregistered Successfully");
    }

}
