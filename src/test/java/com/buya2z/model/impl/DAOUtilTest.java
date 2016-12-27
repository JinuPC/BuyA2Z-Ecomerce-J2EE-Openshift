package com.buya2z.model.impl;

import com.buya2z.TestInitializer;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

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
}
