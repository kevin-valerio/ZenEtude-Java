package ZenEtude;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.IntegerStringConverter;

import java.util.Date;

import static ZenEtude.ControllerInscription.getUser;
import static ZenEtude.Main.getMainStage;


/**
 *   ControllerAbsenceNote est la classe représentant le controller de viewAbsenceNote.fxml
 *   @see  <a href="wiewAbsenceNote.fxml"> wiewAbsenceNote.fxml </a>
 *
 * @author Equipe 19
 * @version 1.0
 */
@SuppressWarnings("deprecation")

public class ControllerAbsenceNote {
    // Objets pour que le professeur puisse chercher un eleve
    @FXML private Button btnSearch;
    @FXML private TextField txtNom;
    @FXML private Label lblSearch;

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
    /**
     * initialise le pseudolabel avec le mail de l'utilisateur, la table notes et absences puis la remplit de notes et absences aléatoires
     * @see #initTable()
     * @see #addRandomAbsence()
     * @see #addRandomNotes()
     */
    private void initialize() {

        pseudoLabel.setText(getUser().getMail());
        initTable();
        addRandomAbsence();
        addRandomNotes();

        // Gestion des events lors du click sur le menu (menuList)
        Menu menu = new Menu(menuList, menuDeroulant);
        menu.addMenuButtons(menuDeconnexion, menuNoteAbsence, menuProfil);

        menuList.setOnMouseClicked(event -> {
           menu.derouleMenu();
        });

        menu.listenForClicks();

        if(getUser().getIsProf()){
             showSearchBarForProf();
            tableAbsence.setEditable(true);
            tableNotes.setEditable(true);
            setAllTablesEditables();
        }


    }

    /**
     *
     */

    private void setAllTablesEditables() {

       /**
           Si on est professeur, alors toutes les tables deviennent éditables et on peut définir
           les notes et absences de chaque eleve

       */

        matiereAbsenceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        matiereAbsenceColumn.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setMatiere(t.getNewValue())
        );

        motifAbsenceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        motifAbsenceColumn.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setMotif(t.getNewValue())
        );

        matiereColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        matiereColumn.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setMatiere((t.getNewValue()))
        );


        noteColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        noteColumn.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setNote((t.getNewValue()))
        );


        coeffColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        coeffColumn.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setCoeff((t.getNewValue()))
        );

        //Alerte editNotApplied = new Alerte(Alert.AlertType.INFORMATION, true, "Vos 'edits' ne seront pas appliqués", "Attention, les modifications apportées ne seront pas appliquées ! ", "Ceci étant que la partie IHM du projet");


    }

    /**
     * pour les profs, rend visible la barre de recherche d'élèves
     */
    private void showSearchBarForProf(){

        btnSearch.setVisible(true);
        txtNom.setVisible(true);
        lblSearch.setVisible(true);

    }

    /**
     * crée le squelette de la page
     * @see Squelette
     * load le fxml
     * cree la scene (avec le loadeur) et l'attribue au main stage
     * @see Main#getMainStage()
     *
     *
     */
    public static void showAbsenceNote(){

        Squelette squelette = new Squelette("Notes et absences", getMainStage());
        Parent conteneur = squelette.loadFXML("../xml_design/viewAbsenceNote.fxml");
        Scene scene = new Scene(conteneur, squelette.getpHeight(), squelette.getpWidth());

        getMainStage().setScene(scene);
    }

    /**
     * ajoute des absences aléatoires à la table
     */

    private void addRandomAbsence(){
        tableAbsence.setItems(absenceArray);

    }

    /**
     * ajoute des notes aléaoires à la table
     */
    private void addRandomNotes(){
        tableNotes.setItems(noteArray);

    }

    /**
     *
     * @return le menu list(fixe)
     */

    public BorderPane getMenuList() {
        return menuList;
    }

    /**
     *
     * @return le menu déroulant
     */

    public BorderPane getMenuDeroulant() {
        return menuDeroulant;
    }

    /**
     * initialise la table notes et absences
     */

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