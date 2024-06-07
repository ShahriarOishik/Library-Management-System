package com.example.librarymanagementsystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.*;
import javafx.stage.Stage;

public class RegPageController {



        @FXML
        private PasswordField RegPasswordField;

        @FXML
        private Button SignUpButton;

        @FXML
        private TextField AddressTextField;

        @FXML
        private Button CancelButton;

        @FXML
        private TextField PhoneTextField;

        @FXML
        private TextField usernameTextField;

        @FXML
        private TextField EmailTextField;

    public void initialize() {

        // Initialize button actions
        CancelButton.setOnAction(this::handleCancel);
        SignUpButton.setOnAction(this::handleSignUp);
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleSignUp(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = RegPasswordField.getText();
        String address = AddressTextField.getText();
        String phone = PhoneTextField.getText();
        String email = EmailTextField.getText();

        if (isInputValid(username, password, address, phone, email)) {
            boolean check= ConfirmBox.display("Confirmation","Do you want to proceed?");
            if (check) {
                LibraryManagementSystem.signUp(username, password, address, phone, email);
                Stage stage = (Stage) SignUpButton.getScene().getWindow();
                stage.close();
            }
        } else {
            showErrorAlert("Validation Error", "Please fill in all fields.");
        }
    }
    private boolean isInputValid(String username, String password, String address, String phone, String email) {
        return username != null && !username.isEmpty()
                && password != null && !password.isEmpty()
                && address != null && !address.isEmpty()
                && phone != null && !phone.isEmpty()
                && email != null && !email.isEmpty();
    }
    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
