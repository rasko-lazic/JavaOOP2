package homeworkI.controller;

import homeworkI.application.LogEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sun.rmi.runtime.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    private TableView logTable;
    @FXML
    private TableColumn usernameCol;
    @FXML
    private TableColumn statusCol;
    @FXML
    private TableColumn timeCol;
    @FXML
    private TextField username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameCol.setCellValueFactory(new PropertyValueFactory<LogEntry, String>("username"));
        statusCol.setCellValueFactory(new PropertyValueFactory<LogEntry, String>("status"));
        timeCol.setCellValueFactory(new PropertyValueFactory<LogEntry, String>("date"));

        List<LogEntry> logData = getLogData();

        logTable.setItems(FXCollections.observableArrayList(logData));
    }

    private ArrayList<LogEntry> getLogData() {
        LogEntry log = null;
        ArrayList<LogEntry> logEntries = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream("tmp/log.ser");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            logEntries = (ArrayList<LogEntry>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return logEntries;
    }

    public void search() {
        List<LogEntry> logData = getLogData();
        logData.removeIf(element -> ! element.getUsername().equals(username.getText()));

        logTable.setItems(FXCollections.observableArrayList(logData));
    }
}
