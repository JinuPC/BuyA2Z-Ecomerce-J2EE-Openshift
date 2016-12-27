package com.buya2z.model.impl;


import com.buya2z.beans.product.ProductImage;
import com.buya2z.config.DirectoryManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

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

    public static String generateUniqueName(String fileName) {
        fileName = fileName.replace(' ', '_');
        long timeMillis = System.currentTimeMillis();
        int randomInt = ThreadLocalRandom.current().nextInt(12345678, 999999999 + 1);
        return timeMillis + randomInt + fileName;
    }


    public boolean saveProductImage(ProductImage image) throws IOException {
        if(image.getReader() == null) {
            return false;
        }
        String location = DirectoryManager.getInstance().getProductDirectory();
        Path path = Paths.get(location + image.getFileName());
        Files.copy(image.getReader(), path);
        return true;
    }

    public boolean saveProductImages(List<ProductImage> images) throws IOException {
        boolean isSaved = false;
        if(images == null || images.isEmpty()) {
            return isSaved;
        }
        for(ProductImage image : images) {
            saveProductImage(image);
        }
        return isSaved;
    }

}
