package com.buya2z.app;

import com.buya2z.config.DirectoryManager;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;

/**
 * Created by Jinu on 12/25/2016.
 */
public class ImageHandler {
//    public void CopyImage() {
//        //File inputFile = new File("resources/storediagram.gif");
//        try {
//            File testf = new File( this.getClass().getResource( "/storediagram.gif" ).toURI() );
//            File dest = new File(DirectoryManager.getInstance().getResourceDirectory() + "/storediagram.gif");
//            try {
//                copyFileUsingFileStreams(testf, dest);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println(testf.exists());
//
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void copyFileUsingFileStreams(File source, File dest)
//            throws IOException {
//        Files.copy(source.toPath(), dest.toPath());
//    }
//
//    public static void main(String[] args) {
//        ImageHandler ih = new ImageHandler();
//        ih.CopyImage();
//    }
}
