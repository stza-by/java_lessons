package part_3_fx.phone_book.controllers;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import part_3_fx.phone_book.PhoneBookApp;
import part_3_fx.phone_book.model.Person;
import part_3_fx.phone_book.model.PersonCollection;

public class PhoneBookController {

    private PersonCollection mainAppData = new PersonCollection();
    private PersonCollection filteredCollection = new PersonCollection();

    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, String> columnName;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private Label countLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        table.setItems(filteredCollection.getData());

        mainAppData.getData().addListener((ListChangeListener<Person>) e -> {
            updateCountLabel();
            filterData(searchTextField.getText());
        });

        searchTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filterData(newValue);
        });

        table.setOnMouseClicked(e -> {
            System.out.println("Clicked");
            if (e.getClickCount() == 2) {
                Person selectedItem = table.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    showAddEditView(selectedItem);
                }
            }
        });

        mainAppData.fillTestData();
    }

    private void filterData(String newValue) {
        filteredCollection.getData().clear();

        for (Person person : mainAppData.getData()) {
            if (person.getName().indexOf(newValue) != -1 || person.getPhone().indexOf(newValue) != -1) {
                filteredCollection.add(person);
            }
        }
    }

    private void updateCountLabel() {
        countLabel.setText("Record number: " + mainAppData.getData().size());
    }


    @FXML
    private void deleteItem() {
        Person selectedItem = table.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            System.out.println("Error");
            return;
        }

        mainAppData.delete(selectedItem);
    }

    @FXML
    public void showAbout() throws Exception {
        Stage aboutModal = new Stage();
        Parent aboutModalFxml = FXMLLoader.load(getClass().getResource("../fxml/AboutFxml.fxml"));
        aboutModal.setTitle("About");
        aboutModal.setMinHeight(400);
        aboutModal.setMinWidth(400);

        aboutModal.setResizable(false);
        aboutModal.initModality(Modality.WINDOW_MODAL);
        aboutModal.initOwner(PhoneBookApp.getMainWindow());
        aboutModal.setScene(new Scene(aboutModalFxml));
        aboutModal.showAndWait();
    }

    // add person
    // edit person

    @FXML
    public void addNewUser() throws Exception {

        Person newPerson = new Person("", "");

        boolean shouldSave = showAddEditView(newPerson);

        if (shouldSave) {
            mainAppData.add(newPerson);
        }
    }

    @FXML
    public void editUser() throws Exception {
        Person selectedItem = table.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            System.out.println("Error");
            return;
        }

        boolean isSave = showAddEditView(selectedItem);

        if (isSave) {
            System.out.println("user was changed");
        }
    }


    @FXML
    public boolean showAddEditView(Person editablePerson) {
        try {
            Stage addEditModal = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/AddEditFxml.fxml"));

            Parent aboutModalFxml = loader.load();

            AddEditController addEditController = loader.getController();
            addEditController.setPerson(editablePerson);
            addEditController.setWindow(addEditModal);

            addEditModal.setTitle("Add Edit");
            addEditModal.setMinHeight(50);
            addEditModal.setMinWidth(600);

            addEditModal.setResizable(false);
            addEditModal.initModality(Modality.WINDOW_MODAL);
            addEditModal.initOwner(PhoneBookApp.getMainWindow());
            addEditModal.setScene(new Scene(aboutModalFxml));
            addEditModal.showAndWait();
            return addEditController.getIsSave();
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }
}
