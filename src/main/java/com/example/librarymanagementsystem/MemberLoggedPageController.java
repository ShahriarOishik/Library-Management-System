package com.example.librarymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MemberLoggedPageController {

    @FXML
    private ListView<String> BooksTable;


    @FXML
    private Button CheckOutRemoveButton;

    @FXML
    private ListView<String> CheckOutTable;

    @FXML
    private Button LogOut;

    @FXML
    private Button CheckOutButton;
    @FXML
    private Label ShowName;

    @FXML
    private Label ShowEmail;

    @FXML
    private Label ShowAddress;
    @FXML
    private Label ShowUserID;

    @FXML
    private Label ShowPhone;
    ObservableList<String> booksData;
    ObservableList<String> checkBookData;
    public static int userIndex;
    private static Library lib;

    public static void setLibrary(Library library) {
        lib = library;
    }
    public static void setUserIndex(int UserIndex) {
        userIndex = UserIndex;
    }
    @FXML
    private void initialize() {
        ShowName.setText(lib.members.get(userIndex).getName());
        ShowPhone.setText(lib.members.get(userIndex).getPhone());
        ShowAddress.setText(lib.members.get(userIndex).getAddress());
        ShowUserID.setText(Integer.toString(lib.members.get(userIndex).getUserId()));
        ShowEmail.setText(lib.members.get(userIndex).getEmail());
        LogOut.setOnAction(this::handleLogOut);
        CheckOutButton.setOnAction(this::handleCheckOut);
        CheckOutRemoveButton.setOnAction(this::handleCheckOutRemove);


        booksData = FXCollections.observableArrayList();
        BooksTable.setItems(booksData);
        checkBookData = FXCollections.observableArrayList();
        CheckOutTable.setItems(checkBookData);



        CheckOutTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        BooksTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        reloadBookList();
        reloadCheckBookList();

    }
    private void handleCheckOutRemove(ActionEvent event){
        int index = CheckOutTable.getSelectionModel().getSelectedIndex()-1;
        if (index != -1) {
            String booksTitle = lib.members.get(userIndex).CheckOutBooks.get(index).getTitle();
            String booksAuthor = lib.members.get(userIndex).CheckOutBooks.get(index).getAuthor();
            String booksISBN = lib.members.get(userIndex).CheckOutBooks.get(index).getIsbn();
            lib.RemoveCheckOutBook(booksTitle,booksAuthor,booksISBN);
            lib.members.get(userIndex).CheckOutBooks.remove(index);
            LibraryManagementSystem.setLibrary(lib);
            reloadCheckBookList();
            reloadBookList();

        }
    }
    private void handleLogOut(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage stage = (Stage) LogOut.getScene().getWindow();
            stage.setScene(new Scene(newScene));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private void handleCheckOut(ActionEvent event){
        int index = BooksTable.getSelectionModel().getSelectedIndex()-1;
        if (index != -1) {
            String booksISBN = lib.books.get(index).getIsbn();
            // Check if the book is available
            if (lib.books.get(index).getAvailableCopies() > 0) {
                lib.CheckOutBook(booksISBN);
                Book book = new Book(lib.books.get(index).getTitle(),lib.books.get(index).getAuthor(),lib.books.get(index).getIsbn(),lib.books.get(index).getPublisher(),1,null);
                lib.members.get(userIndex).CheckOutBooks.add(book);
                LibraryManagementSystem.setLibrary(lib);
                reloadCheckBookList();
                reloadBookList();
            } else {
                // Notify the user that the book is not available for checkout
                System.out.println("Sorry, this book is not available for checkout.");
            }
        }
    }
    private void reloadBookList() {
        booksData.clear();
        booksData.add("Title" + "\t\t\t" + "Author" + "\t\t\t"+ "Shelf" + "\t\t\t" + "ISBN" + "\t\t\t" + "publisher" + "\t\t\t" + "availableCopies");
        for (Book book : lib.books) {
            booksData.add(book.toString());
        }
    }
    private void reloadCheckBookList() {
        try {
            checkBookData.clear();
            checkBookData.add("Title" + "\t\t\t" + "Author" + "\t\t\t"+ "Shelf" + "\t\t\t" + "ISBN" + "\t\t\t" + "publisher" + "\t\t\t" + "availableCopies");
            for (Book book : lib.members.get(userIndex).CheckOutBooks) {
                checkBookData.add(book.toString());
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }


}
