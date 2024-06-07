package com.example.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MemberLoggedPageController {

    @FXML
    private Button ReadButton;

    @FXML
    private TableView<?> BorrowTable;

    @FXML
    private TableView<?> BooksTable;

    @FXML
    private Tab AccountTab;

    @FXML
    private Button ReturnButton;

    @FXML
    private Tab BorrowTab;

    @FXML
    private Button CheckOutRemoveButton;

    @FXML
    private TableView<?> CheckOutTable;

    @FXML
    private Tab BooksTab;

    @FXML
    private TableColumn<?, ?> listOfBooksBooks;

    @FXML
    private Button BorrowButton;

    @FXML
    private Button LogOut;

    @FXML
    private Button CheckOutButton;

    @FXML
    private Tab CheckOutTab;

}
