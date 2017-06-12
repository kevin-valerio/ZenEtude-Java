package ZenEtude;

import javafx.scene.image.Image;

import java.time.LocalDate;

import static ZenEtude.ControllerAccueil.showMain;

class Utilisateur {

    private String password;
    private String mail;
    private LocalDate birthday;
    private Boolean isProf;
    private Image myAvatar;


    Utilisateur(final String mail, final String password, final LocalDate birthday){

        this.mail = mail;
        this.password = password;
        this.birthday = birthday;

        this.myAvatar = new Image("/img/logo.png");

    }

    public Boolean getIsProf() {
        return isProf;
    }

    public void setIsProf(Boolean isProf) {
        this.isProf = isProf;
    }

    public String getMail() {
        return mail;
    }

    public void logout(){
        showMain();
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


    public void setAvatar(Image avatar) {
        this.myAvatar = avatar;
    }
}