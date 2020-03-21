package part_3_fx.adress_app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import part_3_fx.adress_app.model.Person;
import part_3_fx.adress_app.view.RootLayoutController;

public class Main extends Application {

    private Stage window;
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    @Override
    public void start(Stage mainStage) throws Exception {
        this.window = mainStage;

        // test data
        personData.add(new Person("Stepan", "Zaelenchyts"));
        personData.add(new Person("Stepan2", "Zaelenchyts2"));

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/RootLayout.fxml"));
        Parent rootLayout = loader.load();

        RootLayoutController rootController = loader.getController();
        rootController.setMainInstance(this);
        Scene scene = new Scene(rootLayout, 1000, 600);
        mainStage.setTitle("Адрессная книга");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public Stage getMainWindow() {
        return window;
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}