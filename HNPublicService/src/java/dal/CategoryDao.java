/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author ASUS
 */
public class CategoryDao extends DBContext {

    public List<Category> getAllCategory() {
        try {
            String sql = "SELECT * "
                    + "FROM CATEGORY "
                    + "WHERE status =1";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            List<Category> categoryList = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5));
                categoryList.add(category);
            }
            return categoryList;
        } catch (Exception e) {
            System.out.println("chekcAccount error : " + e.getMessage());
        }
        return null;
    }

    public List<Category> getAllCategoryForAdmin() {

        try {
            String sql = "SELECT * "
                    + "FROM CATEGORY";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            List<Category> categoryList = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5));
                categoryList.add(category);
            }
            return categoryList;
        } catch (Exception e) {
            System.out.println("chekcAccount error : " + e.getMessage());
        }
        return null;
    }

    public Category getCategoryById(int categoyId) {
        try {
            String sql = "SELECT * "
                    + "FROM CATEGORY "
                    + "WHERE categoryId =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoyId);
            ResultSet rs = stm.executeQuery();
            List<Category> categoryList = new ArrayList<>();
            if (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5));
            }
        } catch (Exception e) {
            System.out.println("chekcAccount error : " + e.getMessage());
        }
        return null;
    }

    public boolean updateCategory(Category category) {
        try {
            String sql = "update CATEGORY set categoryName = ? , description = ? , status =? where categoryId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, category.getCategoryName());
            stm.setString(2, category.getDescription());
            stm.setBoolean(3, category.isStatus());
            stm.setInt(4, category.getCategoryId());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("chekcAccount error : " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        CategoryDao dao = new CategoryDao();

//        for (Category ca : dao.getAllCategory()) {
//            System.out.println(ca);
//        }
        Category c = new Category(1, "Học tập", "Cung c?p thông tin th? t?c hành chính, d?ch v? công tr?c tuy?n liên quan d?n vi?c h?c t?p c?a cá nhân t? m?m non d?n sau d?i h?c.", true);
        System.out.println(dao.updateCategory(c));
    }
}
