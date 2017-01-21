package com.buya2z.controller;

import com.buya2z.app.Application;
import com.buya2z.beans.depricated.category.Category;
import com.buya2z.beans.depricated.category.MainCategory;
import com.buya2z.model.CategoryList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jinu on 1/1/2017.
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") == null) {
            req.getRequestDispatcher("category.html").forward(req,resp);
        } else {
            int id = Integer.parseInt(req.getParameter("id"));
            resp.setContentType("text/json");

            CategoryList list = Application.getInstance().getCategoryList();
            MainCategory category = (MainCategory) list.getCategory(id);
            List categories = category.getSubCategories();
            String json = "{ \"value\": [";
            int index = 0;
            for(Object item : categories) {
                index++;
                String name = ((Category)item).getName();
                json += "\"" + name +"\""+ ",";
            }
            json  = json.substring(0, json.length() - 1) + "]}";
            System.out.println(json);
            resp.getWriter().print(json);
        }
    }
}
