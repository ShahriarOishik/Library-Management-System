package com.example.librarymanagementsystem;
import java.util.ArrayList;

public class Library {
    public String name;
    public ArrayList<Book> books;
    public ArrayList<Member> members;
    public ArrayList<Admin> admin;

    public Library(String name, ArrayList<Book> BookDB, ArrayList<Member> MemberDB, ArrayList<Admin> AdminDB) {
        this.name = name;
        this.books = BookDB;
        this.members = MemberDB;
        this.admin = AdminDB;
    }

    // Getter for books
    public ArrayList<Book> getBooks() {
        return books;
    }

    // Setter for books
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    // Getter for members
    public ArrayList<Member> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    // Setter for members
    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    // Getter for admin
    public ArrayList<Admin> getAdmin() {
        return admin;
    }

    // Setter for admin
    public void setAdmin(ArrayList<Admin> admin) {
        this.admin = admin;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        for (int i = 0; i < this.books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equals(title)) {
                books.remove(i);
                break;
            }
        }
    }
    public void removeUser(String name) {
        for (int i = 0; i < this.members.size(); i++) {
            Member member = members.get(i);
            if (member.getName().equals(name) ) {
                members.remove(i);
                break;
            }
        }
    }
    public void CheckOutBook(String isbn) {
        for (int i = 0; i < this.books.size(); i++) {
            Book book = books.get(i);
            if (book.getIsbn().equals(isbn) && book.getAvailableCopies()>0) {
                book.setAvailableCopies(book.getAvailableCopies()-1);
                break;
            }
        }
    }
    public void RemoveCheckOutBook(String title,String author,String isbn) {
        for (int i = 0; i < this.books.size(); i++) {
            Book book = books.get(i);
            if (book.getIsbn().equals(isbn) && book.getTitle().equals(title)&& book.getAuthor().equals(author)) {
                book.setAvailableCopies(book.getAvailableCopies()+1);
                break;
            }
        }
    }
}