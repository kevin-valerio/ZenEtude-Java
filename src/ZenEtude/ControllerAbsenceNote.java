package ZenEtude;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.util.Date;

import static ZenEtude.ControllerInscription.getUser;
import static ZenEtude.Main.*;
import static ZenEtude.Menu.isViewable;

@SuppressWarnings("deprecation")
public class ControllerAbsenceNote {

    // BorderPane du menu (déroulant et fixe)
    @FXML private BorderPane menuList = new BorderPane();
    @FXML private BorderPane menuDeroulant = new BorderPane();
    @FXML private BorderPane menuDeconnexion;
    @FXML private BorderPane menuNoteAbsence;
    @FXML private BorderPane menuProfil;
    // Table notes et absences

    @FXML private TableView<Note> tableNotes = new TableView<Note>();
    @FXML private TableView<Absence> tableAbsence = new TableView<Absence>();


    //Ci-dessous : colonnes pour la table Note

    @FXML private TableColumn<Note, String> matiereColumn;
    @FXML private TableColumn<Note, Integer> noteColumn;
    @FXML private TableColumn<Note, Integer> coeffColumn;
    @FXML private TableColumn<Note, Date> dateColumn;


    //Ci-dessous : colonnes pour la table Absence

    @FXML private TableColumn<Absence, String> matiereAbsenceColumn;
    @FXML private TableColumn<Absence, String> motifAbsenceColumn;
    @FXML private TableColumn<Absence, Date>   dateAbsenceColumn;

    @FXML private Label pseudoLabel;


    private final ObservableList<Note> noteArray =
            FXCollections.observableArrayList(
                    new Note("Mathématiques", 18, 4, new Date(2017, 12, 10)),
                    new Note("Français", 12, 4,new Date(2017, 11, 18)),
                    new Note("Anglais", 8, 3,new Date(2017, 12, 5)),
                    new Note("Mathématiques", 14 , 4,new Date(2017, 10, 22)),
                    new Note("EPS", 11, 1,new Date(2017, 11, 13))
            );

                 /*
                       noteArray : Liste de notes. Ici on ajoute des valeurs aléatoires,
                        mais normalement elle se remplie en fonction de l'utilisateur et de ses réelles notes
                */

    private final ObservableList<Absence> absenceArray =
            FXCollections.observableArrayList(
                    new Absence("Français", "aucun motif présenté pour le moment", new Date(2017,12,11)),
                    new Absence("Anglais", "malade", new Date(2017,11,9)),
                    new Absence("Mathématiques", "aucun motif présenté pour l'instant", new Date(2017,10,12)),
                    new Absence("Anglais", "rattrapage de contrôle", new Date(2017,10,12)),
                    new Absence("EPS", "dispensé de sport", new Date(2017,30,11))



            );

                /*
                       absenceArray : Liste d'absences. Ici on ajoute des valeurs aléatoires,
                       mais normalement elle se remplie en fonction de l'utilisateur et de ses réelles absences
                */


    @FXML
    private void initialize() {

        pseudoLabel.setText(getUser().getMail());
        initTable();
        addRandomAbsence();
        addRandomNotes();

        // Gestion des events lors du click sur le menu (menuList)
        Menu menu = new Menu(menuList, menuDeroulant);
        menu.addMenuButtons(menuDeconnexion, menuNoteAbsence, menuProfil);

        menuList.setOnMouseClicked(event -> {
            menu.afficherMenu();
            menu.setColor("#eee4c2", menuDeroulant);
            if(menuDeroulant.getOpacity() == 100){
                menuList.setStyle("-fx-background-color: #eee4c2");
            }
            else{
                menuList.setStyle("-fx-background-color: #f3f1ea");

            }


        });

        menuDeconnexion.setOnMouseClicked(event -> {
            menu.pressedLogoutBtn();
        });
        menuNoteAbsence.setOnMouseClicked(event -> {

            menu.pressedNoteAbsenceBtn();
        });
        menuProfil.setOnMouseClicked(event -> {
            menu.pressedProfilBtn();
        });


    }
    public static void showAbsenceNote(){
        Squelette squelette = new Squelette("Notes et absences", getMainStage());

        Parent conteneur = squelette.loadFXML("../xml_design/viewAbsenceNote.fxml");

        Scene scene = new Scene(conteneur, squelette.getpHeight(), squelette.getpWidth());

        getMainStage().setScene(scene);
    }

    private void addRandomAbsence(){
        tableAbsence.setItems(absenceArray);

    }

    private void addRandomNotes(){
        tableNotes.setItems(noteArray);

    }

    public BorderPane getMenuList() {
        return menuList;
    }

    public BorderPane getMenuDeroulant() {
        return menuDeroulant;
    }

    private void initTable(){

        matiereColumn.setCellValueFactory(new PropertyValueFactory<Note, String>("matiere"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<Note, Integer>("note"));
        coeffColumn.setCellValueFactory(new PropertyValueFactory<Note, Integer>("coeff"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Note, Date>("date"));

        dateAbsenceColumn.setCellValueFactory(new PropertyValueFactory<Absence, Date>("date"));
        motifAbsenceColumn.setCellValueFactory(new PropertyValueFactory<Absence, String>("motif"));
        matiereAbsenceColumn.setCellValueFactory(new PropertyValueFactory<Absence, String>("matiere"));


    }


}