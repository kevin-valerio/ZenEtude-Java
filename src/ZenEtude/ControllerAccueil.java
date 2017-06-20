package ZenEtude;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import static ZenEtude.ControllerInscription.*;
import static ZenEtude.Main.getMainStage;
import static javafx.scene.control.Alert.AlertType.*;

/**
 *   ControllerAccueil est la classe représentant le controller de accueil.fxml
 *   @see <a href="accueil.fxml"> accueil.fxml </a>

 *
 * @author Equipe 19
 * @version 1.0
 */

public class ControllerAccueil {


    @FXML
    private Hyperlink mdpOublie;
    @FXML
    private Button btnInscrire;
    @FXML
    private Button btnConnect;
    @FXML
    private TextField txtMail;
    @FXML
    private TextField txtPassword;

    @FXML
    /**
     *  ajoute a chaque bouton sa fonctionnalité
     *  @link Prompt
     *  crée differentes alertes selon les cas
     *  @see Alerte
     */
    private void initialize() {

        mdpOublie.setOnAction(event -> {
            Prompt askForMail = new Prompt(INFORMATION, true, "Veuillez rentrer votre adresse mail", "Adresse mail :", "Un mail vous sera envoyé", "prenom.nom@etu.univ-amu.fr");
            String mail = askForMail.getResponse();
            if (isMailValid(mail)) {
                Alerte mailEnvoye = new Alerte(
                        CONFIRMATION,
                        true,
                        "Un mail vous a été envoyé !",
                        "Veuillez vérifier votre boite mail",
                        "Un lien de redirection vous sera envoyé"
                );
            } else {
                Alerte errorMail = new Alerte(
                        ERROR,
                        true,
                        "L'adresse rentrée n'est pas valide",
                        "Veuillez vérifier l'adresse que vous avez rentrée",
                        null
                );
            }

        });


        btnInscrire.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            @FXML
            public void handle(ActionEvent event) {

                //Au clic du boutton "S'inscrire", on affiche la page d'inscription
                showInscription();

            }
        });

        btnConnect.setOnAction(new EventHandler<ActionEvent>() {
                                   @Override
                                   @FXML
                                   public void handle(ActionEvent event) {

                                       if (isMailValid(txtMail.getText())) {

                                           //Si l'user est enregistré
                                           try {

                                               if (getUser().isAuthorizedConnexion(txtMail.getText(), txtPassword.getText())) {

                                                   //Au clic du boutton "Se connecter" et si c'est validé, on affiche la page voir les absences/notes

                                                   ControllerAbsenceNote.showAbsenceNote();
                                               }
                                               else {
                                                   Alerte mailNonValide = new Alerte(INFORMATION, true, "Mail non valide", "Le mail rentré n'est pas valide", "Veuillez rentrer une adresse mail valide");
                                               }
                                           }
                                           catch (NullPointerException e) {
                                               Alerte connexionUnautorized = new Alerte(ERROR, true, "Compte inaccessible !", "Le mail ou le mot de passe rentré n'est pas valide", "Veuillez rentrer des identifiants valides");

                                           }
                                       }
                                   }
                               }
        );


    }

    /**
     *  crée le squelette de la page
     *  @see Squelette
     *  load le fxml, crée la scene avec le loadeur et l'attribue au main stage
     *  @see Main#getMainStage()
     */
    public static void showMain(){
        Squelette squelette = new Squelette("Accueil", getMainStage());
        Parent root = squelette.loadFXML("../xml_design/accueil.fxml");

        Scene scene = new Scene(root, squelette.getpHeight(), squelette.getpWidth());

        getMainStage().setScene(scene);
        getMainStage().show();
    }
}
