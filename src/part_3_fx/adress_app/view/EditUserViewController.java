package part_3_fx.adress_app.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import part_3_fx.adress_app.model.Person;

public class EditUserViewController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField houseNumberField;


    private Stage addEditPersonStage;
    private Person person;
    private boolean saveClicked = false;


    public void setAddEditPersonStage(Stage addEditPersonStage) {
        this.addEditPersonStage = addEditPersonStage;
    }

    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        cityField.setText(person.getCity());
        streetField.setText(person.getStreet());
        houseNumberField.setText(person.getHouseNumber());
    }

    public boolean getSaveClicked() {
        return this.saveClicked;
    }

    @FXML
    private void handleSave() {

        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setCity(cityField.getText());
            person.setStreet(streetField.getText());
            person.setHouseNumber(houseNumberField.getText());

            saveClicked = true;
            addEditPersonStage.close();
        } else {
            System.out.println("Error");
        }
    }

    @FXML
    private void handleCancel() {
        addEditPersonStage.close();
    }

    private boolean isInputValid() {
        boolean answer = true;

        if (firstNameField.getText().length() == 0 || lastNameField.getText().length() == 0 ||
                cityField.getText().length() == 0 || streetField.getText().length() == 0 ||
                houseNumberField.getText().length() == 0) {
            answer = false;
        }
        return answer;
    }
}
