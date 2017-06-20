package ZenEtude;

import javafx.animation.FadeTransition;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import static ZenEtude.ControllerAbsenceNote.showAbsenceNote;
import static ZenEtude.ControllerAccueil.showMain;
import static ZenEtude.ControllerProfil.showProfil;
/**
 *   Menu est la classe représentant notre menu personnalisé
 *
 * @author Equipe 19
 * @version 1.0
 */

public class Menu {
    private BorderPane menuFixe;
    private BorderPane menuDeroulant;
    private BorderPane menuDeconnexion;
    private BorderPane menuNoteAbsence;
    private BorderPane menuProfil;

    /**
     * initialise le menu déroulant et fixe
     * @param menuList
     *                  le menu fixe
     * @param menuDeroulant
     *                      le menu déroulant
     */
    public Menu(BorderPane menuList, BorderPane menuDeroulant) {

        this.menuDeroulant = menuDeroulant;
        this.menuFixe = menuList;

    }

    /**
     * initialise les menus menuDeconnexion, menuNoteAbsence et menuProfil
     * @param menuDeconnexion
     * menu deconnexion
     * @param menuNoteAbsence
     * menu note et absence
     * @param menuProfil
     * menu profil
     */
    public void addMenuButtons(BorderPane menuDeconnexion, BorderPane menuNoteAbsence, BorderPane menuProfil){
        this.menuDeconnexion = menuDeconnexion;
        this.menuNoteAbsence = menuNoteAbsence;
        this.menuProfil = menuProfil;

    }

    /**
     * ajoute a chaque menu sa fonctionnalité
     */

    public void listenForClicks(){
        menuDeconnexion.setOnMouseClicked(event -> {
            this.pressedLogoutBtn();
        });
        menuNoteAbsence.setOnMouseClicked(event -> {

            this.pressedNoteAbsenceBtn();
        });
        menuProfil.setOnMouseClicked(event -> {
            this.pressedProfilBtn();
        });

    }

    /**
     *
     * @param couleur
     * couleur à appliquer
     * @param pane
     * pane concerné
     */

    public void setColor(String couleur, BorderPane pane){
         pane.setStyle("-fx-background-color: " + couleur);
    }

    /**
     *
     * @return le menu deroulant
     */
    public BorderPane getMenuDeroulant() {
        return menuDeroulant;
    }

    /**
     *
     * @return le menu fixe
     */

    public BorderPane getMenuFixe() {
        return menuFixe;
    }

    /**
     * met à jour le menu déroulant
     * @param menuDeroulant
     * menu déroulant
     */

    public void setMenuDeroulant(BorderPane menuDeroulant) {
        this.menuDeroulant = menuDeroulant;
    }

    /**
     * met à jour le menu fixe
     * @param menuFixe
     * menu fixe
     */

    public void setMenuFixe(BorderPane menuFixe) {
        this.menuFixe = menuFixe;
    }

    /** bascule vers la page note et absence
     * @see ControllerAbsenceNote#showAbsenceNote()
     */

    public void pressedNoteAbsenceBtn(){
       showAbsenceNote();
    }

    /**
     * bascule vers la page profil
     * @see ControllerProfil#showProfil()
     */

    public void pressedProfilBtn(){
        showProfil();
    }

    /**
     * bascule vers la page accueil
     * @see ControllerAccueil#showMain()
     */

    public void pressedLogoutBtn(){
        showMain();
    }

    /**
     * affiche le menu et son effet fade
     * @see #fadeIn()
     * @see #fadeOut()
     */

    public void afficherMenu(){

        if (menuDeroulant.getOpacity() == 0)
                fadeIn();
        else
            fadeOut();

    }

    /**
     * effet de fade quannd on ouvre le menu
     */
    private void fadeIn(){
        for(int i=0; i < 100; i++) {

            FadeTransition ft = new FadeTransition(Duration.millis(300), menuDeroulant);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
        }
    }

    /**
     * effet de fade quand on ferme le menu
     */
    private void fadeOut(){
        for(int i=0; i < 100; i++) {

            FadeTransition ft = new FadeTransition(Duration.millis(300), menuDeroulant);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.play();
        }
    }

    /**
     * deroule le menu fixe pour ainsi afficher le menu deroulant
     */
    public void derouleMenu() {
        this.afficherMenu();
        this.setColor("#eee4c2", menuDeroulant);
        if(menuDeroulant.getOpacity() == 100){
            menuFixe.setStyle("-fx-background-color: #eee4c2");
        }
        else{
            menuFixe.setStyle("-fx-background-color: #f3f1ea");
        }
    }

}
