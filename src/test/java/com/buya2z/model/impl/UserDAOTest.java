package com.buya2z.model.impl;


import com.buya2z.TestInitializer;
import com.buya2z.beans.depricated.user.Buyer;
import com.buya2z.beans.depricated.user.Seller;
import com.buya2z.beans.depricated.user.Status;
import com.buya2z.beans.depricated.user.User;
import com.buya2z.model.DAOFactory;
import com.buya2z.model.UserDAO;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
        //char[] password = {'j','i','n','u'};

        assertTrue(dao.authenicate("978624048", password));

    }

    @Test
    public void testAuthenicateUserEmail() {
        char[] password = {'r','o','o','t'};
        assertTrue(dao.authenicate("pcjinu@ymail.com", password));
    }

    @Test
    public void testGetUser() {
        User user = dao.getUser(2);
        System.out.println(user);
        assertTrue(user != null);
    }

    @Test
    public void testGetUserWithEmailAndPassword() {
        String email = "978624048";
        char[] password = {'r','o','o','t'};
        User user = dao.getUser(email, password);
        System.out.println(user);
    }

    @Test
    public void testResetPassword() {
        String email = "pcjinu@ymail.com";
        String phoneNumber = "978624048";
        char[] oldPassword = {'r','o','o','t'};
        char[] newPassword = {'j','i','n','u'};
        assertTrue(dao.resetPassword(email, oldPassword, newPassword));
        assertTrue(dao.resetPassword(phoneNumber, newPassword, oldPassword));
    }

    @Test
    public void testSave() {
        User user = dao.getUser(2);
        user.setFirstName("Praveen");
        user.setLastName("S");
        user.setStatus(Status.ACTIVE);
        dao.save(user);
    }
}
