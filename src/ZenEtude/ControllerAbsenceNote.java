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

     @FXML private TableView<Note> tableNotes;

    @FXML private TableColumn<Note, String> matiereColumn;
    @FXML private TableColumn<Note, Integer> noteColumn;
    @FXML private TableColumn<Note, Integer> coeffColumn;
    @FXML private TableColumn<Note, Date> dateColumn;

    @FXML private Label pseudoLabel;

    private final ObservableList<Note> NoteArray =
            FXCollections.observableArrayList(
                    new Note("Mathématiques", 18, 4, new Date(2017, 12, 10)),
                    new Note("Français", 12, 4,new Date(2017, 11, 18)),
                    new Note("Anglais", 8, 3,new Date(2017, 12, 5)),
                    new Note("Mathématiques", 14 , 4,new Date(2017, 10, 22)),
                    new Note("EPS", 11, 1,new Date(2017, 11, 13))
            );


    @FXML
    private void initialize() {

        pseudoLabel.setText(user.getMail());
        matiereColumn.setCellValueFactory(new PropertyValueFactory<Note, String>("Matiere"));


        tableNotes.getItems().setAll(NoteArray);
    }
}