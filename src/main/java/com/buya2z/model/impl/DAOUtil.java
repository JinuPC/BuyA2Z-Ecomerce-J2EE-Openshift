package com.buya2z.model.impl;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
            pstmt.setTimestamp(index, (Timestamp) value);
        }
    }

}
