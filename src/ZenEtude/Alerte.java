package ZenEtude;

import javafx.beans.NamedArg;
import javafx.scene.control.Alert;

public class Alerte extends Alert {

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
