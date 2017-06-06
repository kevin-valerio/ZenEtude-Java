package ZenEtude;

class Utilisateur {

    private static String password;
    private static String mail;

    public Utilisateur(final String mail, final String password){
        Utilisateur.mail = mail;
        Utilisateur.password = password;

    }


    public String getMail() {
        return mail;
    }


    public String getPassword() {
        return password;
    }

    boolean isAuthorizedConnexion(String enteredMail, String enteredPassword) {
       return (
               enteredMail.equals(this.getMail())
               &
               enteredPassword.equals(this.getPassword())
       );
    }
}