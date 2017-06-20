package ZenEtude.Tests;


import ZenEtude.Utilisateur;
import org.junit.Test;


public class UtilisateurTest {

    private Utilisateur user = new Utilisateur("test@test.tt","mdp123", null);

    @Test
    public void matiereTest() throws Exception {
        assert (user.getPassword().equals("mdp123"));
    }

    @Test
    public void mailTest() throws Exception {
        assert (user.getMail().equals("test@test.tt"));

    }

    @Test
    public void profTest() throws Exception {
        user.setIsProf(true);
        assert(user.getIsProf().equals(new Boolean(true)));

    }

   @Test
    public void prenomTest() throws Exception {

        user.setPrenom("Michel");
        assert (user.getPrenom().equals(new String("Michel")));

    }

    @Test
    public void nomTest() throws Exception {

        user.setPrenom("Dupont");
        assert (user.getNom().equals(new String("Dupont")));

    }

    @Test
    public void etablissementTest() throws Exception {
        user.setEtablissement("IUT");
        assert (user.getEtablissement().equals("IUT"));

    }
    @Test
    public void brancheTest() throws Exception {
        user.setBranche("Info");
        assert (user.getBranche().equals("Info"));


    }

    @Test
    public void groupeTest() throws Exception {
        user.setGroupe("4");
        assert (user.getGroupe().equals("4"));

    }

    @Test
    public void sousgroupeTest() throws Exception {
        user.setSousgroupe("A");
        assert (user.getSousgroupe().equals("A"));

    }

}