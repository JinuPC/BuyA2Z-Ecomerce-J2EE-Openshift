package com.buya2z;

import com.buya2z.config.Database;

/**
 * Created by Jinu on 12/24/2016.
 */
public class TestInitializer {

    private static boolean isInitialized = false;

    private TestInitializer() {}

    public static void initialize() {
        if(!isInitialized) {
            Database.init();
            isInitialized = true;
        }
    }

}
