package com.buya2z.config;

import org.apache.log4j.Logger;

import java.io.File;

/**
 * Created by Jinu on 12/25/2016.
 */
public class DirectoryManager {

    private static DirectoryManager instance = new DirectoryManager();

    private final Logger LOGGER = Logger.getLogger(DirectoryManager.class);

    private final String RESOURCE_FOLDER_NAME = "res";

    private final String DATA_DIRECTORY;

    private final String RESOURCE_DIRECTORY;

    private DirectoryManager() {
        LOGGER.info("Initializing DirectoryManager");
        DATA_DIRECTORY = Config.getDataDirectory();
        RESOURCE_DIRECTORY = setImageDirectory();
        LOGGER.info("Set Data Directory as " + DATA_DIRECTORY);
        LOGGER.info("Set Resource Directory as " + RESOURCE_DIRECTORY);
    }

    private String setImageDirectory() {
        String imageDirectoryName = "";
        try {
            File directoryFile = new File(DATA_DIRECTORY);
            if (!directoryFile.exists()) {
                LOGGER.info("Data Directory is not found Trying to create directory file");
                directoryFile.mkdir();
                LOGGER.info("Data Directory is created as " + DATA_DIRECTORY);
            }
            imageDirectoryName = DATA_DIRECTORY + RESOURCE_FOLDER_NAME;
            File imageDirectory = new File(imageDirectoryName);
            if (!imageDirectory.exists()) {
                LOGGER.info("Resource Directory not found trying to create Resource Directory");
                imageDirectory.mkdir();
                LOGGER.info("Resource Directory is created as " + RESOURCE_FOLDER_NAME);
            }
        } catch (Exception e) {
            LOGGER.error("Exception happend while making Data and image Directory Creation", e);
        }

        return imageDirectoryName;
    }

    public String getResourceDirectory() {
        return RESOURCE_DIRECTORY;
    }

    public File getResourceFile() {
        return new File(RESOURCE_DIRECTORY);
    }

    public static DirectoryManager getInstance() {
        if (instance == null) {
            instance = new DirectoryManager();
        }
        return instance;
    }
}
