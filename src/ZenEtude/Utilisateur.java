package ZenEtude;

import java.time.LocalDate;

class Utilisateur {

    private static String password;
    private static String mail;
    private static LocalDate birthday;
    private static Boolean isProf;


    public Utilisateur(final String mail, final String password, final LocalDate birthday){
        Utilisateur.mail = mail;
        Utilisateur.password = password;
        Utilisateur.birthday = birthday;

    }

    public static Boolean getIsProf() {
        return isProf;
    }

    public static void setIsProf(Boolean isProf) {
        Utilisateur.isProf = isProf;
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