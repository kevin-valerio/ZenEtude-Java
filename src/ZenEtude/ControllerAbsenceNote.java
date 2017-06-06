package ZenEtude;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static ZenEtude.ControllerInscription.*;

public class ControllerAbsenceNote {
    @FXML private Label pseudoLabel;
    @FXML
    private void initialize(){

        pseudoLabel.setText(user.getMail());

    }
}