package com.buya2z.model;

import com.buya2z.beans.depricated.user.User;

/**
 * Created by Jinu on 12/25/2016.
 */
public interface UserDAO {
    boolean create(User user);
    boolean authenicate(String email, char[] password);
    User getUser(int id);
    User getUser(String emailOrPhone, char[] password);
    boolean save(User user);
    boolean resetPassword(String emailOrPhone, char[] oldPassword, char[] newPassword);
}
