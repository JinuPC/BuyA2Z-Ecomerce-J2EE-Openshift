package com.buya2z.beans.user;

import java.util.Date;

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
    public String gender();
    public Date getCreatedAtTimestamp();
    public Date getUpdatedAtTimestamp();
    public boolean isAdmin();
    public boolean isSeller();
    public boolean isBuyer();
    public boolean isActive();
    public boolean isInActive();
    public boolean isBlocked();
    public boolean isUnVerified();
    public boolean isGuest();

    //Setters
    public void setFirstName(String firstName);
    public void setLastName(String lastName);
    public void setEmail(String email);
    public void setPhoneNumber(String phoneNumber);
    public void setStatus(Status status);
    public void setRole(UserRole role);
    public void setGender(String gender);
    public void setPassword(char[] password);
}
