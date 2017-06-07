package ZenEtude;


import java.util.Date;

public class Absence {

    private String Matiere;
    private String Motif;
    private Date date;

    public Absence(String Matiere, String Motif, int Coeff, Date date) {
        this.Matiere = Matiere;
        this.Motif = Motif;
        this.date = date;
    }


}
