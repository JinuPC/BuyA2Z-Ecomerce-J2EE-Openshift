package com.buya2z.model.jdbcimpl;

import com.buya2z.beans.product.ProductImage;
import com.buya2z.config.DirectoryManager;
import com.buya2z.model.ImageDAO;

import java.io.*;
import java.util.List;

/**
 * Created by Jinu on 12/26/2016.
 */
public class ImageDAOImpl implements ImageDAO{

    @Override
    public boolean saveProductImage(ProductImage image) {
        boolean isSaved = false;
        String outputDirectory = DirectoryManager.getInstance().getProductDirectory();
        String fileName = DAOUtil.generateUniqueName(image.getFileName());
        image.setUrl(fileName);
        File file = new File(outputDirectory + fileName);
        try (OutputStream out = new FileOutputStream(file)) {
            DAOUtil.copyFile(image.getReader(), out);
            isSaved = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public boolean saveProductImages(List<ProductImage> images) {
        for(ProductImage image : images) {
            if(!saveProductImage(image)) {
                return false;
            }
        }
        return true;
    }
}
