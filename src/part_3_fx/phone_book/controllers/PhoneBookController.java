package part_3_fx.phone_book.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import part_3_fx.phone_book.PhoneBookApp;

public class PhoneBookController {

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
}
