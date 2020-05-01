package part_3_fx.adress_app.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import part_3_fx.adress_app.Main;
import part_3_fx.adress_app.Model.Person;

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

    @FXML
    private void handleDeleteItem() {

        int index = personTable.getSelectionModel().getFocusedIndex();

        if (index < 0) {
            // обработать ошибку

            Alert noPersonAlert = new Alert(Alert.AlertType.ERROR);
            noPersonAlert.setTitle("Ошибка удаления");
            noPersonAlert.setHeaderText("Ошибка удаления");
            noPersonAlert.setContentText("Таблица пуста");

            noPersonAlert.initOwner(mainApp.getWindow());
            noPersonAlert.showAndWait();
        } else {
            Person removingPerson = personTable.getItems().get(index);
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setTitle("Подтверждение");
            confirmAlert.setHeaderText("Вы уверены?");
            confirmAlert.setContentText("Удалить " + removingPerson.getFullName() + "?");

            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                personTable.getItems().remove(index);
            }
        }
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
    
    @FXML
    private void addUser() throws Exception {
        Person tempPerson = new Person();
        boolean shouldSave =  showPersonAddEditWindow(tempPerson, false);

        if(shouldSave) {
            personTable.getItems().add(tempPerson);
            showPersonData(tempPerson);
        }
    }

    @FXML
    private void editUser() throws Exception {
        int index = personTable.getSelectionModel().getFocusedIndex();

        if(index < 0) {
            System.out.println("Error");
        } else {
            Person editablePerson = personTable.getItems().get(index);
            boolean shouldSave = showPersonAddEditWindow(editablePerson, true);
            if(shouldSave) {
                showPersonData(editablePerson);
            }
        }
    }

    @FXML
    private boolean showPersonAddEditWindow(Person person, boolean isEdit) throws Exception {
        // загружаем fxml файл
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddEditView.fxml"));
        Parent addEditView = loader.load();

        // создаем сцену
        Scene addEditScene = new Scene(addEditView, 400, 400);

        // создаем новое окно
        Stage addEditStage = new Stage();
        addEditStage.setScene(addEditScene);

        addEditStage.initModality(Modality.WINDOW_MODAL);
        addEditStage.initOwner(this.mainApp.getWindow());

        if(isEdit){
            addEditStage.setTitle("Редактирование пользователя");
        } else{
            addEditStage.setTitle("Добавление нового пользователя");
        }

        addEditStage.getIcons().add(new Image("file:resources/images/icon.png"));

        AddEditViewController addEditController = loader.getController();
        addEditController.setPerson(person);
        addEditController.setAddEditStage(addEditStage);

        addEditStage.showAndWait();

        return addEditController.getSaveClicked();
    }
}
