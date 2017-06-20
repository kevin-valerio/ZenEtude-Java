package ZenEtude;

import javafx.beans.NamedArg;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;
/**
 *   Prompt est la classe représentant un prompt
 *
 * @author Equipe 19
 * @version 1.0
 */

public class Prompt {

    private Optional<String> result;

    /**
     * initialise le prompt
     * @param alertType
     * le type de l'alerte (CONFIRMATION, ERROR, INFORMATION, NONE, WARNING )
     * @param show
     * dit si visible ou non
     * @param title
     * le titre
     * @param headerText
     * le header
     * @param mainContent
     * le contenu principal
     * @param defaultValue
     * la valeur par défaut
     */
    public Prompt(@NamedArg("alertType") Alert.AlertType alertType, boolean show, String title, String headerText, String mainContent, String defaultValue) {

        TextInputDialog dialog = new TextInputDialog(defaultValue);
        dialog.setTitle(title);
        dialog.setHeaderText(headerText);
        dialog.setContentText(mainContent);

        result = dialog.showAndWait();
        if (!result.isPresent()){
            Alerte noMail = new Alerte(Alert.AlertType.ERROR, true, "Aucune réponse !", "Aucune réponse n'est détectée", "Vous n'avez rentré aucune réponse");
        }
    }

    /**
     *
     * @return la réponse de l'utilisateur
     */
    public String getResponse(){

        return result.get();
    }
}
