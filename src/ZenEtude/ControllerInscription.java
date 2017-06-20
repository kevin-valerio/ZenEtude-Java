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

import static ZenEtude.ControllerAccueil.showMain;
import static ZenEtude.Main.getMainStage;

/**
 *   ControllerInscription est la classe représentant le controller d' inscription.fxml
 *   @see <a href="inscription.fxml"> inscription.fxml </a>

 *
 * @author Equipe 19
 * @version 1.0
 */

public class ControllerInscription {

    @FXML  private Button btnRegister;
    @FXML  private TextField txtMail;
    @FXML  private TextField txtPassword;
    @FXML  private TextField txtRepeatPassword;
    @FXML  private DatePicker dateBirthday;
    @FXML  private CheckBox checkAgree;
    @FXML  private CheckBox checkProf;

    private static Utilisateur user = null;

    final String pattern = "yyyy-MM-dd";
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

    /**
     *
     * @param mail
     *              le mail à vérifier
     * @return si le mail est valide ou non
     */
    public  static boolean isMailValid(String mail){
        //Utilisation des REGEX pour valider l'adresse mail
        Pattern MAIL_VALID = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = MAIL_VALID .matcher(mail);
        return matcher.find();

    }

    /**
     * @return l'utilisateur
     */
    public static Utilisateur getUser() {
        return user;
    }

    @FXML
    /** ajoute au bouton sa fonctionnalité
     *  crée differentes alertes selon les cas
     *  @see Alerte
     *  crée l'utilisateur avec ses informations
     *  @see Utilisateur
     *  crée le squelette...ect
     *  @see ControllerAccueil#showMain()
     */
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
                        user.setIsProf(checkProf.isSelected());

                        showMain();

                    }

            });
    }

    /**
     *
     * @param date
     * date à convertir
     * @return la date sous forme de string
     */
     public String localDateToString(LocalDate date) {
            return dateFormatter.format(date);

    }

    /**
     *  crée le squelette de la page
     *  @see Squelette
     *  load le fxml, crée la scene avec le loadeur et l'attribue au main stage
     *  @see Main#getMainStage()
     */
    public static void showInscription(){
        Squelette squelette = new Squelette("Inscription", getMainStage());


        Parent conteneur = squelette.loadFXML("../xml_design/inscription.fxml");

        Scene scene = new Scene(conteneur, squelette.getpHeight(), squelette.getpWidth());
        getMainStage().setScene(scene);

    }

}
