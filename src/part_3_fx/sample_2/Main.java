/*
Обработка событий в Java FX
 */

package part_3_fx.sample_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Java FX приложение");
        Pane rootPane = new Pane();
        Scene scene = new Scene(rootPane, 300, 300);

        Button button = new Button("Click me");
        button.setTranslateX(100);
        button.setTranslateY(100);
        button.setPrefSize(70, 20);

        button.setOnMouseClicked(mouseEvent -> {
            button.setText("Clicked");
            System.out.println("The button has been clicked");
        });

        rootPane.getChildren().add(button);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}

/*
 Задание: сделать так, что бы после повторного нажатия кнопке возвращалось предыдущее название
 */