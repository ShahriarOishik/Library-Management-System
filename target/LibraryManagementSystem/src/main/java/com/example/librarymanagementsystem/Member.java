package com.example.librarymanagementsystem;

import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.util.Random;

public class Member extends User implements Serializable{

    private ArrayList<Book> borrowedBooks = new ArrayList<Book>();
    private ArrayList<Book> tempBorrowedBooks = new ArrayList<Book>();
    @Serial
    private static final long serialVersionUID = 1L;

    public Member(){}
    public Member(String name,String password,String address,String phone,String email) {
        super(name,password,address,phone,email);
    }

    @Override
    public void displayInfo() {
        System.out.println("Member Name: " + name);
        System.out.println("Member ID: " + userId);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Phone: "+ phone);
    }

    public void addBookToList(Book book) {
        if (book.getAvailableCopies() > 0) {
            tempBorrowedBooks.add(book);
        }
    }

    public void removeBookFromList(Book book) {
        if (tempBorrowedBooks.contains(book)) {
            tempBorrowedBooks.remove(book);
        }
    }

    public void showList() {
        for (int i = 0; i < tempBorrowedBooks.size(); i++) {
            tempBorrowedBooks.get(i).displayInfo();
        }
    }

    // public .. searchBook()
    // public .. showAvailableBooks()

    public void checkOut() {
        borrowedBooks = tempBorrowedBooks;
        for (int i = 0; i < borrowedBooks.size(); i++) {
            borrowedBooks.get(i).setAvailableCopies(borrowedBooks.get(i).getAvailableCopies() - 1);
        }
    }

    public void showBorrowedBooks() {
        for (int i = 0; i < borrowedBooks.size(); i++) {
            borrowedBooks.get(i).displayInfo();
        }
    }

    public void returnBook(Book book) {
        book.setAvailableCopies(book.getAvailableCopies() + 1);
    }
}