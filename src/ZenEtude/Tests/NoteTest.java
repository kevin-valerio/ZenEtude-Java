package ZenEtude.Tests;

import ZenEtude.Note;
import org.junit.Test;

import java.util.Date;


public class NoteTest {

    private Note note = new Note("Maths",17,2,new Date(19/06/2017));

    @Test
    public void coeffTest() throws Exception {
        note.setCoeff(3);
        assert (note.getCoeff().equals(3));
    }

    @Test
    public void matiereTest() throws Exception {
        note.setMatiere("BD");
        assert (note.getMatiere().equals("BD"));
    }

    @Test
    public void noteTest() throws Exception {
        note.setNote(17);
        assert (note.getNote().equals(17));
    }

    @Test
    public void dateTest() throws Exception {
        note.setDate(new Date(20/06/2017));
        assert (note.getDate().equals(new Date(20/06/2017)));
    }

}