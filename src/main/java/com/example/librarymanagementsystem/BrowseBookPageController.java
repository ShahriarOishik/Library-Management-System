package com.example.librarymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.event.*;
import javafx.stage.Stage;


public class BrowseBookPageController {

    @FXML
    private ListView<String> ListOfBooks;

    @FXML
    private Button BackButton;
    private static Library lib;

    // Populate ListOfBooks
    ObservableList<String> booksData;

    public static void setLibrary(Library library) {
        lib = library;
    }
    public void initialize() {
        BackButton.setOnAction(this::handleBack);
        booksData = FXCollections.observableArrayList();
        ListOfBooks.setItems(booksData);
        refreshBookList();

    }
    public void handleBack(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage stage = (Stage) BackButton.getScene().getWindow();
            stage.setScene(new Scene(newScene));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void refreshBookList() {
        booksData.clear();
        booksData.add("Title" + "\t\t\t" + "Author" + "\t\t\t"+ "Shelf" + "\t\t\t" + "ISBN" + "\t\t\t" + "publisher" + "\t\t\t" + "availableCopies");
        for (Book book : lib.books) {
            booksData.add(book.toString());
        }
    }
}