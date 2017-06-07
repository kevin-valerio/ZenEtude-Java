package ZenEtude;


import java.util.Date;

public class Absence {

    private String matiere;
    private String motif;
    private Date date;

    public Absence(String Matiere, String Motif, Date date) {
        this.matiere = Matiere;
        this.motif = Motif;
        this.date = date;
    }

    public String getMatiere() {
        return matiere;
    }

    public Date getDate() {
        return date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}
