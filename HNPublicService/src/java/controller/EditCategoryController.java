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
import javafx.beans.binding.BooleanBinding;
import model.Category;

/**
 *
 * @author ASUS
 */
public class EditCategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDao dao = new CategoryDao();
        String categoryId = request.getParameter("categoryId");
        request.setAttribute("c", dao.getCategoryById(Integer.parseInt(categoryId)));
        request.getRequestDispatcher("EditCategory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDao dao = new CategoryDao();
        String categoryId = request.getParameter("categoryId");
        String categoryName = request.getParameter("categoryName");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        dao.updateCategory(new Category(Integer.parseInt(categoryId), categoryName, description, Boolean.parseBoolean(status)));

        request.setAttribute("categoryList", dao.getAllCategoryForAdmin());
        request.getRequestDispatcher("ManageListCategory.jsp").forward(request, response);
    }

}
