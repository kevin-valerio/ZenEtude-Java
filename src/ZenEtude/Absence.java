package ZenEtude;


import java.util.Date;

/**
 *  Absence est la classe représentant une absence d'un étudiant
 *
 * @author Equipe 19
 * @version 1.0
 */
public class Absence {

    private String matiere;
    private String motif;
    private Date date;

    /**
     *
     * @param Matiere
     *                  Matiere avec laquelle on souhaite  initialiser l'absence
     * @param Motif
     *                  Date avec laquelle on souhaite initialiser l'absence
     * @param date
     *                  Date avec laquelle on souhaite initialiser l'absence
     */

    public Absence(String Matiere, String Motif, Date date) {
        this.matiere = Matiere;
        this.motif = Motif;
        this.date = date;
    }

    /**
     *
     * @return la matière de l'absence
     */

    public String getMatiere() {
        return matiere;
    }

    /**
     *
     * @return la date de l'absence
     */

    public Date getDate() {
        return date;
    }

    /**
     *
     * @return le motif de l'absence
     */

    public String getMotif() {
        return motif;
    }

    /**
     *
     * @param matiere
     *                  Matière avec laquelle on souhaite mettre a jour l'absence
     */

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    /**
     *
     * @param date
     *                  Date avec laquelle on souhaite mettre a jour l'absence

     *
     */

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @param motif
     *                  Motif avec lequel on souhaite mettre a jour l'absence
     */

    public void setMotif(String motif) {
        this.motif = motif;
    }
}
