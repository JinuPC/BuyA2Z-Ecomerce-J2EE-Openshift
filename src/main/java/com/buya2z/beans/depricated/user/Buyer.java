package com.buya2z.beans.depricated.user;

import com.buya2z.beans.depricated.category.QueryTransferObject;

/**
 * Created by Jinu on 12/25/2016.
 */
public class Buyer  extends AbstractUser {

    public Buyer() {
        this.setRole(UserRole.BUYER);
    }

    @Override
    public QueryTransferObject getCreateQuery() {
        return null;
    }
}
