package ZenEtude;

import javafx.beans.NamedArg;
import javafx.scene.control.Alert;

/**
 *   Alerte est la classe qui permettra de créer differentes alertes pour différentes situations (mdp oublié...)
 *
 * @author Equipe 19
 * @version 1.0
 */

public class Alerte extends Alert {
    /**
     *
     * @param alertType
     *                  le type de l'alerte (CONFIRMATION, ERROR, INFORMATION, NONE, WARNING )
     * @param show
     *                  booleen pour la visibilité de l'alert
     * @param title
     *                  le titre de l'alerte
     * @param headerText
     *                   le header de l'alerte
     * @param mainContent
     *                      le texte principal de l'alerte
     */
    public Alerte(@NamedArg("alertType") AlertType alertType, boolean show, String title, String headerText, String mainContent) {

        super(alertType);
        Alert alert = new Alert(alertType);
        alert.setTitle(title);

        alert.setHeaderText(headerText);
        alert.setContentText(mainContent);
        if (show) {
            alert.showAndWait();
        }
    }

}
