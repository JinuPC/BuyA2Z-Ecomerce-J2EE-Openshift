package com.buya2z.beans.user;

/**
 * Created by Jinu on 12/24/2016.
 */
public enum UserRole {
    SELLER("seller"), BUYER("buyer"), ADMIN("admin");

    private String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
