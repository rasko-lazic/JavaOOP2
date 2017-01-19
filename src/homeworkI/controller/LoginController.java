package homeworkI.controller;

import homeworkI.application.Auth;
import homeworkI.application.LogEntry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{
    @FXML
    private TextField name;
    @FXML
    private PasswordField password;

    public void loginAttempt(ActionEvent event) {
        if(Auth.authenticateUser(name.getText(), password.getText())) {
            this.authSuccess();
        } else {
            this.authFail();
        }
    }

    private void authFail() {
        LogEntry log = new LogEntry(name.getText(), "Fail");
        log.persist();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login error");
        alert.setHeaderText(null);
        alert.setContentText(Auth.getErrorMessage());

        alert.showAndWait();
    }

    private void authSuccess() {
        LogEntry log = new LogEntry(name.getText(), "Success");
        log.persist();

        Stage primaryStage = (Stage) name.getScene().getWindow();

        try {
            Parent forward = FXMLLoader.load(getClass().getResource("../view/App.fxml"));
            Scene scene = new Scene(forward);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
