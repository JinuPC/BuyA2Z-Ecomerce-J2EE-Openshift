package com.buya2z.controller;

import com.buya2z.app.Application;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Jinu on 11/26/2016.
 */
@WebServlet(name = "WelcomeController", urlPatterns = "/", loadOnStartup = 1 )
public class WelcomeController extends HttpServlet {

    private final Logger logger = Logger.getLogger(WelcomeController.class);

    private final Application APP = Application.getInstance();

    @Override
    public void init() throws ServletException {
       APP.start();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        try {
            PrintWriter out = resp.getWriter();
            logger.info("Executing doget");
            out.println(APP.getImagePath());
            File file = new File("c:/buya2z/images");
            out.println(file.exists());
            file.mkdir();
            logger.info("New file created");
            out.println(file.exists());
        } catch (Exception e ) {
            e.printStackTrace();
        }



    }

    @Override
    public void destroy() {
        APP.stop();
    }
}
