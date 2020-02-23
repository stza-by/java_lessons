/*
Работа с Layouts
 */

package part_3_fx.sample_4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;


    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        Button fileButton = createButton("File");
        Button editButton = createButton("Edit");
        Button viewButton = createButton("VIew");

        HBox hbox = new HBox(20, fileButton, editButton, viewButton);

        Button AButton = createButton("A");
        Button BButton = createButton("B");
        Button CButton = createButton("C");

        VBox vBox = new VBox(30, AButton, BButton, CButton);

        BorderPane bpane = new BorderPane();
        bpane.setLeft(vBox);
        bpane.setTop(hbox);

        Label label = new Label("А я в центре");
        bpane.setCenter(label);

        Scene mainScene = new Scene(bpane, 500, 500);

        window.setScene(mainScene);
        window.show();
    }

    Button createButton(String name) {
        return new Button(name);
    }


    public static void main(String[] args) {
        Main.launch(args);
    }
}

/*
Заадние: добавить VBox для Right-side и HBox для Bottom
 */
