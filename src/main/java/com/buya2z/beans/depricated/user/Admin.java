package com.buya2z.beans.depricated.user;

import com.buya2z.beans.depricated.category.QueryTransferObject;

/**
 * Created by Jinu on 12/25/2016.
 */
public class Admin extends AbstractUser {

    public Admin() {
        setRole(UserRole.ADMIN);
    }

    @Override
    public QueryTransferObject getCreateQuery() {
        return null;
    }
}
