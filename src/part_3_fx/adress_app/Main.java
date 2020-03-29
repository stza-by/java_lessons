package part_3_fx.adress_app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import part_3_fx.adress_app.model.Person;
import part_3_fx.adress_app.view.RootLayoutController;

public class Main extends Application {

    private Stage window;
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    @Override
    public void start(Stage mainStage) throws Exception {
        addTestData();

        this.window = mainStage;

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


    void addTestData(){
        // test data
        personData.add(new Person("Иван", "Иванов"));
        personData.add(new Person("Леха", "Ро", "Брест", "Гоголя", "10"));
        personData.add(new Person("Степан", "Степанович", "Брест", "Гоголя", "11"));
    }
}

