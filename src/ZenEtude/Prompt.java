package ZenEtude;

import javafx.beans.NamedArg;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class Prompt {

    private Optional<String> result;


    public Prompt(@NamedArg("alertType") Alert.AlertType alertType, boolean show, String title, String headerText, String mainContent, String defaultValue) {

        TextInputDialog dialog = new TextInputDialog(defaultValue);
        dialog.setTitle(title);
        dialog.setHeaderText(headerText);
        dialog.setContentText(mainContent);

        result = dialog.showAndWait();
        if (!result.isPresent()){
            Alerte noMail = new Alerte(Alert.AlertType.ERROR, true, "Aucun mail !", "Aucun mail n'est détecté", "Vous n'avez rentré aucune adresse");
        }
    }




    public String getResponse(){
        return result.get();
    }
}
