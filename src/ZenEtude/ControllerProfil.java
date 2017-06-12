package ZenEtude;


import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static ZenEtude.ControllerInscription.getUser;
import static ZenEtude.Main.getMainStage;

public class ControllerProfil {

    // BorderPane du menu (déroulant et fixe)
    @FXML private BorderPane menuList = new BorderPane();
    @FXML private BorderPane menuDeroulant = new BorderPane();
    @FXML private BorderPane menuDeconnexion;
    @FXML private BorderPane menuNoteAbsence;
    @FXML private BorderPane menuProfil;
    @FXML
    private ImageView imageViewAvatar;

    // Bouttons pour l'avatar
    @FXML private Button btnChangeAvatar;
    @FXML private Button btnDeleteAvatar;

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

        menuList.setOnMouseClicked(event -> menu.derouleMenu());

        btnChangeAvatar.setOnAction(event -> uploadImage());

        btnDeleteAvatar.setOnAction(event -> setDefaultAvatar());

        menu.listenForClicks();


    }

    private void setDefaultAvatar() {

    }

    private void uploadImage() {
        FileChooser fileChooser = new FileChooser();

        //Extension de l'image
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichier image", "*.*");
        fileChooser.getExtensionFilters().addAll(extFilter);

        File file = fileChooser.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageViewAvatar.setImage(image);
            getUser().setAvatar(image);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
