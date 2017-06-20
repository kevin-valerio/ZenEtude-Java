package ZenEtude.Tests;

import ZenEtude.Absence;
import org.junit.Test;

import java.util.Date;


public class AbsenceTest {
    private Absence abs = new Absence(" "," ",new Date());


    @Test
    public void matiereTest() throws Exception {
        abs.setMatiere("Maths");
        assert (abs.getMatiere().equals("Maths"));
    }
    @Test
    public void motifTest() throws Exception {
        abs.setMotif("malade");
        assert (abs.getMotif().equals("malade"));
    }
    @Test
    public void dateTest() throws Exception {
        abs.setDate(new Date(20/06/2017));
        assert (abs.getDate().equals(new Date(20/06/2017)));
    }

}