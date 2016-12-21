package com.buya2z.config;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jinu on 12/13/2016.
 */
public class ConfigTest {
    @Test
    public void test() {
        assertEquals("CE", "CE");
        String name = null;
        test23(name = "somdsdf");
    }
    public void test23(String arg) {
        System.out.println(arg);
    }
}
