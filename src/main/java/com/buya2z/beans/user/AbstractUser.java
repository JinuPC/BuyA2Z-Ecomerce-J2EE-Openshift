package com.buya2z.beans.user;

import java.util.Date;

/**
 * Created by Jinu on 12/24/2016.
 */
public abstract class AbstractUser implements User{

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private char[] password;

    private String phoneNumber;

    private UserRole role;

    private Status status;

    private String gender;

    private Date updatedAt;

    private Date createdAt;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public UserRole getRole() {
        return role;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public String gender() {
        return gender;
    }

    @Override
    public Date getCreatedAtTimestamp() {
        return createdAt;
    }

    @Override
    public Date getUpdatedAtTimestamp() {
        return updatedAt;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public boolean isAdmin() {
        return this.role == UserRole.ADMIN;
    }

    @Override
    public boolean isSeller() {
        return this.role == UserRole.SELLER;
    }

    @Override
    public boolean isBuyer() {
        return this.role == UserRole.BUYER;
    }

    @Override
    public boolean isActive() {
        return this.status == Status.ACTIVE;
    }

    @Override
    public boolean isInActive() {
        return this.status == status.INACTIVE;
    }

    @Override
    public boolean isBlocked() {
        return this.status == Status.BLOCKED;
    }

    @Override
    public boolean isUnVerified() {
        return this.status == Status.UN_VERIFIED;
    }

    @Override
    public boolean isGuest() {
        return false;
    }
}
