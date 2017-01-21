package com.buya2z.beans.depricated.product;

import com.buya2z.beans.depricated.category.AbstractBean;
import com.buya2z.beans.depricated.category.QueryTransferObject;
import com.buya2z.config.DatabaseTable;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by Jinu on 12/26/2016.
 */
public class ProductImage extends AbstractBean {

    private static final Logger LOGGER = Logger.getLogger(ProductImage.class);

    private int id;

    private String url;

    private boolean isPrimary;

    private int productId;

    private String fileName;

    private InputStream reader;

    private OutputStream writer;

    public InputStream getReader() {
        return reader;
    }

    public void setReader(InputStream reader) {
        this.reader = reader;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public OutputStream getWriter() {
        return writer;
    }

    public void setWriter(OutputStream writer) {
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public QueryTransferObject getCreateQuery() {
        ArrayList values = new ArrayList();
        StringBuilder query = new StringBuilder("INSERT INTO " + DatabaseTable.getProductImageTableName() + " ( ");
        query.append("image_url, is_primary, product_id, ");
        values.add(url);
        values.add(isPrimary());
        values.add(getProductId());
        setTimeStampForCreate(query, values);
        closeQueryString(values.size(), query);
        return new QueryTransferObject(query.toString(), values);
    }

    public boolean validate() {
        boolean isValid = true;
        if( !isStringPropertyAssigned(this.fileName)) {
            LOGGER.info("Validation Failed At ProductImage: File Name not set");
            isValid = false;
        }
        if (reader == null) {
            LOGGER.info("Validation Failed At ProductImage: Reader not set");
            isValid = false;
        }
        return isValid;
    }
}
