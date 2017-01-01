package com.buya2z.beans.user;

import com.buya2z.beans.QueryTransferObject;
import com.sun.deploy.net.HttpRequest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by Jinu on 12/24/2016.
 */
public interface User {
    //Getters
    public int getId();
    public String getFirstName();
    public String getLastName();
    public String getEmail();
    public String getPhoneNumber();
    public UserRole getRole();
    public Status getStatus();
    public String getGender();
    public boolean isAdmin();
    public boolean isSeller();
    public boolean isBuyer();
    public boolean isActive();
    public boolean isInActive();
    public boolean isBlocked();
    public boolean isUnVerified();
    public boolean isGuest();
    public byte[] getSalt();
    public byte[] getEncryptedPassword();

    //Setters
    public void setId(int id);
    public void setFirstName(String firstName);
    public void setLastName(String lastName);
    public void setEmail(String email);
    public void setPhoneNumber(String phoneNumber);
    public void setStatus(Status status);
    public void setPassword(char[] password);
    public void setGender(String gender);
    public void setUpdatedAt(Timestamp timestamp);
    public void setCreatedAt(Timestamp timestamp);

    //Other operations
    public boolean validate();
    public Map<String, Object> getCreateValues();
}
