package com.buya2z.model.jdbcimpl;


import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Jinu on 12/26/2016.
 */
public class DAOUtil {

    private DAOUtil() {}

    public static void setPreparedValues(PreparedStatement preparedStatement, List values) throws SQLException {
        for(int i = 0 ; i < values.size(); i ++) {
            setValue(i + 1, values.get(i), preparedStatement);
        }
    }

    public static void setPreparedValues(PreparedStatement preparedStatement, Map<String, Object> columnWithValues) throws SQLException{
        int index = 1;
        for(String column : columnWithValues.keySet()) {
            setValue(index ++, columnWithValues.get(column), preparedStatement);
        }
    }

    public static void setValue(int index , Object value, PreparedStatement pstmt) throws SQLException {
        if(value instanceof Integer) {
            pstmt.setInt(index, (Integer) value);
        } else if(value instanceof Float) {
            pstmt.setFloat(index, (Float) value);
        } else if(value instanceof String) {
            pstmt.setString(index, (String) value);
        } else if(value instanceof Double) {
            pstmt.setDouble(index, (Double) value);
        } else if(value instanceof Boolean) {
            pstmt.setBoolean(index, (Boolean) value);
        } else if(value instanceof Timestamp) {
            pstmt.setTimestamp(index, new Timestamp(new Date().getTime()));
        } else if(value instanceof byte[]) {
            pstmt.setBytes(index, (byte[]) value);
        }
    }

    public static String generateUniqueName(String fileName) {
        fileName = fileName.replace(' ', '_');
        long timeMillis = System.currentTimeMillis();
        int randomInt = ThreadLocalRandom.current().nextInt(12345678, 999999999 + 1);

        return timeMillis + randomInt + fileName;
    }

    public  static void copyFile(File source, File dest) throws IOException {
        InputStream reader = new FileInputStream(source);
        OutputStream writer = new FileOutputStream(dest);
        copyFile(reader, writer);
    }

    public static void copyFile(InputStream reader, OutputStream writer) throws IOException {
        try {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, length);
            }
        } finally {
            reader.close();
            writer.close();
        }
    }

    public static String getCreateQuery(String tableName, Map<String, Object> columnWthValues) {

        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder closingQuery = new StringBuilder(") VALUES (");
        for(String column : columnWthValues.keySet()) {
            query.append(column + ",");
            closingQuery.append("?,");
        }
        query.setLength(query.length() - 1);
        closingQuery.setLength(closingQuery.length() - 1);

        return query.toString() + closingQuery.toString() + ")";
    }

}
