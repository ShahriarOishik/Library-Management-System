package com.example.librarymanagementsystem;
import java.io.*;

public class Admin extends User implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private String position;

    public Admin(String name,String password,String address,String phone,String email, String position) {
        super(name,password,address,phone,email);
        this.position = position;
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin Name: " + name);
        System.out.println("Admin ID: " + userId);
        System.out.println("Position: " + position);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Phone: "+ phone);
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
    }
    public void removeBook(Library library, int index) {
        library.getBooks().remove(index);
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public void addMember(Member member) {
        member.displayInfo();
    }
    //public void removeMember(Member member)
    //public .. checkPassword()

}