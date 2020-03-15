package part_3_fx.sample_11;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class controller {

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    public void logIn(){
        System.out.println(loginField.getText());
        System.out.println(passwordField.getText());
    }
}


