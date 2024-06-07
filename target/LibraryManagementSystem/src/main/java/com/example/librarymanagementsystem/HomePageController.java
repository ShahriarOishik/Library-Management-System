package com.example.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import java.time.*;
import java.util.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.css.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.lang.ModuleLayer.Controller;
public class HomePageController {

    @FXML
    private Text libraryNameText;

    @FXML
    private Button browseBooksButton;

    @FXML
    private Button userLoginButton;

    @FXML
    private Button adminLoginButton;
    public void setlibraryNameText(Text libraryNameText) {
        this.libraryNameText = libraryNameText;
    }
    public void initialize() {

        // Initialize button actions
        browseBooksButton.setOnAction(this::handleBrowseBooks);
        userLoginButton.setOnAction(this::handleUserLogin);
        adminLoginButton.setOnAction(this::handleAdminLogin);
    }

    @FXML
    private void handleBrowseBooks(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BrowseBookPage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage stage = (Stage) browseBooksButton.getScene().getWindow();
            stage.setScene(new Scene(newScene));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleUserLogin(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage stage = (Stage) browseBooksButton.getScene().getWindow();
            stage.setScene(new Scene(newScene));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAdminLogin(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminLoginPage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage stage = (Stage) adminLoginButton.getScene().getWindow();
            stage.setScene(new Scene(newScene));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
