package ZenEtude;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

import static ZenEtude.ControllerInscription.user;

@SuppressWarnings("deprecation")
public class ControllerAbsenceNote {

    // Table notes et absences
    @FXML private TableView<Note> tableNotes;
  //  @FXML private TableView<Note> tableAbsence;

    //Ci-dessous : colonnes pour la table Note
    @FXML private TableColumn<Note, String> matiereColumn;
    @FXML private TableColumn<Note, Integer> noteColumn;
    @FXML private TableColumn<Note, Integer> coeffColumn;
    @FXML private TableColumn<Note, Date> dateColumn;

    //Ci-dessous : colonnes pour la table Absence
   /* @FXML private TableColumn<Note, String> matiereAbsenceColumn;
    @FXML private TableColumn<Note, String> motifAbsenceColumn;
    @FXML private TableColumn<Note, Date> dateAbsenceColumn; */
    @FXML private Label pseudoLabel;

    private final ObservableList<Note> NoteArray =
            FXCollections.observableArrayList(
                    new Note("Mathématiques", 18, 4, new Date(2017, 12, 10)),
                    new Note("Français", 12, 4,new Date(2017, 11, 18)),
                    new Note("Anglais", 8, 3,new Date(2017, 12, 5)),
                    new Note("Mathématiques", 14 , 4,new Date(2017, 10, 22)),
                    new Note("EPS", 11, 1,new Date(2017, 11, 13))
            );
                /*
                      NoteArray : Liste de notes. Ici on ajoute des valeurs aléatoires,
                      mais normalement elle se remplie en fonction de l'utilisateur et de ses réelles notes
                */


 /*

                      AbsenceArray : Liste d'absences. Ici on ajoute des valeurs aléatoires,
                      mais normalement elle se remplie en fonction de l'utilisateur et de ses réelles absences
                */


    @FXML

    private void initialize(){

        pseudoLabel.setText(user.getMail());
        addRandomNotes();
    }

    private void addRandomAbsences(){

    }


    private void addRandomNotes(){


     }
}