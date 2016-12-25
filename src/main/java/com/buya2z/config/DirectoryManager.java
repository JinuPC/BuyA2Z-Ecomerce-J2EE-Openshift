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

    private final String IMAGE_DIRECTORY;

    private DirectoryManager() {
        LOGGER.info("Initializing DirectoryManager");
        DATA_DIRECTORY = Config.getDataDirectory();
        LOGGER.info("Set Data Directory as " + DATA_DIRECTORY);
        IMAGE_DIRECTORY = setImageDirectory();
        LOGGER.info("Set Image Dirctory as " + IMAGE_DIRECTORY);
    }

    private String setImageDirectory() {
        String imageDirectoryName = "";
        try {
            File directoryFile = new File(DATA_DIRECTORY);
            if (!directoryFile.exists()) {
                LOGGER.info("Directory file is not found Trying to create directory file");
                directoryFile.mkdir();
            }
            imageDirectoryName = DATA_DIRECTORY + "/images";
            File imageDirectory = new File(imageDirectoryName);
            if (!imageDirectory.exists()) {
                LOGGER.info("Image file not found trying to create Image Directory");
                imageDirectory.mkdir();
            }
        } catch (Exception e) {
            LOGGER.error("Exception happend while making Data and image Directory Creation", e);
        }

        return imageDirectoryName;
    }

    public String getImageDirectory() {
        return IMAGE_DIRECTORY;
    }

    public File getImageDirectoryFile() {
        return new File(IMAGE_DIRECTORY);
    }

    public static DirectoryManager getInstance() {
        if (instance == null) {
            instance = new DirectoryManager();
        }
        return instance;
    }
}
