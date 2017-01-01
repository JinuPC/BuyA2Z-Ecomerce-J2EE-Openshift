package com.buya2z.config;

import com.buya2z.TestInitializer;
import org.junit.Test;

import java.sql.*;

/**
 * Created by Jinu on 1/1/2017.
 */
public class PasswordManagerTest {

    public PasswordManagerTest() {
        TestInitializer.initialize();
    }

    @Test
    public void testPassword() {
        char[] passord = {'r','o','o','t'};
        Connection con = Database.getConnection();
        Statement stmt = null;
        ResultSet set = null;
        String query = "select password, salt from user where user_id = 1";
        try {
            stmt = con.createStatement();
            set = stmt.executeQuery(query);
            if(set.next()) {
                byte[] encryptedPassword = set.getBytes("password");
                byte[] salt = set.getBytes("salt");
                System.out.println(PasswordManager.authenticate(passord, encryptedPassword, salt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.close(con, stmt, set);
        }
    }
}
