/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ServiceDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchServiceController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String servicename, String categoryId)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditCategoryController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servicenameis " + servicename + "</h1>");
            out.println("<h1>Servlet categoryId is " + categoryId + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                ServiceDao serviceDao = new ServiceDao();
        
          String serviceName = request.getParameter("servicename");
        String categoryId = request.getParameter("categoryId");
        request.setAttribute("serviceList", serviceDao.searchServiceByCategory(categoryId, serviceName));
        request.setAttribute("categoryId", categoryId);
        request.getRequestDispatcher("ServiceList.jsp").forward(request, response);
//        processRequest(request, response, serviceName, categoryId);
    }
    
}
