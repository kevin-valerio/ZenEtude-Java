package ZenEtude;


import java.util.Date;
/**
 *   Note est la classe représentant une note d'un étudiant
 *
 * @author Equipe 19
 * @version 1.0
 */

public class Note {

    private String matiere;
    private Integer note;
    private Integer coeff;
    private Date date;

    /**
     * initialise la matière, la note, le coeff, la date de la note
     * @param Matiere
     * la matière de la note
     * @param Note
     * la valeur de la note
     * @param Coeff
     * le coeff de la note
     * @param date
     * la date de la note
     */
    public Note(String Matiere, Integer Note, Integer Coeff, Date date) {
        this.matiere = Matiere;
        this.note = Note;
        this.coeff = Coeff;
        this.date = date;
    }

    /**
     * met à jour le coeff
     * @param coeff
     * coeff de la note
     */
    public void setCoeff(Integer coeff) {
        this.coeff = coeff;
    }

    /**
     * met à jour la date
     * @param date
     * date de la note
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * met à jour la matière
     * @param matiere
     * matiere de la note
     */
    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    /**
     * met à jour la valeur de la note
     * @param note
     * valeur de la note
     */
    public void setNote(Integer note) {
        this.note = note;
    }

    /**
     * @return la date de la note
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @return le coeff de la note
     */

    public Integer getCoeff() {
        return coeff;
    }

    /**
     *
     * @return la valeur de la note
     */
    public Integer getNote() {
        return note;
    }

    /**
     *
     * @return la matière de la note
     */

    public String getMatiere() {
        return matiere;
    }

}
