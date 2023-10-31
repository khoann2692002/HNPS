/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Nguyen Khoa
 */
public class User {
    int accountID;
    int cccd;
    String accountName;
    String password;
    String email;
    String phoneNumber;
    String address;
    boolean isActive;
    boolean isAdmin;
    boolean rapd;

    public User() {
    }

    public User(int accountID, int cccd, String accountName, String password, String email, String phoneNumber, String address, boolean isActive, boolean isAdmin) {
        this.accountID = accountID;
        this.cccd = cccd;
        this.accountName = accountName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
    }

    public User(int accountID, int cccd, String accountName, String email, String phoneNumber, String address) {
        this.accountID = accountID;
        this.cccd = cccd;
        this.accountName = accountName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public User(int accountID, int cccd, String accountName, String password, String email, String phoneNumber, String address, boolean isActive, boolean isAdmin, boolean rapd) {
        this.accountID = accountID;
        this.cccd = cccd;
        this.accountName = accountName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.rapd = rapd;
    }

    
    
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getCccd() {
        return cccd;
    }

    public void setCccd(int cccd) {
        this.cccd = cccd;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isRapd() {
        return rapd;
    }

    public void setRapd(boolean rapd) {
        this.rapd = rapd;
    }

    
    @Override
    public String toString() {
        return "User{" + "accountID=" + accountID + ", cccd=" + cccd + ", accountName=" + accountName + ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", isActive=" + isActive + ", isAdmin=" + isAdmin + '}';
    }
    
}