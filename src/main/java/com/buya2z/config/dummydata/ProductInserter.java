package com.buya2z.config.dummydata;

import com.buya2z.beans.product.Feature;
import com.buya2z.beans.product.MainFeature;
import com.buya2z.beans.product.Product;
import com.buya2z.beans.product.ProductImage;
import com.buya2z.beans.user.Seller;
import com.buya2z.model.DAOFactory;
import com.buya2z.model.ProductDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by Jinu on 12/28/2016.
 */
public class ProductInserter {

    public ProductInserter() {
        insertDellProducts();
    }

    public void insertDellProducts() {
        //ProductInsertion for dell
        ArrayList<ProductImage> images = new ArrayList<>();
        for(int i =1; i <=7; i++) {
            ProductImage image = new ProductImage();
            File file = getFileFromResourceDirectory("dell/dell" + i + ".jpeg");
            image.setFileName(file.getName());
            try {
                image.setReader(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            images.add(image);
        }
        ArrayList<Feature> features = new ArrayList<>();
        Feature feature = new Feature();
        feature.setSpecificationId(1);
        feature.setTitle("Sales Package");
        feature.setDescription("Laptop, Battery, Power Adaptor, User Guide and Warranty Document");
        features.add(feature);
        feature = new Feature();
        feature.setSpecificationId(1);
        feature.setTitle("Model Number");
        feature.setDescription("3558");
        features.add(feature);

        ArrayList<MainFeature> mainFeatures = new ArrayList<>();
        MainFeature feature1 = new MainFeature();
        feature1.setTitle("something");
        feature1.setDescription("3344");
        mainFeatures.add(feature1);

        Seller seller = new Seller();
        seller.setId(2);

        Product product = new Product();
        product.setMrp(26599.00);
        product.setName("Dell laptop");
        product.setCategoryId(11);
        product.setShortDescription("Dell Inspiron Core i3 5th Gen - (4 GB/1 TB HDD/Linux) " +
                "Z565155HIN9/Z565155UIN9 3558 Notebook  (15.6 inch, Black)");
        product.setSpecialNotes("For Driver related information, Please visit " +
                "https://dl.flipkart.com/dl/laptops-driver-links");
        product.setThumbnail("something");
        product.setCreatedBy(seller);
        product.setMainFeatures(mainFeatures);
        product.setFeatures(features);
        product.setImages(images);

        ProductDAO dao = DAOFactory.getProductDAO();
        dao.create(product);

    }

    private File getFileFromResourceDirectory(String fileName) {
        try {
            return new File(this.getClass().getResource( "/" + fileName ).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
