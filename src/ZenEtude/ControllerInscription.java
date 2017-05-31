package ZenEtude;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerInscription {

    @FXML  private Button btnRegister;
    @FXML  private TextField txtMail;
    @FXML  private TextField txtPassword;
    @FXML  private TextField txtRepeatPassword;
    @FXML  private DatePicker dateBirthday;
    @FXML  private CheckBox checkAgree;


    private boolean isMailValid(String mail){
        Pattern MAIL_VALID = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = MAIL_VALID .matcher(mail);
        return matcher.find();
    }

    @FXML
    private void initialize() {

            btnRegister.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                @FXML

                //Vérification des champs d'inscription
                public void handle(ActionEvent event) {
                    if(!checkAgree.isSelected()){
                        Alerte uncheckedBox = new Alerte(Alert.AlertType.INFORMATION,
                                true, "Conditions non accéptées",
                                "Vous n'avez pas accepté les conditions !",
                                "Veuillez lire les conditions et les accépter par la suite.");
                    }

                    if(txtPassword.getText() != txtRepeatPassword.getText()){
                        Alerte passwordDontMatch = new Alerte(Alert.AlertType.INFORMATION,
                                true, "Mot de passe différents",
                                "Vos mots de passe ne sont pas identiques.",
                                "Veuillez réentrer vos mots de passe");

                    }

                    if(!isMailValid(txtMail.getText())){
                        Alerte falseMail = new Alerte(Alert.AlertType.INFORMATION,
                                true, "Votre adresse mail n'est pas valide",
                                "L'adresse rentrée n'est pas une bonne adresse",
                                "Veuillez réentrer votre adresse mail");

                    }

                    if(dateBirthday.getValue().toString() == null){
                        Alerte falseMail = new Alerte(Alert.AlertType.INFORMATION,
                                true, "Date de naissance invalide",
                                "La date est soit vide, soit invalide",
                                "Veuillez vérifier la date de naissance que vous avez entré.");

                    }
                }
            });
    }

}
