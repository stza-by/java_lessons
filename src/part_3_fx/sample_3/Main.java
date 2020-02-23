/*
Переход между разными сценами
 */

package part_3_fx.sample_3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        Label labelScene1 = new Label("Welcome to the first scene");
        Button buttonScene1 = new Button("Go to scene 2");

        Label labelScene2 = new Label("Welcome to the second scene");
        Button buttonScene2 = new Button("Go back to first scene");

        Pane paneScene1 = new VBox(20, labelScene1, buttonScene1);
        Pane paneScene2 = new VBox(20, labelScene2, buttonScene2);

        scene1 = new Scene(paneScene1, 200, 200);
        scene2 = new Scene(paneScene2, 300, 300);

        window.setScene(scene1);

        buttonScene1.setOnMouseClicked(mouseEvent -> {
            window.setScene(scene2);
        });

        buttonScene2.setOnMouseClicked(mouseEvent -> {
            window.setScene(scene1);
        });

        window.show();
    }


    public static void main(String[] args) {
        Main.launch(args);
    }
}

/*
Задание: Добавить на вторую сцену еще одну кнопку, которая будет вести на третью сцену,
создать третью сцену с кнопокой ведущей на первую :)
 */
