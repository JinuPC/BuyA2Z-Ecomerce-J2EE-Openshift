package com.buya2z.model.impl;

import com.buya2z.TestInitializer;
import com.buya2z.beans.product.ProductImage;
import com.buya2z.config.dummydata.TableData;
import com.buya2z.model.DAOFactory;
import com.buya2z.model.ImageDAO;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by Jinu on 12/28/2016.
 */
public class ImageDAOTest {
    public ImageDAOTest() {
        TestInitializer.initialize();
    }

    @Test
    public void testSaveProductImages() {
        ArrayList<ProductImage> images = new ArrayList<>();
        for(int i =1; i <=7; i++) {
            ProductImage image = null;
            try {
                image = new ProductImage();
                File file = new File(TableData.class.getResource( "/dell/dell"+i +".jpeg" ).toURI());
                image.setFileName(file.getName());
                image.setReader(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            images.add(image);
        }
        ImageDAO dao = DAOFactory.getImageDAO();
        dao.saveProductImages(images);
        System.out.println(images);
    }
}
