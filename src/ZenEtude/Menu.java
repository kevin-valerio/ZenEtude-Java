package ZenEtude;

import javafx.animation.FadeTransition;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static ZenEtude.ControllerAbsenceNote.*;
import static ZenEtude.ControllerAccueil.*;
import static ZenEtude.ControllerProfil.*;

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


        if(menuDeroulant.getOpacity() == 0){
        for(int i=0; i < 100; i++){
            try {
                Thread.sleep(10);
                menuDeroulant.setOpacity(i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
         }
        else {
            menuDeroulant.setOpacity(100);

        }
        //TODO : Ajouter un fade-in / fade-out


    }


}
