package com.buya2z.model.jdbcimpl;

import com.buya2z.beans.user.*;
import com.buya2z.config.Database;
import com.buya2z.config.DatabaseTable;
import com.buya2z.config.PasswordManager;
import com.buya2z.model.UserDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Jinu on 12/25/2016.
 */
public class UserDAOImpl implements UserDAO {
    private final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    @Override
    public boolean create(User user) {
        boolean isCreated = false;
        try {
            boolean userInserted = insertUser(user);
            if (!userInserted) {
                return false;
            }
            if (user.isSeller()) {
                insertSeller((Seller) user);
            }
            isCreated = true;
        } catch (SQLException e) {
            LOGGER.error("Exception happened while creating User : " + e);
        }
        return isCreated;
    }

    private boolean insertUser(User user) throws SQLException {
        if (doInsert(user.getCreateValues(), DatabaseTable.getUserTableName())) {
            LOGGER.info("User " + user + " Created Successfully");
            user.setId(Database.getAutoIncrementedId(DatabaseTable.getUserTableName()));
            return true;
        }
        return false;
    }

    private boolean insertSeller(Seller seller) throws SQLException {
        if (doInsert(seller.getSellerCreateValues(), DatabaseTable.getSellerTableName())) {
            LOGGER.info("Seller " + seller + " Created Successfully");
            seller.setSellerId(Database.getAutoIncrementedId(DatabaseTable.getSellerTableName()));
            return true;
        }
        return false;
    }

    private boolean doInsert(Map<String, Object> columnWithValues, String tableName) throws SQLException {
        boolean isInserted = false;
        Connection connection = Database.getConnection();
        String query = DAOUtil.getCreateQuery(tableName, columnWithValues);
        System.out.println(query);
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            DAOUtil.setPreparedValues(preparedStatement, columnWithValues);
            if (preparedStatement.executeUpdate() > 0) {
                isInserted = true;
            }
        } finally {
            Database.close(connection);
        }
        return isInserted;
    }

    @Override
    public boolean authenicate(String emailOrPhone, char[] attemptedPassword) {
        boolean isValid = false;
        Connection connection = Database.getConnection();
        try (PreparedStatement preparedStatement = getAuthenticationPreparedStatement(emailOrPhone, connection);
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            if (resultSet.next()) {
                byte[] encryptedPassword = resultSet.getBytes("password");
                byte[] salt = resultSet.getBytes("salt");
                isValid = PasswordManager.authenticate(attemptedPassword, encryptedPassword, salt);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception happened at authentication" + e);
        } finally {
            Database.close(connection);
        }
        return isValid;
    }

    private PreparedStatement getAuthenticationPreparedStatement(String emailOrPhone, Connection connection) throws SQLException {
        String query = "SELECT password, salt FROM " + DatabaseTable.getUserTableName() + " WHERE email = ? OR " +
                "phone_number = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, emailOrPhone);
        preparedStatement.setString(2, emailOrPhone);
        return preparedStatement;
    }

    @Override
    public User getUser(int id) {
        User user = null;
        String sellerTable = DatabaseTable.getSellerTableName();
        String userTable = DatabaseTable.getUserTableName();
        String query = "SELECT * FROM " + userTable + " LEFT JOIN " +
                sellerTable + " ON " + userTable + ".user_id = " + sellerTable + ".user_id WHERE " +
                userTable + ".user_id = ?";
        return findUser(query, id);
    }

    private User findUser(String query, int id) {
        Connection connection = Database.getConnection();
        try (PreparedStatement preparedStatement = getPreparedStatementForOneValue(query, id, connection);
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            if (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception happened while getting user", e);
        } finally {
            Database.close(connection);
        }
        return null;
    }

    private PreparedStatement getPreparedStatementForOneValue(String query, int value, Connection con) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement(query);
        DAOUtil.setValue(1, value, preparedStatement);
        return preparedStatement;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = getNewUser(resultSet.getString("role"));
        if (user == null) {
            return null;
        }
        setUserFromResultSet(user, resultSet);
        return user;
    }

    private User getNewUser(String role) {
        UserRole userRole = UserRole.getUserRole(role);
        if (userRole == UserRole.ADMIN) {
            return new Admin();
        }
        if (userRole == UserRole.BUYER) {
            return new Buyer();
        }
        if (userRole == UserRole.SELLER) {
            return new Seller();
        }
        return null;
    }

    private void setUserFromResultSet(User user, ResultSet resultSet) throws SQLException {
        user.setId(resultSet.getInt("user_id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPhoneNumber(resultSet.getString("phone_number"));
        user.setGender(resultSet.getString("gender"));
        user.setUpdatedAt(resultSet.getTimestamp("created_at"));
        user.setCreatedAt(resultSet.getTimestamp("updated_at"));
        int status = resultSet.getInt("status");
        user.setStatus(Status.getStatus(status));

        //Check and set Seller Deatils
        if (user.isSeller()) {
            setSellerFromResultSet((Seller) user, resultSet);
        }
    }

    private void setSellerFromResultSet(Seller seller, ResultSet resultSet) throws SQLException {
        seller.setSellerId(resultSet.getInt("seller_id"));
        seller.setTinNumber(resultSet.getString("tin_number"));
        seller.setPanNumber(resultSet.getString("pan_number"));
        seller.setCompany(resultSet.getString("company"));
        seller.setCompanyLocation(resultSet.getString("company_location"));
        seller.setBusinessEmail(resultSet.getString("business_email"));
        seller.setBusinessPhoneNumber(resultSet.getString("business_phone"));
        seller.setFaxNumber(resultSet.getString("business_fax"));
        seller.setSellerDescription(resultSet.getString("description"));
        String bankName = resultSet.getString("bank_name");
        if (bankName != null && !bankName.isEmpty()) {
            Seller.SellerBankDetail bankDetail = seller.new SellerBankDetail();
            setBankDetailsFromResultSet(bankDetail, resultSet);
            seller.setBankDetails(bankDetail);
        }
    }

    private void setBankDetailsFromResultSet(Seller.SellerBankDetail bank, ResultSet resultSet) throws SQLException {
        String bankName = resultSet.getString("bank_name");
        String ifscCode = resultSet.getString("ifsc_code");
        String branch = resultSet.getString("bank_branch");
        String accountNumber = resultSet.getString("account_number");
        bank.setBankName(bankName);
        bank.setIfscCode(ifscCode);
        bank.setBranch(branch);
        bank.setAccountNumber(accountNumber);
    }
}
