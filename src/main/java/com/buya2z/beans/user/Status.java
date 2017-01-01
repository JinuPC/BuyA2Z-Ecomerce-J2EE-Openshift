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

    public static Status getStatus(int value) {
        if(value == ACTIVE.getStatusValue()) {
            return ACTIVE;
        }
        if(value == INACTIVE.getStatusValue()) {
            return INACTIVE;
        }
        if(value == BLOCKED.getStatusValue()) {
            return BLOCKED;
        }
        if(value == UN_VERIFIED.getStatusValue()) {
            return UN_VERIFIED;
        }
        return null;
    }
}
