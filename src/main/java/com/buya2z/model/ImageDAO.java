package com.buya2z.model;

import java.io.File;

/**
 * Created by Jinu on 12/25/2016.
 */
public interface ImageDAO {

    public boolean copyFile(File source, String destinationFileName);

}
