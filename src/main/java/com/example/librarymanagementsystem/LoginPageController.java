package com.example.librarymanagementsystem;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    private static Library lib;

    public static void setLibrary(Library library) {
        lib = library;
    }
    @FXML
    private void initialize() {
        loginButton.setOnAction(this::handleLoginButton);
        RegButton.setOnAction(this::handleRegButton);
        backButton.setOnAction(this::handleBackButton);
    }

    private void handleLoginButton(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (isInputValid(username, password)) {
            int userIndex = Member.loginAuthenticator(username, password, lib.members);
            if (userIndex != -1) {
                showInfoAlert("Login Successful", "Welcome, " + lib.members.get(userIndex).getName() + "!");
                MemberLoggedPageController.setUserIndex(userIndex);
                MemberLoggedPageController.setLibrary(lib);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MemberLoggedPage.fxml"));
                    Parent newScene = fxmlLoader.load();
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.setScene(new Scene(newScene));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else {
                showErrorAlert("Login Failed", "Invalid username or password.");
            }
        } else {
            showErrorAlert("Validation Error", "Please fill in all fields.");
        }
    }
    private void handleBackButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(newScene));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void handleRegButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegPage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage RegBox = new Stage();
            RegBox.initModality(Modality.APPLICATION_MODAL);
            RegBox.setTitle("Registration");
            RegBox.setScene(new Scene(newScene));
            RegBox.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private boolean isInputValid(String username, String password) {
        return username != null && !username.isEmpty()
                && password != null && !password.isEmpty();
    }
    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void showInfoAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}