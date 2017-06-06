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
import static javafx.scene.control.Alert.AlertType.*;
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
    private void initialize() {

        mdpOublie.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Prompt askForMail = new Prompt(INFORMATION, true, "Veuillez rentrer votre adresse mail","Adresse mail :","Un mail vous sera envoyé", "prenom.nom@etu.univ-amu.fr");
                String mail = askForMail.getResponse();
                if(isMailValid(mail)){
                    Alerte mailEnvoye = new Alerte(
                            CONFIRMATION,
                            true,
                            "Un mail vous a été envoyé !",
                            "Veuillez vérifier votre boite mail",
                            "Un lien de redirection vous sera envoyé"
                    );
                }
                else{
                    Alerte errorMail = new Alerte(
                            ERROR,
                            true,
                            "L'adresse rentrée n'est pas valide",
                            "Veuillez vérifier l'adresse que vous avez rentrée",
                            null
                    );
                }

            }

        });


     btnInscrire.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            @FXML
            public void handle(ActionEvent event) {

                //Au clic du boutton "S'inscrire", on affiche la page d'inscription
                Squelette squelette = new Squelette("Inscription", Main.mainStage);


                Parent conteneur = squelette.loadFXML("../xml_design/inscription.fxml");

                Scene scene = new Scene(conteneur, squelette.getpHeight(), squelette.getpWidth());
                Main.mainStage.setScene(scene);


            }
        });

     btnConnect.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         @FXML
         public void handle(ActionEvent event) {

             if (isMailValid(txtMail.getText())) {

                 /*
                    Todo :  Créer une fonction qui gère le match des logs

                  */
                 if (user.getPassword().equals(txtPassword.getText()) && user.getMail().equals(txtMail.getText())) {

                     //Au clic du boutton "Se connecter" et si c'est validé, on affiche la page voir les absences/notes
                     Squelette squelette = new Squelette("Notes et absences", Main.mainStage);

                     Parent conteneur = squelette.loadFXML("../xml_design/viewAbsenceNote.fxml");

                     Scene scene = new Scene(conteneur, squelette.getpHeight(), squelette.getpWidth());
                     Main.mainStage.setScene(scene);
                 }
                 else{
                     // Todo : gérer si log pas bon
                 }
             }

             else{
                 Alerte mailNonValide = new Alerte(INFORMATION, true, "Mail non valide", "Le mail rentré n'est pas valide", "Veuillez rentrer une adresse mail valide");
             }
         }

     });



    }

}
