package com.buya2z.config;

import com.buya2z.config.Config;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinu on 11/26/2016.
 */
public class Database {
    private static List<Connection> connectionPool;
    static {
        initPool();
    }
    private Database() {}

    private static void initPool() {
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUserName(), Config.getDbPassword());
            connectionPool = new ArrayList<Connection>();
            connectionPool.add(connection);
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connectionPool.get(0);
    }

}
