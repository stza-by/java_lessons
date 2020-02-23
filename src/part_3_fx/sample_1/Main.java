/*
Простейее Java FX приложение
 */

package part_3_fx.sample_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        Main.launch(args);
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        Pane pane = new Pane();

        Label label = new Label("Hello Java FX");
        pane.getChildren().add(label);

        Scene scene = new Scene(pane, 500, 500);

        mainStage.setTitle("Our first Java Fx application");

        mainStage.setScene(scene);
        mainStage.show();
    }
}

/*
  Задание: написать простейшее Java FX приложение
 */
