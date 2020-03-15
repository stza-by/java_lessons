/*
   Properties
 */

package part_3_fx.sample_9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main2 extends Application {

    Stage window;

    @Override
    public void start(Stage stage) {
        window = stage;

        Label outputBottom = new Label();
        Label outputTop = new Label();
        TextField input = new TextField();
        input.setMaxWidth(100);

        outputBottom.textProperty().bind(input.textProperty());

        BorderPane mainPane = new BorderPane();
        mainPane.paddingProperty().setValue(new Insets(30, 30, 30, 30));

        mainPane.setCenter(input);
        mainPane.setTop(outputTop);
        mainPane.setBottom(outputBottom);

        Scene mainScene = new Scene(mainPane, 300, 300);
        window.setScene(mainScene);
        window.setTitle("Properties");
        window.show();
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}