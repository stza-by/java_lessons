/*
   GridPane
 */

package part_3_fx.sample_6_grid;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
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

        // Name
        Label userNameLabel = new Label("Username: ");
        TextField userNameTextField = new TextField();
        userNameTextField.setPromptText("username");

        // Password
        Label passwordLabel = new Label("Password: ");
        TextField passwordTextField = new TextField();
        passwordTextField.setPromptText("password");

        // Login button
        Button loginButton = new Button("LogIn");

        // Grid set
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 30, 10, 30));
        grid.setVgap(10);
        grid.setHgap(5);

        grid.add(userNameLabel, 0, 0);
        grid.add(userNameTextField, 1, 0);

        grid.add(passwordLabel, 0, 1);
        grid.add(passwordTextField, 1, 1);

        grid.add(loginButton, 1, 3);

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
1. Добавить форму с регистрацией (Использовать еще один объект Scene). Все введеные данные
   выводить в консоль по нажатию на кнопку
 */