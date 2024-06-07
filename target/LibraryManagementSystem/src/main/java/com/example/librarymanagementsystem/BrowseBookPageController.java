package com.example.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.event.*;
import javafx.stage.Stage;

import java.io.IOException;

public class BrowseBookPageController {

    @FXML
    private TableView<?> BookListTable;

    @FXML
    private Button BackButton;
    public void initialize() {
        BackButton.setOnAction(this::handleBack);
    }
    public void handleBack(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage stage = (Stage) BackButton.getScene().getWindow();
            stage.setScene(new Scene(newScene));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}