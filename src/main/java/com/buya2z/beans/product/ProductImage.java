package com.buya2z.beans.product;

import com.buya2z.beans.AbstractBean;
import com.buya2z.beans.QueryTransferObject;
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
        int count = 0;
        StringBuilder query = new StringBuilder("INSERT INTO " + DatabaseTable.getProductImageTableName() + " ( ");
        if(isStringPropertyAssigned(url)) {
            query.append("image_url, ");
            values.add(url);
            count ++;
        }
        query.append("is_primary, ");
        count++;
        values.add(isPrimary());
        if(isIntegerPropertyAssigned(productId)) {
            query.append("product_id, ");
            count++;
            values.add(getProductId());
        }
        count += setTimeStampForCreate(query, values);
        closeQueryString(count, query);
        return new QueryTransferObject(query.toString(), values);
    }
    public boolean validate() {
        if(this.url == null || this.url.isEmpty()) {
            LOGGER.info("Warning : Url is not set");
            return false;
        }
        if(reader == null) {
            LOGGER.info("Warning : Image Reader is not set");
            return false;
        }
        return true;
    }
}
