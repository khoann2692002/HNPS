/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author Nguyen Nguyen Khoa
 */
public class UserDAO extends DBContext {

    public boolean chekcAccount(String email) {
        try {
            String sql = "SELECT * "
                    + "FROM Account "
                    + "WHERE accountEmail =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("chekcAccount error : " + e.getMessage());
        }
        return false;
    }

    public boolean checkAccount(String phone) {
        try {
            String sql = "SELECT * "
                    + "FROM Account "
                    + "WHERE accountPhone =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, phone);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkAccount error : " + e.getMessage());
        }
        return false;
    }

    public void insertNewUser(String name, String pass, String email, String phone, String address) {
        try {
            MD5 md5 = new MD5();
            String sql = "INSERT INTO ACCOUNTS(accountName, phoneNumber, email, address, password, isActive, isAdmin) VALUES(?, ?, ?, ?, ?, 0, 0)";
            PreparedStatement stm = connection.prepareStatement(sql);
            String password = pass.trim();
            stm.setString(1, name);
            stm.setString(2, phone);
            stm.setString(3, email);
            stm.setString(4, address);
            stm.setString(5, md5.getMd5(password));
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("insertNewUser error !!! " + e.getMessage());
        }
    }

    public List<User> getUserInformation() {
        List<User> t = new ArrayList<>();
        try {
            String sql = "SELECT accountId, cccd, accountName, phoneNumber, email, address FROM ACCOUNTS WHERE isAdmin = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                t.add(new User(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println("getUserById error !!!" + e.getMessage());
        }
        return t;
    }

    public void activeAccount(String email) {
        try {
            String sql = "update Account set  isActive = 1 where accountEmail = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            stm.executeUpdate();

        } catch (Exception e) {

        }
    }

    public boolean checkActive(String email) {
        try {
            String sql = "select * from Accounts where email = ? and isActive = 1 ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public User getUser(String email, String password) {
        MD5 md = new MD5();
        try {
            String sql = "SELECT email, password, rapd FROM ACCOUNTS WHERE email = ? and password = ? and isActive = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, md.getMd5(password));
            System.out.println("pass is " + md.getMd5(password));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setEmail(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setRapd(rs.getBoolean(3));
                return user;
            }
        } catch (Exception e) {
            System.out.println("getUser error !!!" + e.getMessage());
        }
        return null;
    }

    public User getInfo(String cccd) {
        try {
            String sql = "SELECT * "
                    + "FROM ACCOUNTS "
                    + "WHERE  cccd = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, cccd);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getBoolean(8), rs.getBoolean(9));
                return u;
            }
        } catch (Exception e) {
            System.out.println("getInfo error !!!" + e.getMessage());
        }
        return null;
    }

    public boolean checkAdmin(String email) {
        try {
            String sql = "SELECT * FROM ACCOUNTS WHERE cccd = ? and isAdmin = 1 ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
//        dao.insertNewUser("Thang", "123", "thang@gmail.com", "0123456789", "Ha Noi");
        boolean ok = dao.checkActive("thang@gmail.com");
        System.out.println(ok);
        User u = dao.getUser("thang@gmail.com", "123");
        System.out.println(u);

//        System.out.println(dao.getUser("khoann2692002@gmail.com", "khoann269"));
    }
}
