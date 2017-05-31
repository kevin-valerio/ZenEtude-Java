package ZenEtude;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class ControllerAccueil {

    @FXML
    private Button btnInscrire;

    @FXML
    private void initialize() {

     btnInscrire.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            @FXML
            public void handle(ActionEvent event) {

                //Au clic du boutton "S'inscrire", on affiche la page d'inscription
                Squelette squelette = new Squelette("Inscription", Main.primaryStage);


                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../xml_design/inscription.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Scene scene = new Scene(root, squelette.getpHeight(), squelette.getpWidth());
                Main.primaryStage.setScene(scene);
                Main.primaryStage.show();


            }
        });

    }

}
