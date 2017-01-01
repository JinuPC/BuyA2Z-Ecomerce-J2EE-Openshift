package com.buya2z.model;

import com.buya2z.beans.user.User;

/**
 * Created by Jinu on 12/25/2016.
 */
public interface UserDAO {
    boolean create(User user);
    boolean authenicate(String email, char[] password);
    User getUser(int id);
}
