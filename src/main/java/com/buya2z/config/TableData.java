package com.buya2z.config;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

/**
 * Created by Jinu on 11/30/2016.
 */
public class TableData {

    private final Logger logger = Logger.getLogger(TableData.class);

    private Map<String, List<TableData.Record>> tableRecords;

    public TableData() {
        this.tableRecords = new HashMap<>();
    }

    public void setTableData() {
        setTableRecords();
        for(String tableName : tableRecords.keySet()) {
            logger.info("Updating " + tableName + " Table Data");
            checkAndInsertData(tableName, tableRecords.get(tableName));
        }
    }

    private void setTableRecords() {


//        setRecord("praveen",
//                new Record(1, "praveen"),
//                new Record(2, "jinu")
//        );

    }

    private void setRecord(String tableName, Record... records) {
        ArrayList<Record> recordsList = new ArrayList();
        Collections.addAll(recordsList, records);
        tableRecords.put(tableName, recordsList);
    }

    private void checkAndInsertData(String tableName, List<Record> records) {
        Connection con = Database.getConnection();
        try {
            if(isTableEmpty(tableName, con)) {
                logger.info(tableName + " Data Updated ");
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
        return preparedStatement;
    }

    private void setPreparedValue(PreparedStatement pstmt , Object value, int postion) throws SQLException {
        if(value instanceof Integer) {
            pstmt.setInt(postion, (Integer) value);
        } else if(value instanceof Float) {
            pstmt.setFloat(postion, (Float) value);
        } else if(value instanceof String) {
            pstmt.setString(postion, (String) value);
        } else if(value instanceof Double) {
            pstmt.setDouble(postion, (Double) value);
        } else if(value instanceof Boolean) {
            pstmt.setBoolean(postion, (Boolean) value);
        }
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
