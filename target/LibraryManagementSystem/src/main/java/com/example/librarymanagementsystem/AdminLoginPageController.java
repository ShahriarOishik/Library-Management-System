package com.example.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginPageController {

    @FXML
    private TextField adminIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button backButton;

    @FXML
    private Text pageTitleText;

    public void initialize() {
        // Set the page title
        pageTitleText.setText("Admin Login");

        // Initialize button actions
        loginButton.setOnAction(event -> handleLogin());
        backButton.setOnAction(this::handleBack);
    }

    private void handleLogin() {
        // Add your login logic here
        System.out.println("Login button clicked!");
    }

    private void handleBack(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(newScene));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
