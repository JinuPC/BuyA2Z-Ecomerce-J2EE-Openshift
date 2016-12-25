package com.buya2z.app;

import com.buya2z.config.Config;
import com.buya2z.config.Database;
import com.buya2z.config.DirectoryManager;
import com.buya2z.model.CategoryDAO;
import com.buya2z.model.CategoryList;
import com.buya2z.model.DAOFactory;
import org.apache.log4j.Logger;

/**
 * Created by Jinu on 12/24/2016.
 */
public class Application {
    private static Application application = new Application();

    private final Logger LOGGER = Logger.getLogger(Application.class);

    private final String DATA_DIRECTORY = Config.getDataDirectory();

    private Application() { }

    public void start() {
        System.out.println("***********************************************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\tApplication Started");
        System.out.println("***********************************************************************************************");
        LOGGER.info("Application Started");
        LOGGER.info("Initializing Application ");
        Database.init();
        DirectoryManager.getInstance();
        LOGGER.info("Initialization finished");
    }

    public void stop() {
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

    public CategoryList getCategoryList() {
        CategoryDAO categoryDAO = DAOFactory.getCategoryDAO();
        return categoryDAO.getCategoryList();
    }

    public String getImagePath() {
        return DATA_DIRECTORY + "/images";
    }

}
