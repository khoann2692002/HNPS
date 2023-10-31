
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
import model.Service;

/**
 *
 * @author ASUS
 */
public class ServiceDao extends DBContext {

    public List<Service> getAllServiceByCategory(int categoryId) {

        try {
            String sql = "SELECT * "
                    + "FROM SERVICE "
                    + "WHERE status =1 and categoryId =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoryId);
            ResultSet rs = stm.executeQuery();
            List<Service> serviceList = new ArrayList<>();
            while (rs.next()) {
                Service service = new Service(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getInt(6));
                serviceList.add(service);
            }
            return serviceList;
        } catch (Exception e) {
            System.out.println("chekcAccount error : " + e.getMessage());
        }
        return null;
    }

        public List<Service> searchServiceByCategory(String categoryId, String serviceName) {

        try {
            String sql = "SELECT * "
                    + "FROM SERVICE "
                    + "WHERE status =1 and categoryId = ? and serviceName LIKE N'%" + serviceName + "%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, categoryId);
            ResultSet rs = stm.executeQuery();
            List<Service> serviceList = new ArrayList<>();
            while (rs.next()) {
                Service service = new Service(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getInt(6));
                serviceList.add(service);
            }
            return serviceList;
        } catch (Exception e) {
            System.out.println("chekcAccount error : " + e.getMessage());
        }
        return null;
    }
    
    public Service getServiceById(int id) {

        try {
            String sql = "SELECT * "
                    + "FROM SERVICE "
                    + "WHERE status =1 and serviceId =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return new Service(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println("chekcAccount error : " + e.getMessage());
        }
        return null;
    }

    public List<Service> getServiceByName(String serviceName) {
        try {
            String sql = "SELECT * "
                    + "FROM SERVICE "
                    + "WHERE status =1 and categoryId = ? and serviceName LIKE N'%" + serviceName + "%'";
            List<Service> serviceList = new ArrayList<>();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Service servic = new Service(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getInt(6));
                serviceList.add(servic);
            }
            return serviceList;
        } catch (Exception e) {
            System.out.println("chekcAccount error : " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        ServiceDao dao = new ServiceDao();

//        for (Service ca : dao.getAllServiceByCategory(2)) {
//            System.out.println(ca);
//        }
        System.out.println(dao.searchServiceByCategory(null,"d"));
    }
}
