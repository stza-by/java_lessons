package part_3_fx.adress_app.view;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import part_3_fx.adress_app.Model.Person;

public class AddEditViewController {

    @FXML
    TextField firstName;

    @FXML
    TextField lastName;

    @FXML
    TextField city;

    @FXML
    TextField street;

    @FXML
    TextField houseNumber;

    private Person person;
    private Stage addEditStage;
    private boolean saveClicked = false;


    public boolean getSaveClicked(){
        return saveClicked;
    }

    public void setAddEditStage(Stage addEdit) {
        this.addEditStage = addEdit;
    }

    public void setPerson(Person person) {
        this.person = person;

        firstName.setText(person.getFirstName());
        lastName.setText(person.getLastName());
        city.setText(person.getCity());
        street.setText(person.getStreet());
        houseNumber.setText(person.getHouseNumber());
    }

    @FXML
    private void handleCancel(){
        addEditStage.close();
    }

    @FXML
    private void handleSave() {
        if (isInputValid()){
            person.setFirstName(firstName.getText());
            person.setLastName(lastName.getText());
            person.setCity(city.getText());
            person.setStreet(street.getText());
            person.setHouseNumber(houseNumber.getText());
            // ...

            saveClicked = true;
            addEditStage.close();
        } else {
            System.out.println("Error");
        }
    }

    private boolean isInputValid() {
        boolean result = true;

        if (firstName.getText().length() == 0 || lastName.getText().length() == 0  ||
                city.getText().length() == 0 || street.getText().length() == 0 ||
                houseNumber.getText().length() == 0){
            result = false;
        }

        return result;
    }
}
