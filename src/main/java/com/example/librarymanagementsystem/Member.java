package com.example.librarymanagementsystem;

import java.util.ArrayList;
import java.io.*;

public class Member extends User implements Serializable{
    public ArrayList<Book> borrowedBooks;
    public ArrayList<Book> CheckOutBooks;

    public Member(){}
    public Member(String name, String password, String address, String phone, String email) {
        super(name,password,address,phone,email);
        this.CheckOutBooks = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
        this.userId +=1;
    }
    public void displayInfo() {
        System.out.println("Member Name: " + name);
        System.out.println("Member ID: " + userId);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Phone: "+ phone);
    }
    public static int loginAuthenticator(String username, String password, ArrayList<Member> members) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.name.equals(username) && member.password.equals(password)) {
                return i;
            }
        }
        return -1;
    }
    public String toString() {
        return this.name + "\t\t\t" + this.password + "\t\t\t" + this.address + "\t\t\t" + this.phone + "\t\t\t" + this.email;
    }
}