/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Service {

    int serviceId;
    String serviceName;
    String description;
    String hourlyRate;
    boolean status;
    int categoryId;

    public Service() {
    }

    public Service(int serviceId, String serviceName, String description, String hourlyRate, boolean status, int categoryId) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.hourlyRate = hourlyRate;
        this.status = status;
        this.categoryId = categoryId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Service{" + "serviceId=" + serviceId + ", serviceName=" + serviceName + ", description=" + description + ", hourlyRate=" + hourlyRate + ", status=" + status + ", categoryId=" + categoryId + '}';
    }

}
