/*
Практика
 */

package part_3_fx.sample_5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        Label lA = new Label("A");
        Label lB = new Label("B");
        Label lC = new Label("C");

        TextField valueA = new TextField();
        TextField valueB = new TextField();
        TextField valueC = new TextField();

        HBox layout1 = new HBox(10);
        layout1.getChildren().addAll(lA, valueA, lB, valueB, lC, valueC);

        Button btn = new Button("Посчитать");
        Label result = new Label("Результат");

        HBox layout2 = new HBox(30);
        layout2.getChildren().addAll(btn, result);

        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20, 20, 20, 20));
        mainLayout.getChildren().addAll(layout1, layout2);

        Scene mainScene = new Scene(mainLayout, 500, 300);
        window.setScene(mainScene);
        window.setTitle("Решение квадратного уравнения");
        window.show();
    }


    public static void main(String[] args) {
        Main.launch(args);
    }
}

/*
Закончить программу, добавив вычисление корней
 */