/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.MD5;
import dal.UserDAO;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author pc
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("LoginEnterprise.jsp").forward(req, resp);
    }
    private UserDAO dao = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String captcha = (String) req.getSession().getAttribute("captcha");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String checkCaptcha = req.getParameter("captcha");

        req.setAttribute("email", email);
        req.setAttribute("pass", pass);
        User user = dao.getUser(email, pass);
        System.out.println("pass controller la " + user.getPassword());
        User user2 = dao.getInfo(email);
        boolean OK = dao.checkActive(email);
        boolean admin = dao.checkAdmin(email);
        if (OK) {
            if (captcha.equals(checkCaptcha)) {
                if (user != null || user2 != null) {
                    req.getSession().setAttribute("user", user);
                    req.getSession().setAttribute("user2", user2);
                    if (user.isRapd() == true) {
                        resp.sendRedirect("./manage");
                    } else {
                        resp.sendRedirect("./home");
                    }
                } else {
                    req.setAttribute("mess", "Wrong email or password !!!");
                    req.getRequestDispatcher("LoginEnterprise.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("mess", "Invalid Captcha !!!");
                req.getRequestDispatcher("LoginEnterprise.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("mess", "Account is not active !!!");
            req.getRequestDispatcher("LoginEnterprise.jsp").forward(req, resp);
        }
    }
}
