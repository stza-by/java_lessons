package part_3_fx.adress_app.View;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import part_3_fx.adress_app.Main;
import part_3_fx.adress_app.Model.Person;

public class RootLayoutController {

    @FXML
    private TableView<Person> personTable;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label houseNumberLabel;

    Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        personTable.setItems(mainApp.getPersonData());
    }

    @FXML
    private void initialize() {

        firstNameColumn.setCellValueFactory(cellData -> {
            return cellData.getValue().firstNameProperty();
        });

        lastNameColumn.setCellValueFactory(cellData -> {
            return cellData.getValue().lastNameProperty();
        });

        showPersonData(null);

        personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            showPersonData(newValue);
        });
    }

    private void showPersonData(Person person) {
        if (person != null) {
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            cityLabel.setText(person.getCity());
            streetLabel.setText(person.getStreet());
            houseNumberLabel.setText(person.getHouseNumber());
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            cityLabel.setText("");
            streetLabel.setText("");
            houseNumberLabel.setText("");
        }
    }


}
