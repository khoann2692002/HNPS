/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Nguyen Nguyen Khoa
 */
public class Captcha extends HttpServlet {

    protected void getImageCaptcha(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("img/png");
        int TotalChar = 6;
        int HeightChar = 43;
        int WidthChar = 140;
        Font fontStyle1 = new Font("Arial", Font.BOLD + Font.ITALIC + Font.LAYOUT_RIGHT_TO_LEFT, 25);
        Random randomChar = new Random();
        String ImageCode = (Long.toString(Math.abs(randomChar.nextLong()), 36)).substring(0, TotalChar);
        BufferedImage bfImage = new BufferedImage(WidthChar, HeightChar, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gr2D = (Graphics2D) bfImage.getGraphics();
        gr2D.setFont(fontStyle1);
        for (int i = 0; i < TotalChar; i++) {
            gr2D.setColor(new Color(randomChar.nextInt(255), randomChar.nextInt(255), randomChar.nextInt(255)));
            if (i % 2 == 0) {
                gr2D.drawString(ImageCode.substring(i, i + 1), 25 * i, 24);
            } else {
                gr2D.drawString(ImageCode.substring(i, i + 1), 25 * i, 30);
            }
        }
        OutputStream ot = resp.getOutputStream();
        ImageIO.write(bfImage, "png", ot);
        gr2D.dispose();
        HttpSession ss = req.getSession();
        ss.setAttribute("captcha", ImageCode);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getImageCaptcha(req, resp);
    }
}