package com.buya2z.beans.depricated.user;

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

    public static UserRole getUserRole(String value) {
        if(value.equalsIgnoreCase(SELLER.getValue())) {
            return SELLER;
        } else if(value.equalsIgnoreCase(BUYER.getValue())) {
            return BUYER;
        } else if(value.equalsIgnoreCase(ADMIN.getValue())) {
            return ADMIN;
        }
        return null;
    }
}
