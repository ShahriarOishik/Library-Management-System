package com.example.librarymanagementsystem;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import javafx.event.*;

public class LoginPageController{
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;
    @FXML
    private Button backButton;

    @FXML
    private Button RegButton;

    @FXML
    private void initialize() {
        loginButton.setOnAction(this::handleLoginButton);
        RegButton.setOnAction(this::handleRegButton);
        backButton.setOnAction(this::handleBackButton);
    }

    private void handleLoginButton(ActionEvent event) {
        // Your login logic here
        System.out.println("Login button clicked!");
    }
    private void handleBackButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(newScene));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void handleRegButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegPage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage RegBox = new Stage();
            RegBox.initModality(Modality.APPLICATION_MODAL);
            RegBox.setTitle("Registration");
            RegBox.setMinWidth(250);  // Set minimum width
            RegBox.setMaxWidth(250);
            RegBox.setMinHeight(400);
            RegBox.setMaxHeight(400);
            RegBox.setScene(new Scene(newScene));
            RegBox.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}