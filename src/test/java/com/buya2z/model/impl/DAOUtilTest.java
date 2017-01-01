package com.buya2z.model.impl;

import com.buya2z.TestInitializer;
import com.buya2z.model.jdbcimpl.DAOUtil;
import org.junit.Test;

/**
 * Created by Jinu on 12/27/2016.
 */
public class DAOUtilTest {
    public DAOUtilTest() {
        TestInitializer.initialize();
    }

    @Test
    public void testGenerateUniqueName() {
        String actual = DAOUtil.generateUniqueName("my nam    is   ");
        System.out.println(actual);
    }

    @Test
    public void testGetReader() {
//        ProductImage image = new ProductImage();
//        File file = null;
//        File dest = null;
//        try {
//            file = new File( this.getClass().getResource( "/image1.gif" ).toURI() );
//            System.out.println(testf.getName());
//            dest = new File(DirectoryManager.getInstance().getProductDirectory() + "somthing.gif");
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        try {
//            DAOUtil.copyFile(testf, dest);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
