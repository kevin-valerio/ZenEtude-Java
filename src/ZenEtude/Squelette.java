package ZenEtude;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

//Cette classe manipule des Stage et des Parent afin de leur définir des propriétés graphiques

public class Squelette   {
    private  int pWidth = 1660;
    private  int pHeight = 940;
    private  int pMinHeight = 820;
    private  int pMinWidth = 1460;

    private String pTitle;

    public int getpHeight(){
        return pWidth;
    }
    public int getpWidth() {
        return pHeight;
    }


    public Squelette(String titrePage, Stage leStage) {

        pTitle = "Zen'Etude - " + titrePage;

        leStage.setTitle(pTitle);
        leStage.getIcons().add(new Image("img/logo.png"));

        leStage.setMinHeight(pMinHeight);

        leStage.setMinWidth(pMinWidth);
    }

    public Parent loadFXML(String FXMLpath){
        Parent conteneur = null;
        try {
            conteneur =  FXMLLoader.load(getClass().getResource(FXMLpath));
        } catch (IOException exce) {
            exce.printStackTrace();
        }
        return conteneur;
    }
}
