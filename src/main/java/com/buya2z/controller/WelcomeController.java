package com.buya2z.controller;

import com.buya2z.config.Config;
import com.buya2z.config.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jinu on 11/26/2016.
 */
public class WelcomeController extends HttpServlet {
    Config config;
    @Override
    public void init() throws ServletException {
       config = new Config();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(config);
        resp.getWriter().print(Database.getConnection());
    }
}
