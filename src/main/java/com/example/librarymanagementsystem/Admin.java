package com.example.librarymanagementsystem;
import java.io.*;
import java.util.ArrayList;

public class Admin extends User implements Serializable{
    protected String AdminID;
    public Admin(){
        super("Someone","ADMIN","EVERYWHERE","NULL","admin@admin.com");
        this.AdminID="ADMIN";
    }
    public Admin(String name,String password,String address,String phone,String email,String AdminID) {
        super(name,password,address,phone,email);
        this.AdminID=AdminID;
    }
    public String getAdminID() {
        return AdminID;
    }
    public void setAdminID(String AdminID) {
        this.AdminID = AdminID;
    }
    public void displayInfo() {
        System.out.println("Admin Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Phone: "+ phone);
    }
    public static int loginAuthenticator(String ID, String password, ArrayList<Admin> admins) {
        for (int i = 0; i < admins.size(); i++) {
            Admin admin = admins.get(i);
            if (admin.AdminID.equals(ID) && admin.password.equals(password)) {
                return i;
            }
        }
        return -1;
    }

}