package com.example.librarymanagementsystem;
import java.util.List;
import java.util.Date;
import java.util.Random;

public abstract class User {
    protected String name;
    protected String userId;
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
        this.userId = UserIDGenerator.generateUniqueID();
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

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
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

    public boolean checkPassword(String userInputPassword, String savedPassword) {
        savedPassword = this.password;
        return savedPassword.equals(userInputPassword);
    }
}