package ZenEtude;

import javafx.animation.FadeTransition;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import static ZenEtude.ControllerAbsenceNote.showAbsenceNote;
import static ZenEtude.ControllerAccueil.showMain;
import static ZenEtude.ControllerProfil.showProfil;

class Menu {
    private BorderPane menuFixe;
    private BorderPane menuDeroulant;
    private BorderPane menuDeconnexion;
    private BorderPane menuNoteAbsence;
    private BorderPane menuProfil;

    Menu(BorderPane menuList, BorderPane menuDeroulant) {

        this.menuDeroulant = menuDeroulant;
        this.menuFixe = menuList;

    }

    public void addMenuButtons(BorderPane menuDeconnexion, BorderPane menuNoteAbsence, BorderPane menuProfil){
        this.menuDeconnexion = menuDeconnexion;
        this.menuNoteAbsence = menuNoteAbsence;
        this.menuProfil = menuProfil;

    }

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

    public void setColor(String couleur, BorderPane pane){
         pane.setStyle("-fx-background-color: " + couleur);
    }

    public BorderPane getMenuDeroulant() {
        return menuDeroulant;
    }

    public BorderPane getMenuFixe() {
        return menuFixe;
    }

    public void setMenuDeroulant(BorderPane menuDeroulant) {
        this.menuDeroulant = menuDeroulant;
    }

    public void setMenuFixe(BorderPane menuFixe) {
        this.menuFixe = menuFixe;
    }



    public void pressedNoteAbsenceBtn(){
       showAbsenceNote();
    }

    public void pressedProfilBtn(){
        showProfil();
    }

    public void pressedLogoutBtn(){
        showMain();
    }

    public void afficherMenu(){

        if (menuDeroulant.getOpacity() == 0)
                fadeIn();
        else
            fadeOut();

    }


    private void fadeIn(){
        for(int i=0; i < 100; i++) {

            FadeTransition ft = new FadeTransition(Duration.millis(300), menuDeroulant);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
        }
    }

    private void fadeOut(){
        for(int i=0; i < 100; i++) {

            FadeTransition ft = new FadeTransition(Duration.millis(300), menuDeroulant);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.play();
        }
    }

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
