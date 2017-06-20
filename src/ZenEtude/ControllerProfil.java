package ZenEtude;


import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static ZenEtude.ControllerAbsenceNote.showAbsenceNote;
import static ZenEtude.ControllerInscription.getUser;
import static ZenEtude.Main.getMainStage;
import static javafx.collections.FXCollections.observableArrayList;

/**
 * ControllerProfil est la classe représentant le controller de profil.fxml
 * *   @see <a href="prfoil.fxml"> profil.fxml </a>
 *
 * @author Equipe 19
 * @version 1.0
 */

public class ControllerProfil {

    // BorderPane du menu (déroulant et fixe)
    @FXML
    private BorderPane menuList = new BorderPane();
    @FXML
    private BorderPane menuDeroulant = new BorderPane();
    @FXML
    private BorderPane menuDeconnexion;
    @FXML
    private BorderPane menuNoteAbsence;
    @FXML
    private BorderPane menuProfil;
    @FXML
    private ImageView imageViewAvatar;


    @FXML
    private ChoiceBox choiceSGroupe;
    @FXML
    private ChoiceBox choiceGroupe;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtDomaine;
    @FXML
    private TextField txtEtablissement;


    // Bouttons pour l'avatar
    @FXML
    private Button btnChangeAvatar;
    @FXML
    private Button btnDeleteAvatar;
    @FXML
    private Button btnRegister;

    /**
     * crée le squelette de la page     *
     * @see Squelette
     * load le fxml, crée la scene avec le loadeur et l'attribue au main stage
     * @see Main#getMainStage()
     */
    public static void showProfil() {
        Squelette squelette = new Squelette("Mon profil", getMainStage());


        Parent conteneur = squelette.loadFXML("../xml_design/profil.fxml");

        Scene scene = new Scene(conteneur, squelette.getpHeight(), squelette.getpWidth());
        getMainStage().setScene(scene);
    }

    /**
     * initialise les choicebox, le menu(fixe+déroulant), lui ajoute les  différents boutons, et ajoute leur fonctionnalité à ces derniers
     */
    @FXML
    private void initialize() {

        choiceGroupe.setItems(observableArrayList(
                "Groupe 1",
                "Groupe 2",
                "Groupe 3",
                "Groupe 4"));

        choiceSGroupe.setItems(observableArrayList(
                "Sous-groupe A",
                "Sous-groupe B"));

        // Gestion des events lors du click sur le menu (menuList)

        Menu menu = new Menu(menuList, menuDeroulant);
        menu.addMenuButtons(menuDeconnexion, menuNoteAbsence, menuProfil);

        menuList.setOnMouseClicked(event -> menu.derouleMenu());

        btnChangeAvatar.setOnAction(event -> uploadImage());

        btnDeleteAvatar.setOnAction(event -> setDefaultAvatar());

        btnRegister.setOnAction(event -> {

            getUser().setPrenom(txtPrenom.getText());
            getUser().setNom(txtNom.getText());
            getUser().setBranche(txtDomaine.getText());
            getUser().setEtablissement(txtEtablissement.getText());
            getUser().setGroupe(choiceGroupe.getSelectionModel().getSelectedItem().toString());
            getUser().setSousgroupe(choiceSGroupe.getSelectionModel().getSelectedItem().toString());

            Alerte succes = new Alerte(Alert.AlertType.CONFIRMATION, true, "Vos modifications ont été enregistrées",
                    "Vous allez être redirigés à l'accueil !", null);
            showAbsenceNote();
        });

        menu.listenForClicks();


    }

    /**
     * met une image par default à l'avatar
     */

    private void setDefaultAvatar() {
        Image defautImage = new Image("/img/logo.png");
        getUser().setAvatar(defautImage);
        imageViewAvatar.setImage(defautImage);
    }

    /**
     * upload une image pour l'avatar
     * @throws IOException si l'image n'est pas lue
     */

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
