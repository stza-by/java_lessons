
package part_3_fx.adress_app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import part_3_fx.adress_app.Model.Person;
import part_3_fx.adress_app.View.RootLayoutController;


public class Main extends Application {

    private Stage window;
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    @Override
    public void start(Stage mainStage) throws Exception {

        window = mainStage;
        createTestData();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/RootLayout.fxml"));
        Parent rootLayout = loader.load();
        RootLayoutController layoutController = loader.getController();
        layoutController.setMainApp(this);

        Scene scene = new Scene(rootLayout, 1000, 600);
        mainStage.setTitle("Адрессная книга");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public ObservableList<Person> getPersonData(){
        return personData;
    }

    public Stage getWindow(){
        return window;
    }

    public void createTestData(){
        Person person1 = new Person("Иван", "Иванов");
        Person person2 = new Person("Джо", "Джонсон", "Брест", "Гоголя", "11");
        personData.add(person1);
        personData.add(person2);
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}
