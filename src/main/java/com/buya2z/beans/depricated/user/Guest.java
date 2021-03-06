package com.buya2z.beans.depricated.user;

import com.buya2z.beans.depricated.category.AbstractBean;
import com.buya2z.beans.depricated.category.QueryTransferObject;

import java.util.Map;

/**
 * Created by Jinu on 12/25/2016.
 */
public class Guest extends AbstractBean implements User {

    @Override
    public QueryTransferObject getCreateQuery() {
        return null;
    }

    @Override
    public boolean isGuest(){
        return true;
    }

    @Override
    public byte[] getSalt() {
        return new byte[0];
    }

    @Override
    public byte[] getEncryptedPassword() {
        return new byte[0];
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getPhoneNumber() {
        return null;
    }

    @Override
    public UserRole getRole() {
        return null;
    }

    @Override
    public Status getStatus() {
        return null;
    }

    @Override
    public String getGender() {
        return null;
    }

    @Override
    public boolean isAdmin() {
        return false;
    }

    @Override
    public boolean isSeller() {
        return false;
    }

    @Override
    public boolean isBuyer() {
        return false;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean isInActive() {
        return false;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public boolean isUnVerified() {
        return false;
    }

    @Override
    public void setFirstName(String firstName) {

    }

    @Override
    public void setLastName(String lastName) {

    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public void setPhoneNumber(String phoneNumber) {

    }

    @Override
    public void setStatus(Status status) {

    }


    public void setRole(UserRole role) {

    }

    @Override
    public void setGender(String gender) {

    }

    @Override
    public Map<String, Object> getCreateValues() {
        return null;
    }

    @Override
    public void setPassword(char[] password) {

    }

    @Override
    public Map<String, Object> getSaveValues() {
        return null;
    }
}
