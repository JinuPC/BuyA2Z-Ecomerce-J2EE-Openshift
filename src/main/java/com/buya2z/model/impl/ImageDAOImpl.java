package com.buya2z.model.impl;

import com.buya2z.config.DirectoryManager;
import com.buya2z.model.ImageDAO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by Jinu on 12/26/2016.
 */
public abstract class ImageDAOImpl implements ImageDAO{
    //private final String DESTINATION_DIRECTORY;

//    public ImageDAOImpl() {
//        DESTINATION_DIRECTORY = DirectoryManager.getInstance().getResourceDirectory();
//    }
//
//    @Override
//    public boolean copyFile(File source, String destinationFileName) {
//        boolean isCopied = false;
//        File dest = new File(DESTINATION_DIRECTORY + "/" + destinationFileName);
//        try {
//            Files.copy(source.toPath(), dest.toPath());
//            isCopied = true;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return isCopied;
//    }
}
