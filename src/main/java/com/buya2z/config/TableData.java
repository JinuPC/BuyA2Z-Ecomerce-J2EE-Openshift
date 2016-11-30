package com.buya2z.config;

import java.sql.*;
import java.util.*;

/**
 * Created by Jinu on 11/30/2016.
 */
public class TableData {

    private Map<String, List<TableData.Record>> tableRecords;

    public TableData() {
        this.tableRecords = new HashMap<>();
    }

    public void setTableData() {
        setTableRecords();
        for(String tableName : tableRecords.keySet()) {
            checkAndInsertData(tableName, tableRecords.get(tableName));
        }
    }

    private void setTableRecords() {
        System.out.println("Table records getting");
        setRecord("user",
                new Record(1, "jinu"),
                new Record(2, "james"),
                new Record(3, "Hello"),
                new Record(4, "haeedaf"),
                new Record(5, "THis is great")
        );
        setRecord("product",
                new Record(1, "Samsung galaxy"),
                new Record(2, "Apple Iphone")
        );
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
        System.out.println(isEmpty);
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
