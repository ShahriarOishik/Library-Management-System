package com.example.librarymanagementsystem;
import java.io.Serial;
import java.io.Serializable;

public abstract class User implements Serializable {
    protected String name;
    protected static int userId;
    protected int userID;
    protected String password;
    protected String address;
    protected String phone;
    protected String email;

    public User(){}
    public User(String name,String password,String address,String phone,String email) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.userID = userId+1;
        this.userId++;
    }

    public abstract void displayInfo();

    public boolean AuthChecker(String password, String name){
        return this.name.equals(name) && this.password.equals(password);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userID;
    }
    public void setUserId(int userId) {
        this.userID = userId;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}