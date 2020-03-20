
package part_3_fx.adress_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private Stage window;

    @Override
    public void start(Stage mainStage) throws Exception {
        this.window = mainStage;

        Parent rootLayout = FXMLLoader.load(getClass().getResource("RootLayout.fxml"));
        Scene scene = new Scene(rootLayout, 500, 500);
        mainStage.setTitle("Адрессная книга");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) { Main.launch(args); }
}
