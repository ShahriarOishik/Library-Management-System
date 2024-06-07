package com.example.librarymanagementsystem;
import java.io.Serial;
import java.io.Serializable;
public class Book implements Serializable {
    private String title;
    private String author;
    private String isbn;
    private String bookLocation;
    private String publisher;
    private int copies;
    private int availableCopies;

    public Book(String title, String author, String isbn, String publisher, int copies,String bookLocation) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.copies = copies;
        this.availableCopies = copies;
        this.bookLocation = bookLocation;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCopies() {
        return copies;
    }
    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Publisher: " + publisher);
        System.out.println("Available Copies: " + availableCopies);
    }

    @Override
    public String toString() {
        return this.title + "\t\t\t" + this.author + "\t\t\t"+ this.bookLocation + "\t\t\t" + this.isbn + "\t\t\t" + this.publisher + "\t\t\t" + this.availableCopies;
    }

}