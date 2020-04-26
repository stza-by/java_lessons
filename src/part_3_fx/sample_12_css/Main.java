package part_3_fx.sample_12_css;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    Button login;

    @FXML
    Button registration;


    @FXML
    public void initialize() {
        // login.getStyleClass().addAll("custom-button");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene mainScene = new Scene(parent, 400, 400);

//        String styles = getClass().getResource("styles.css").toExternalForm();
//
//        mainScene.getStylesheets().add(styles);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
