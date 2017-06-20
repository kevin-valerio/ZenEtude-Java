package ZenEtude;

import javafx.scene.image.Image;

import java.time.LocalDate;

import static ZenEtude.ControllerAccueil.showMain;
/**
 *   Utilisateur est la classe représentant un utilisateur (élève ou prof)
 *
 * @author Equipe 19
 * @version 1.0
 */

public class Utilisateur {

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

    /**
     * initialise l'utilisateur avec ses informations
     * @param mail
     * mail initial
     * @param password
     * password initial
     * @param birthday
     * birthday initial
     */
    public Utilisateur(final String mail, final String password, final LocalDate birthday){

        this.mail = mail;
        this.password = password;
        this.birthday = birthday;

        this.myAvatar = new Image("/img/logo.png");

    }

    /**
     *
     * @return si l'utilisateur est un professeur
     */

    public Boolean getIsProf() {
        return isProf;
    }

    /**
     * met à jour si l'utilisateur est un prof ou non
     * @param isProf
     * nouveau statut
     */
    public void setIsProf(Boolean isProf) {
        this.isProf = isProf;
    }

    /**
     *
     * @return le mail de l'utilisateur
     */

    public String getMail() {
        return mail;
    }

    /**
     * bascule vers l'accueil, deconnexion
     * @see ControllerAccueil#showMain()
     */
    public void logout(){
        showMain();
    }

    /**
     *
     * @return le mot de passe de l'utilisateur
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param enteredMail
     * le mail entré à vérifier
     * @param enteredPassword
     * le password entré à vérifier
     * @return si la connexion est autorisée ou non
     */

    boolean isAuthorizedConnexion(String enteredMail, String enteredPassword) {
       return (
               enteredMail.equals(this.getMail())
               &
               enteredPassword.equals(this.getPassword())
       );
    }

    /**
     * met à jour l'avatar
     * @param avatar
     * nouvel avatar
     */

    public void setAvatar(Image avatar) {
        this.myAvatar = avatar;
    }

    /**
     *
     * @return le sous groupe de l'utilisateur
     */
    public String getSousgroupe() {
        return sousgroupe;
    }

    /**
     * met à jour le sous groupe de l"utilisateur
     * @param sousgroupe
     * nouveau sousgroupe
     */
    public void setSousgroupe(String sousgroupe) {
        this.sousgroupe = sousgroupe;
    }

    /**
     *
     * @return la branche , filière de l'utilisateur
     */
    public String getBranche() {
        return branche;
    }

    /**
     * met à jour la branche de l'utilisateur
     * @param branche
     * nouvelle branche
     */

    public void setBranche(String branche) {
        this.branche = branche;
    }

    /**
     *
     * @return l'établissement de l'utlilisateur
     */
    public String getEtablissement() {
        return etablissement;
    }

    /**
     * met à jour l"établissement de l"utilisateur
     * @param etablissement
     * nouvel établissement
     */
    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    /**
     *
     * @return le groupe de l'utilisateur
     */
    public String getGroupe() {
        return groupe;
    }

    /**
     * met à jour le groupe de l'utilisateur
     * @param groupe
     * nouveau groupe
     */
    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    /**
     *
     * @return le nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * met à jour le nom de l'utilisateur
     * @param nom
     * nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return le prenom de l'utilisateur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * met à jour le prenom de l'utilisateur
     * @param prenom
     * nouveau prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @return l'avatar de l'utilisateur
     */
    public Image getMyAvatar() {
        return myAvatar;
    }

    /**
     * met à jour l'avatar de l'utilisateur
     * @param myAvatar
     * nouvel avatar
     */
    public void setMyAvatar(Image myAvatar) {
        this.myAvatar = myAvatar;
    }
}