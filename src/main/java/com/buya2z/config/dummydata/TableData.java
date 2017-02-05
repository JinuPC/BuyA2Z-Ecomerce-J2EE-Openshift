package com.buya2z.config.dummydata;

import com.buya2z.config.depricated.Database;
import com.buya2z.config.PasswordManager;
import com.buya2z.model.jdbcimpl.DAOUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by Jinu on 11/30/2016.
 */
public class TableData {

    private final Logger LOGGER = Logger.getLogger(TableData.class);

    private Map<String, List<TableData.Record>> tableRecords;

    public TableData() {
        this.tableRecords = new LinkedHashMap<>();
    }

    public void setTableData() {
        setTableRecords();
        for(String tableName : tableRecords.keySet()) {
            LOGGER.info("Updating " + tableName + " Table Data");
            checkAndInsertData(tableName, tableRecords.get(tableName));
        }

        //Adding records by using dao

    }

    private void setTableRecords() {
        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        byte[] salt = new byte[8];
        char[] password = {'r','o','o','t'};
        salt = PasswordManager.generateSalt();
        byte[] encryptedPassword = PasswordManager.getEncryptedPassword(password, salt);

        //Records for user table
        setRecords("user",
                new Record(1, "jinu", "P C", "pcjinu@ymail.com", "978624048", "admin",
                        encryptedPassword, salt, 1, "male", timestamp, timestamp),
                new Record(2, "Praveen", "I", "pravy.cs@gmail.com", "9206945316", "seller",
                        encryptedPassword, salt, 1, "male", timestamp, timestamp),
                new Record(3, "Ammus", "I", "ammu@gmail.com", "9206945316", "buyer",
                        encryptedPassword, salt, 1, "female", timestamp, timestamp)
        );
        //Records for address table
        setRecords("address",
                new Record(1, "Jinu", "Thaloor", "Opposite Niligiri College",
                        "Sulthan Bathery", "Tamil Nadu", "643239", "9786240548",
                        1, timestamp, timestamp, 1)
        );
        //Records for seller table
        setRecords("seller",
                new Record(1, "123456789", "Aogpj3788c", "praveentraders", "banglore",
                        "pravey@business.ocm", "8383838383", "1234567890",
                        "hdfc", "9349kajsd93i4", "dskljfkd", "gudalur", "good brands retailer",
                        timestamp, timestamp, 2)
        );
        //Records for Category
        setRecords("category",
                //Main Categories
                new Record(1, "Electronics", 0, "main", timestamp, timestamp),
                new Record(2, "Men", 0, "main", timestamp, timestamp),
                new Record(3, "Appliances", 0, "main", timestamp, timestamp),
                new Record(4, "Women", 0, "main", timestamp, timestamp),
                new Record(5, "Baby&Kids", 0, "main", timestamp, timestamp),
                new Record(6, "Home&Appliances", 0, "main", timestamp, timestamp),
                new Record(7, "Books&More", 0, "main", timestamp, timestamp),

                //Subacategory for Electronics
                new Record(8, "Mobiles", 1, "sub", timestamp, timestamp),
                new Record(9, "Mobile Accessories", 1, "sub", timestamp, timestamp),
                new Record(10, "Wearables", 1, "sub", timestamp, timestamp),
                new Record(11, "Laptops", 1, "sub", timestamp, timestamp),
                new Record(12, "Computer Accessories", 1, "sub", timestamp, timestamp),
                new Record(13, "Camera", 1, "sub", timestamp, timestamp),
                new Record(14, "Television", 1, "sub", timestamp, timestamp),
                new Record(15, "Tablets", 1, "sub", timestamp, timestamp),

                //LowerCategory for mobiles
                new Record(16, "Samsung", 8, "lower", timestamp, timestamp),
                new Record(17, "Lenovo", 8, "lower", timestamp, timestamp),
                new Record(18, "Mi", 8, "lower", timestamp, timestamp),
                new Record(19, "Motorola", 8, "lower", timestamp, timestamp),
                new Record(20, "LEco", 8, "lower", timestamp, timestamp),
                new Record(21, "Asus", 8, "lower", timestamp, timestamp),
                new Record(22, "Apple", 8, "lower", timestamp, timestamp),
                new Record(23, "Micromax", 8, "lower", timestamp, timestamp),
                new Record(24, "LEco", 8, "lower", timestamp, timestamp),
                new Record(25, "LEco", 8, "lower", timestamp, timestamp),

                //Lower Category for Mobile Accessories
                new Record(26, "Mobile Cases", 9, "lower", timestamp, timestamp),
                new Record(27, "Head Phones", 9, "lower", timestamp, timestamp),
                new Record(28, "Power Banks", 9, "lower", timestamp, timestamp),
                new Record(29, "Power Banks", 9, "lower", timestamp, timestamp),
                new Record(30, "Screen Guards", 9, "lower", timestamp, timestamp),
                new Record(31, "Memory Cards", 9, "lower", timestamp, timestamp),
                new Record(32, "Pen Drives", 9, "lower", timestamp, timestamp),
                new Record(33, "Cables ", 9, "lower", timestamp, timestamp),
                new Record(34, "Chargers", 9, "lower", timestamp, timestamp),
                new Record(35, "Selfi Sticks", 9, "lower", timestamp, timestamp),

                //Lower Category for Wearables
                new Record(36, "Smart Watches", 10, "lower", timestamp, timestamp),
                new Record(37, "Smart Bands", 10, "lower", timestamp, timestamp),
                new Record(38, "Smart Glasses", 10, "lower", timestamp, timestamp),

                //Lower Category for Laptops
                new Record(39, "Lenovo", 11, "lower", timestamp, timestamp),
                new Record(40, "Dell", 11, "lower", timestamp, timestamp),
                new Record(41, "Hp", 11, "lower", timestamp, timestamp),
                new Record(42, "Sony", 11, "lower", timestamp, timestamp),

                new Record(101, "Personal Care", 2, "sub", timestamp, timestamp)
        );
        setRecords("product",
                new Record(1, "asus zenfone", "This is a good phone", "image url",
                        1, 1, 12000.00, "some special notes",
                        timestamp, timestamp, 2, 21
                        )
        );
        setRecords("specification",
                new Record(1, "mainSpecifcation", timestamp, timestamp
        ));

    }

    private void setRecords(String tableName, Record... records) {
        ArrayList<Record> recordsList = new ArrayList();
        Collections.addAll(recordsList, records);
        tableRecords.put(tableName, recordsList);
    }

    private void checkAndInsertData(String tableName, List<Record> records) {
        Connection con = Database.getConnection();
        try {
            if(isTableEmpty(tableName, con)) {
                LOGGER.info(tableName + " Data Updated ");
                insertData(tableName, records, con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.close(con);
        }
    }

    private void insertData(String tableName, List<Record> records, Connection con) {
        for(Record record : records) {
            try(PreparedStatement pstmt = getPreparedStatementForTable(con, tableName, record.getRecord())) {
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public PreparedStatement getPreparedStatementForTable(Connection con , String tableName, List columns) throws SQLException {
        String query = "insert into " + tableName + " values( ";
        for(int i = 1 ; i <= columns.size(); i++) {
            query += " ?,";
        }
        query = query.substring(0, query.length() - 1) + " ) ";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        for(int i = 0; i < columns.size(); i++) {
            setPreparedValue(preparedStatement, columns.get(i), i+1);
        }
        ResultSet rs;
        return preparedStatement;
    }

    private void setPreparedValue(PreparedStatement pstmt , Object value, int postion) throws SQLException {
        DAOUtil.setValue(postion, value, pstmt);
    }

    private boolean isTableEmpty(String tableName, Connection con) throws SQLException {
        boolean isEmpty = false;
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM " + tableName)
        ){
            if(rs.next()) {
                if(rs.getInt("count") < 1 ) {
                    isEmpty = true;
                }
            }
        }
        return isEmpty;
    }

    private class Record {
        List<Object> data;
        Record(Object... values) {
            this.data = new ArrayList<>();
            for(Object value : values) {
                this.data.add(value);
            }
        }

        List<Object> getRecord() {
            return this.data;
        }

    }



}
