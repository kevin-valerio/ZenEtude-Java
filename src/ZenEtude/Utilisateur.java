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
    private String prenom;
    private String nom;
    private String etablissement;
    private String branche;
    private String groupe;
    private String sousgroupe;


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

    public String getSousgroupe() {
        return sousgroupe;
    }

    public void setSousgroupe(String sousgroupe) {
        this.sousgroupe = sousgroupe;
    }

    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Image getMyAvatar() {
        return myAvatar;
    }

    public void setMyAvatar(Image myAvatar) {
        this.myAvatar = myAvatar;
    }
}