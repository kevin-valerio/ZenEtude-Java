package ZenEtude;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerInscription {

    @FXML  private Button btnRegister;
    @FXML  private TextField txtMail;
    @FXML  private TextField txtPassword;
    @FXML  private TextField txtRepeatPassword;
    @FXML  private DatePicker dateBirthday;
    @FXML  private CheckBox checkAgree;
    static Utilisateur user = null;

    final String pattern = "yyyy-MM-dd";
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);


    public  static boolean isMailValid(String mail){
        //Utilisation des REGEX pour valider l'adresse mail
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

                         if (!checkAgree.isSelected()) {
                            Alerte uncheckedBox = new Alerte(Alert.AlertType.INFORMATION,
                                    true, "Conditions non accéptées",
                                    "Vous n'avez pas accepté les conditions !",
                                    "Veuillez lire les conditions et les accépter par la suite.");
                             return;

                        }

                        if (!txtPassword.getText().equals(txtRepeatPassword.getText())) {
                            Alerte passwordDontMatch = new Alerte(Alert.AlertType.INFORMATION,
                                    true, "Mot de passe différents",
                                    "Vos mots de passe ne sont pas identiques.",
                                    "Veuillez réentrer vos mots de passe");
                            return;
                        }

                        if (!isMailValid(txtMail.getText())) {
                            Alerte falseMail = new Alerte(Alert.AlertType.INFORMATION,
                                    true, "Votre adresse mail n'est pas valide",
                                    "L'adresse rentrée n'est pas une bonne adresse",
                                    "Veuillez réentrer votre adresse mail");
                            return;

                        }
                        if (localDateToString(dateBirthday.getValue()).equals("")) {
                            Alerte falseMail = new Alerte(Alert.AlertType.INFORMATION,
                                    true, "Date de naissance invalide",
                                    "La date est soit vide, soit invalide",
                                    "Veuillez vérifier la date de naissance que vous avez entré.");
                            return;

                        }

                        user = new Utilisateur(txtMail.getText(), txtPassword.getText(), dateBirthday.getValue());
                        showMain();


                    }

            });
    }

    private void showMain(){
        Squelette squelette = new Squelette("Accueil", Main.mainStage);
        Parent root = squelette.loadFXML("../xml_design/accueil.fxml");

        Scene scene = new Scene(root, squelette.getpHeight(), squelette.getpWidth());

        Main.mainStage.setScene(scene);
        Main.mainStage.show();
    }
     public String localDateToString(LocalDate date) {
            return dateFormatter.format(date);

    }

}
