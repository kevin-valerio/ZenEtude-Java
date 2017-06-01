package ZenEtude;

public class Utilisateur {

    private static boolean ISCONNECTED = false;
    private static String password;
    private static String mail;

    public Utilisateur(final String mail, final String password){
        this.mail = mail;
        this.password = password;

    }

    public void setIsConnected(final boolean value){
        this.ISCONNECTED = value;
    }

    public String getMail() {
        return mail;
    }


    public String getPassword() {
        return password;
    }
}