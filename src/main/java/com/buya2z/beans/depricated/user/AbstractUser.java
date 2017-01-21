package com.buya2z.beans.depricated.user;

import com.buya2z.beans.depricated.category.AbstractBean;
import com.buya2z.config.PasswordManager;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Jinu on 12/24/2016.
 */
public abstract class AbstractUser extends AbstractBean implements User{

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private char[] password;

    private byte[] salt;

    private String phoneNumber;

    private UserRole role;

    private Status status = Status.INACTIVE;

    private String gender;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public UserRole getRole() {
        return role;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public String getGender() {
        return gender == null ? "" : gender;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    protected void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public boolean isAdmin() {
        return this.role == UserRole.ADMIN;
    }

    @Override
    public boolean isSeller() {
        return this.role == UserRole.SELLER;
    }

    @Override
    public boolean isBuyer() {
        return this.role == UserRole.BUYER;
    }

    @Override
    public boolean isActive() {
        return this.status == Status.ACTIVE;
    }

    @Override
    public boolean isInActive() {
        return this.status == status.INACTIVE;
    }

    @Override
    public boolean isBlocked() {
        return this.status == Status.BLOCKED;
    }

    @Override
    public boolean isUnVerified() {
        return this.status == Status.UN_VERIFIED;
    }

    @Override
    public byte[] getSalt() {
        return salt;
    }

    @Override
    public boolean isGuest() {
        return false;
    }

    @Override
    public byte[] getEncryptedPassword() {
        this.salt = PasswordManager.generateSalt();
        return PasswordManager.getEncryptedPassword(password, this.salt);
    }

    @Override
    public boolean validate() {
        boolean isValidate = true;
        if( !isStringPropertyAssigned(this.firstName) ) {
            LOGGER.info("Validation failed at User: First Name is not set");
            isValidate = false;
        }
        if( !isStringPropertyAssigned(this.lastName) ) {
            LOGGER.info("Validation failed at User: Last Name is not set");
            isValidate = false;
        }
        if( !isStringPropertyAssigned(this.email) ) {
            LOGGER.info("Validation failed at User: First Name is not set");
            isValidate = false;
        }
        if( !isStringPropertyAssigned(phoneNumber) ) {
            LOGGER.info("Validation failed at User: Phone Number is not set");
            isValidate = false;
        }
        if( this.role == null ) {
            LOGGER.info("Validation failed at User: User Role is not set");
            isValidate = false;
        }
        if( this.password == null || this.password.length < 6) {
            LOGGER.info("Validation failed at User: Password is not set");
            isValidate = false;
        }
        if( this.status == null) {
            LOGGER.info("Validation failed at User: Status is not set");
            isValidate = false;
        }
        return isValidate;
    }

    @Override
    public Map<String, Object> getCreateValues() {
        Map<String, Object> queryWithValues = new LinkedHashMap<>();
        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        queryWithValues.put("first_name", this.getFirstName());
        queryWithValues.put("last_name", this.getLastName());
        queryWithValues.put("email", this.getEmail());
        queryWithValues.put("phone_number", this.getPhoneNumber());
        queryWithValues.put("role", this.getRole().getValue());
        queryWithValues.put("password", this.getEncryptedPassword());
        queryWithValues.put("salt", this.getSalt());
        queryWithValues.put("status", this.getStatus().getStatusValue());
        queryWithValues.put("gender", this.getGender());
        putCreationTimestamp(queryWithValues);
        return queryWithValues;
    }

    @Override
    public Map<String, Object> getSaveValues() {
        if(getId() <= 0) {
            return null;
        }
        Map<String, Object> columnsWithValues = new LinkedHashMap<>();
        if(isStringPropertyAssigned(getFirstName())) {
            columnsWithValues.put("first_name", getFirstName());
        }
        if(isStringPropertyAssigned(getLastName()))  {
            columnsWithValues.put("last_name", getLastName());
        }
        if(isStringPropertyAssigned(getPhoneNumber())) {
            columnsWithValues.put("phone_number", getPhoneNumber());
        }
        if(isStatusPropertyAssigned(getStatus())) {
            columnsWithValues.put("status", getStatus().getStatusValue());
        }
        if(isStringPropertyAssigned(getGender())) {
            columnsWithValues.put("gender", getGender());
        }
        return columnsWithValues;
    }

    protected boolean isStatusPropertyAssigned(Status status) {
        return status != null;
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password=" + Arrays.toString(password) +
                ", salt=" + Arrays.toString(salt) +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", gender='" + gender + '\'' +
                '}';
    }
}
