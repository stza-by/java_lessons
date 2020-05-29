package part_3_fx.phone_book.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import part_3_fx.phone_book.model.Person;

public class AddEditController {

    private Person person;
    private Stage window;
    private boolean isSave = false;

    @FXML
    private TextField userNameInput;

    @FXML
    private TextField phoneInput;

    public void setPerson(Person person) {
        this.person = person;

        userNameInput.setText(person.getName());
        phoneInput.setText(person.getPhone());

    }

    public void setWindow(Stage window){
        this.window = window;
    }

    public boolean getIsSave() {
        return isSave;
    }


    @FXML
    public void onSave() {
        String name = userNameInput.getText();
        String phone = phoneInput.getText();

        if (name.length() == 0 || phone.length() == 0) {
            System.out.println("Invalid input");
            return;
        }

        this.person.setName(name);
        this.person.setPhone(phone);

        this.isSave = true;

        this.window.close();
    }

    @FXML
    public void onCancel() {

        this.window.close();
    }


}
