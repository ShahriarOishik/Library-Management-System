package com.example.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.event.*;
import javafx.stage.Stage;

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
    private static Library lib;

    public static void setLibrary(Library library) {
        lib = library;
    }

    public void initialize() {
        // Set the page title
        pageTitleText.setText("Admin Login");

        // Initialize button actions
        loginButton.setOnAction(event -> handleLogin());
        backButton.setOnAction(this::handleBack);
    }

    private void handleLogin() {
        String aID = adminIdField.getText();
        String password = passwordField.getText();

        if (isInputValid(aID, password)) {
            int userIndex = Admin.loginAuthenticator(aID, password, lib.admin);
            if (userIndex != -1) {
                showInfoAlert("Login Successful", "Welcome, " + lib.admin.get(userIndex).getName() + "!");
                AdminLoggedPageController.setLibrary(lib);
                AdminLoggedPageController.setUserIndex(userIndex);

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminLoggedPage.fxml"));
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

    private void handleBack(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(newScene));
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
