package com.buya2z.model;

import com.buya2z.beans.product.ProductImage;

import java.util.List;

/**
 * Created by Jinu on 12/25/2016.
 */
public interface ImageDAO {

    public boolean saveProductImage(ProductImage image);

    public boolean saveProductImages(List<ProductImage> images);

}
