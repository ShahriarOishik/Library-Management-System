package com.example.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class HomePageController {

    @FXML
    private Text libraryNameText;

    @FXML
    private Button browseBooksButton;

    @FXML
    private Button userLoginButton;

    @FXML
    private Button adminLoginButton;
    private static Library lib;

    public static void setLibrary(Library library) {
        lib = library;
    }
    public void setlibraryNameText(Text libraryNameText) {
        this.libraryNameText = libraryNameText;
    }
    public void initialize() {
        libraryNameText.setText(lib.name);

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
