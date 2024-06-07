package com.example.librarymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import java.io.IOException;

public class AlertBox {
    public static void display(String title, String Message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMaxWidth(250);
        Label label = new Label();
        label.setText(Message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e-> window.close());
        VBox layout = new VBox(30);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,250,80);
        window.setScene(scene);
        window.showAndWait();
    }
}
