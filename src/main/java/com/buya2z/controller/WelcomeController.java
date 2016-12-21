package com.buya2z.controller;

import com.buya2z.config.Config;
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
@WebServlet("/")
public class WelcomeController extends HttpServlet {
    Config config;
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database.init();
        Logger logger = Logger.getLogger(WelcomeController.class);
        logger.info("something");
        resp.getWriter().print(config);
    }
}
