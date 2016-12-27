package com.buya2z.config;

import org.apache.log4j.Logger;

import java.io.File;

/**
 * Created by Jinu on 12/25/2016.
 */
public class DirectoryManager {

    private static DirectoryManager instance = new DirectoryManager();

    private final Logger LOGGER = Logger.getLogger(DirectoryManager.class);

    private final String DATA_DIRECTORY;

    private final String IMAGE_FOLDER_NAME = "img/";

    private final String PRODUCT_FOLDER_NAME = "products/";

    private final String SLIDER_FOLDER_NAME = "sliders/";

    private DirectoryManager() {
        LOGGER.info("Initializing DirectoryManager");
        DATA_DIRECTORY = setDataDirectory();
        setOtherDirectories();
        LOGGER.info("DirectoryManager Initialized");
    }

    private String setDataDirectory() {
        String dataDirectory = Config.getDataDirectory();
        File dataDirectoryFile = new File (dataDirectory);
        if(!dataDirectoryFile.exists()) {
            LOGGER.info("Data Directory not found trying to create it");
            dataDirectoryFile.mkdir();
            LOGGER.info("Data Directory created Successfully");
        }
        LOGGER.info("Data Directory Set as " + dataDirectory);
        return dataDirectory;
    }

    private void setOtherDirectories() {
        File imageDirectory = new File(getDataDirectory() + IMAGE_FOLDER_NAME);
        if(!imageDirectory.exists()) {
            LOGGER.info("Image Directory not found trying to create it");
            imageDirectory.mkdir();
            LOGGER.info("Image Directory created Successfully");
        }
        LOGGER.info("Image Directory Set as " + getDataDirectory() + IMAGE_FOLDER_NAME + PRODUCT_FOLDER_NAME);

        File productsDirectory  = new File(getDataDirectory() + IMAGE_FOLDER_NAME + PRODUCT_FOLDER_NAME);
        if(!productsDirectory.exists()) {
            LOGGER.info("Products Directory not found trying to create it");
            productsDirectory.mkdir();
            LOGGER.info("Products Directory created Successfully");
        }
        LOGGER.info("Data Directory Set as " + getDataDirectory() + IMAGE_FOLDER_NAME + PRODUCT_FOLDER_NAME);

        File sliderDirectory = new File(getDataDirectory() + IMAGE_FOLDER_NAME + SLIDER_FOLDER_NAME);
        if(!sliderDirectory.exists()) {
            LOGGER.info("Slider Directory not found trying to create it");
            sliderDirectory.mkdir();
            LOGGER.info("Slider Directory created Successfully");
        }
        LOGGER.info("Slider Directory Set as " + getDataDirectory() + IMAGE_FOLDER_NAME + SLIDER_FOLDER_NAME);
    }

    public String getDataDirectory() {
        return this.DATA_DIRECTORY;
    }

    public String getImageDirectory() {
        return this.getDataDirectory() + this.IMAGE_FOLDER_NAME;
    }

    public String getProductDirectory() {
        return this.getImageDirectory() + PRODUCT_FOLDER_NAME;
    }

    public String getSliderDirectory() {
        return this.getImageDirectory() + SLIDER_FOLDER_NAME;
    }

    public static DirectoryManager getInstance() {
        if (instance == null) {
            instance = new DirectoryManager();
        }
        return instance;
    }
}
