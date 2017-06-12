package ZenEtude;


import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import static ZenEtude.Main.getMainStage;

public class ControllerProfil {

    // BorderPane du menu (déroulant et fixe)
    @FXML private BorderPane menuList = new BorderPane();
    @FXML private BorderPane menuDeroulant = new BorderPane();
    @FXML private BorderPane menuDeconnexion;
    @FXML private BorderPane menuNoteAbsence;
    @FXML private BorderPane menuProfil;


    @FXML
    private Button btnChangeAvatar;
    @FXML
    private Button btnDeleteAvatar;

    public static void showProfil() {
        Squelette squelette = new Squelette("Mon profil", getMainStage());


        Parent conteneur = squelette.loadFXML("../xml_design/profil.fxml");

        Scene scene = new Scene(conteneur, squelette.getpHeight(), squelette.getpWidth());
        getMainStage().setScene(scene);
    }


    @FXML
    private void initialize() {

        // Gestion des events lors du click sur le menu (menuList)
        Menu menu = new Menu(menuList, menuDeroulant);
        menu.addMenuButtons(menuDeconnexion, menuNoteAbsence, menuProfil);

        menuList.setOnMouseClicked(event -> {
            menu.derouleMenu();
        });

        menu.listenForClicks();




    }

}
