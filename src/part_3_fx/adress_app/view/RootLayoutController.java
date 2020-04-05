package part_3_fx.adress_app.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
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

    @FXML
    private void addUser() throws Exception {
        Person tempPerson = new Person();
        boolean shouldSave = showPersonAddEditDialog(tempPerson);

        if (shouldSave) {
            // mainAppInstance.getPersonData().add(tempPerson);
            personTable.getItems().add(tempPerson);
            showPersonData(tempPerson);
        }
    }

    @FXML
    private void editUser() throws Exception {
        int index = personTable.getSelectionModel().getFocusedIndex();
        if (index < 0) {
            System.out.println("Error");
        } else {
            Person editablePerson = personTable.getItems().get(index);
            boolean shouldSave = showPersonAddEditDialog(editablePerson);

            if (shouldSave) {
                showPersonData(editablePerson);
            }
        }
    }

    private boolean showPersonAddEditDialog(Person person) throws Exception {
        // загружаем fxml файл
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditUserView.fxml"));
        Parent editView = loader.load();

        // создаем сцену
        Scene editScene = new Scene(editView, 500, 300);

        // создаем окно и утсанавливаем в него сцену
        Stage editPersonStage = new Stage();
        editPersonStage.setScene(editScene);

        // делаем окно модальным и привязываем его к главному окну приложения
        editPersonStage.initModality(Modality.WINDOW_MODAL);
        editPersonStage.initOwner(this.mainAppInstance.getMainWindow());

        // Получаем контроллер модального окна редактирования
        EditUserViewController editUserViewController = loader.getController();
        editUserViewController.setAddEditPersonStage(editPersonStage);

        editPersonStage.setTitle("Редактирование пользователя");
        editUserViewController.setPerson(person);

        editPersonStage.showAndWait();

        return editUserViewController.getSaveClicked();
    }
}
