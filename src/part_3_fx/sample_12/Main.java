package part_3_fx.sample_12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main  extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene mainScene = new Scene(parent, 400, 400);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
