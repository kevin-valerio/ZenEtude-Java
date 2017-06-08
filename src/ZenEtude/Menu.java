package ZenEtude;

import com.sun.org.glassfish.gmbal.ParameterNames;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

class Menu {
    private BorderPane menuFixe;
    private BorderPane menuDeroulant;

    Menu(BorderPane menuFixe, BorderPane menuDeroulant) {
        this.menuDeroulant = menuDeroulant;
        this.menuFixe = menuFixe;

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

    public void afficherMenu(){


        if(menuDeroulant.isVisible()){
            menuDeroulant.setVisible(false);
        }
        else{
            menuDeroulant.setVisible(true);
        }

        //TODO : Ajouter un fade-in / fade-out


    }
}
