package part_3_fx.adress_app.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import part_3_fx.adress_app.Main;
import part_3_fx.adress_app.model.Person;

import java.util.Optional;

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

    private Main mainAppInstance;

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

    public void setMainInstance(Main main) {
        this.mainAppInstance = main;
        personTable.setItems(mainAppInstance.getPersonData());
    }

    private void showPersonData(Person person) {
        if (person != null) {
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            cityLabel.setText(person.getCity());
            streetLabel.setText(person.getStreet());
            houseNumberLabel.setText(person.getHouseNumber());

        } else {
            firstNameLabel.setText("-");
            lastNameLabel.setText("-");
            cityLabel.setText("-");
            streetLabel.setText("-");
            houseNumberLabel.setText("-");
        }
    }

    @FXML
    private void handleDeleteItem() {
        int index = personTable.getSelectionModel().getFocusedIndex();

        if (index < 0) {
            Alert noPersonAlert = new Alert(Alert.AlertType.ERROR);
            noPersonAlert.setTitle("Ошибка");
            noPersonAlert.setHeaderText("Ошибка удаления");
            noPersonAlert.setContentText("В таблице ничего не выбрано");

            noPersonAlert.initOwner(mainAppInstance.getMainWindow());

            noPersonAlert.showAndWait();
        } else {
            Person removingPerson = personTable.getItems().get(index);
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Удаление");
            confirmationAlert.setHeaderText("Вы уверены?");
            confirmationAlert.setContentText("Удалить" + " " + removingPerson.getFullName());

            Optional<ButtonType> result = confirmationAlert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                personTable.getItems().remove(index);
            }
        }
    }
}
