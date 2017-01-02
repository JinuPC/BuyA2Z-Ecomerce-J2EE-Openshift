package com.buya2z.beans.user;


import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by Jinu on 12/24/2016.
 */
public interface User {

    //Getters
    int getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    String getPhoneNumber();
    UserRole getRole();
    Status getStatus();
    String getGender();
    boolean isAdmin();
    boolean isSeller();
    boolean isBuyer();
    boolean isActive();
    boolean isInActive();
    boolean isBlocked();
    boolean isUnVerified();
    boolean isGuest();
    byte[] getSalt();
    byte[] getEncryptedPassword();

    //Setters
    void setId(int id);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setEmail(String email);
    void setPhoneNumber(String phoneNumber);
    void setStatus(Status status);
    void setPassword(char[] password);
    void setGender(String gender);
    void setUpdatedAt(Timestamp timestamp);
    void setCreatedAt(Timestamp timestamp);

    //Other operations
    boolean validate();
    Map<String, Object> getCreateValues();
    Map<String, Object> getSaveValues();

}
