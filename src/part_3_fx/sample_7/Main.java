/*
   ChoiceBox
 */

package part_3_fx.sample_7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage stage) {
        window = stage;

        CheckBox box1 = new CheckBox("Option 1");
        CheckBox box2 = new CheckBox("Option 2");
        CheckBox box3 = new CheckBox("Option 3");
        box3.setSelected(true);

        Button btn1 = new Button("Show");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Men", "Woman");
        choiceBox.setValue("Men");

        // Grid set
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 30, 10, 30));
        grid.setVgap(10);
        grid.setHgap(5);

        grid.addRow(0, box1, box2, box3);

        grid.add(choiceBox, 1, 1);
        grid.add(btn1, 1, 2);

        btn1.setOnMouseClicked(mouseEvent -> {
            System.out.println(box1.getText() + " " + (box1.isSelected()));
            System.out.println(box1.getText() + " " + (box2.isSelected()));
            System.out.println(box1.getText() + " " + (box3.isSelected()));

            System.out.println("Dropdown menu value -" + choiceBox.getValue());
        });

        Scene mainScene = new Scene(grid, 300, 300);
        window.setScene(mainScene);
        window.setTitle("GridPane");
        window.show();
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}
/*
Задание: Добавить ы форму регистрации ChoiceBox для выбора пола и CheckBox для выбора еще одного параметра.
 */