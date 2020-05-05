package part_3_fx.phone_book;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PhoneBookApp extends Application {

    private static Stage window;

    public static Stage getMainWindow() {
        return window;
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        Parent phoneBookFXML = FXMLLoader.load(getClass().getResource("fxml/PhoneBookFxml.fxml"));

        // Минимальный размер окна
        window.setMinWidth(400);
        window.setMinHeight(600);

        // максимальный размер окна
        window.setMaxWidth(600);
        window.setMaxHeight(800);

        window.setTitle("Phone Book");

        window.setScene(new Scene(phoneBookFXML));
        window.show();
    }
}
