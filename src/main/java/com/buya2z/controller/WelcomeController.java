package com.buya2z.controller;

import com.buya2z.config.Database;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jinu on 11/26/2016.
 */
@WebServlet(name = "WelcomeController", urlPatterns = "/", loadOnStartup = 1 )
public class WelcomeController extends HttpServlet {

    private final Logger logger = Logger.getLogger(WelcomeController.class);

    @Override
    public void init() throws ServletException {
        logger.info("Initializing Application ");
        Database.init();
        logger.info("Initialization finished");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("index1.jsp").forward(req, resp);
        //req.getRequestDispatcher("/index1.jsp").include(req, resp);
    }

    @Override
    public void destroy() {
        logger.info("Closing Application");
        Database.destroy();
        logger.info("Application Closed");
    }
}
