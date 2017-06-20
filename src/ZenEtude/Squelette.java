package ZenEtude;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Cette classe manipule des Stages et des Parents afin de leur définir des propriétés graphiques
 * @author Equipe 19
 * @version 1.0
 */

public class Squelette   {
    private  int pWidth = 1660;
    private  int pHeight = 940;
    private  int pMinHeight = 820;
    private  int pMinWidth = 1460;

    private String pTitle;

    /**
     *
     * @return la largeur de la page
     */
    int getpHeight(){
        return pWidth;
    }

    /**
     *
     * @return la hauteur de la page
     */
    int getpWidth() {
        return pHeight;
    }

    /**
     *
     * @param titrePage
     * le titre de la page
     * @param leStage
     * le stage dans lequel on souhaite créer la page
     */
    Squelette(String titrePage, Stage leStage) {

        pTitle = "Zen'Etude - " + titrePage;

        leStage.setTitle(pTitle);
        leStage.getIcons().add(new Image("img/logo.png"));

        leStage.setMinHeight(pMinHeight);

        leStage.setMinWidth(pMinWidth);
    }

    /**
     *
     * @param FXMLpath
     * le fxml a load
     * @return le conteneur, le loadeur du fxml
     * @throws IOException si erreur de lecture du fxml
     */
    Parent loadFXML(String FXMLpath){
        Parent conteneur = null;
        try {
            conteneur =  FXMLLoader.load(getClass().getResource(FXMLpath));
        } catch (IOException exce) {
            exce.printStackTrace();
        }
        return conteneur;
    }
}
