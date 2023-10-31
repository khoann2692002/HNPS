/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;

/**
 *
 * @author ASUS
 */
public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CategoryDao categoryDao = new CategoryDao();
        request.setAttribute("categoryList", categoryDao.getAllCategory());
        PrintWriter out = response.getWriter();
        for (Category ca : categoryDao.getAllCategory()) {
            out.print(ca);
        }
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
    }
    
      public static void main(String[] args) {
    CategoryDao categoryDao = new CategoryDao();

      for (Category ca : categoryDao.getAllCategory()) {
            System.out.println(ca);
        }
    }

}
