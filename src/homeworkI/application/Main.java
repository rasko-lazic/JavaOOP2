package homeworkI.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        Auth.initUsers();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Login Application");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../resources/noon_icon.png")));

        Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

