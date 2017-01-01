package com.buya2z.dummydata;

import com.buya2z.TestInitializer;
import com.buya2z.config.dummydata.ProductInserter;
import org.junit.Test;

/**
 * Created by Jinu on 12/28/2016.
 */
public class ProductInserterTest {
    public ProductInserterTest() {
        TestInitializer.initialize();
    }

    @Test
    public void testInserter() {
        new ProductInserter();
    }
}
