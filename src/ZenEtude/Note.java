package ZenEtude;


import java.util.Date;

public class Note {

    private String matiere;
    private Integer note;
    private Integer coeff;
    private Date date;

    public Note(String Matiere, Integer Note, Integer Coeff, Date date) {
        this.matiere = Matiere;
        this.note = Note;
        this.coeff = Coeff;
        this.date = date;
    }

    public void setCoeff(Integer coeff) {
        this.coeff = coeff;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public Integer getCoeff() {
        return coeff;
    }

    public Integer getNote() {
        return note;
    }

    public String getMatiere() {
        return matiere;
    }

}
