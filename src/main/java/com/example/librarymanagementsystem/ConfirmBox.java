package com.example.librarymanagementsystem;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean answer=false;

    public static boolean display(String title, String Message) {
        Stage ConfirmBox = new Stage();
        ConfirmBox.initModality(Modality.APPLICATION_MODAL);
        ConfirmBox.setTitle(title);
        ConfirmBox.setMinWidth(250);
        ConfirmBox.setMaxWidth(250);
        Label label = new Label();
        label.setText(Message);
        // button
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setOnAction(e -> {
            answer = true;
            ConfirmBox.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            ConfirmBox.close();
        });
        VBox layout = new VBox(30);
        layout.getChildren().addAll(label, yesButton,noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 250, 170);
        ConfirmBox.setScene(scene);
        ConfirmBox.showAndWait();
        return answer;
    }
}
