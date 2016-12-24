package com.buya2z.app;

import com.buya2z.config.Database;
import org.apache.log4j.Logger;

/**
 * Created by Jinu on 12/24/2016.
 */
public class Application {
    private final Logger LOGGER = Logger.getLogger(Application.class);
    private static Application application = new Application();

    private Application() {
        initApplication();
    }

    public void initApplication() {
        System.out.println("***********************************************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\tApplication Started");
        System.out.println("***********************************************************************************************");
        LOGGER.info("Application Started");
        LOGGER.info("Initializing Application ");
        Database.init();
        LOGGER.info("Initialization finished");
    }

    public void destroyApplication() {
        LOGGER.info("Closing Application");
        Database.destroy();
        LOGGER.info("Application Closed");
        System.out.println("***********************************************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\tApplication Closed");
        System.out.println("***********************************************************************************************");
    }

    public static Application getInstance() {
        if(application == null) {
            application = new Application();
        }
        return application;
    }

}
