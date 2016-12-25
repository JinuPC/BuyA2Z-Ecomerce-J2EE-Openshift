package com.buya2z.beans.user;

/**
 * Created by Jinu on 12/24/2016.
 */
public enum Status {
    ACTIVE(1), INACTIVE(2), BLOCKED(3), UN_VERIFIED(0);

    private int statusValue;

    Status(int statusValue) {
        this.statusValue = statusValue;
    }

    public int getStatusValue() {
        return this.statusValue;
    }

}
