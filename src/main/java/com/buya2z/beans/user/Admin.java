package com.buya2z.beans.user;

import com.buya2z.beans.QueryTransferObject;

/**
 * Created by Jinu on 12/25/2016.
 */
public class Admin extends AbstractUser {
    @Override
    public QueryTransferObject getCreateQuery() {
        return null;
    }
}
