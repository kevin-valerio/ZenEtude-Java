package ZenEtude;


import javafx.scene.Parent;
import javafx.scene.Scene;

import static ZenEtude.Main.getMainStage;

public class ControllerProfil {


    public static void showProfil() {
        Squelette squelette = new Squelette("Mon profil", getMainStage());

        Parent conteneur = squelette.loadFXML("../xml_design/profil.fxml");

        Scene scene = new Scene(conteneur, squelette.getpHeight(), squelette.getpWidth());
        getMainStage().setScene(scene);
    }
}
