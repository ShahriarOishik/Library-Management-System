package com.example.librarymanagementsystem;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private LocalDate publicationDate;
    private String directory;
    private int copies;
    private int availableCopies;

    public Book(String title, String author, String isbn, String publisher, LocalDate publicationDate, String directory, int copies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.directory = directory;
        this.copies = copies;
        this.availableCopies = copies;
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

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDirectory() {
        return directory;
    }
    public void setDirectory(String directory) {
        this.directory = directory;
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

}

/*ArrayList<Book> bookList = new ArrayList<>();
        // Add some books to the list...

        // Convert ArrayList to ObservableList
        ObservableList<Book> observableBookList = FXCollections.observableArrayList(bookList);

        // Create TableView
        TableView<Book> tableView = new TableView<>(observableBookList);

        // Define columns
        TableColumn<Book, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        // Add columns to TableView
        tableView.getColumns().addAll(titleColumn, authorColumn);

        // Set up the stage
        Scene scene = new Scene(tableView);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Catalog");
        primaryStage.show();*/