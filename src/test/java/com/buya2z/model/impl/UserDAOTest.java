package com.buya2z.model.impl;


import com.buya2z.TestInitializer;
import com.buya2z.beans.user.*;
import com.buya2z.config.Database;
import com.buya2z.model.DAOFactory;
import com.buya2z.model.UserDAO;
import com.buya2z.model.jdbcimpl.DAOUtil;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

/**
 * Created by Jinu on 12/28/2016.
 */
public class UserDAOTest {
    public UserDAOTest() {
        TestInitializer.initialize();
    }

    UserDAO dao = DAOFactory.getUserDAO();

    private Seller getTestSeller() {
        char[] password = {'a','b','c','d','d','d','d','d'};
        Seller seller = new Seller();
        seller.setPassword(password);
        seller.setFirstName("sellerTestFirstName");
        seller.setLastName("SellerTestLastName");
        seller.setEmail("testseller@testing.com");
        seller.setPhoneNumber("9876543256");
        seller.setTinNumber("12345678911");
        seller.setCompany("Test Company");
        seller.setSellerDescription("This is a test seller..........");
        seller.setCompanyLocation("Test Location");
        return seller;
    }

    private User getTestBuyer() {
        char[] password = {'a','b','c','d','d','d','d','d'};
        User user = new Buyer();
        user.setGender("male");
        user.setFirstName("TestFirstName");
        user.setLastName("TestLastName");
        user.setEmail("test@testing.com");
        user.setPhoneNumber("9876543256");
        user.setPassword(password);
        return user;
    }

    @Test
    public void testSellerValidate() {
        assertTrue("Seller Validation failed", getTestSeller().validate());
    }

    @Test
    public void testCreateUser() {
        UserDAO dao = DAOFactory.getUserDAO();
        assertTrue(dao.create(getTestBuyer()));
    }

    @Test
    public void testCreateSeller() {
        assertTrue(dao.create(getTestSeller()));;
    }

    @Test
    public void testAuthenicateUser() {
        char[] password = {'r','o','o','t'};
        assertTrue(dao.authenicate("pcjinu@ymail.com", password));

    }

    @Test
    public void testAuthenicateUserEmail() {
        char[] password = {'r','o','o','t'};
        assertTrue(dao.authenicate("978624048", password));
    }

    @Test
    public void testGetUser() {
        User user = dao.getUser(2);
        System.out.println(user);
    }
}
