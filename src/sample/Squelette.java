package sample;

import javafx.stage.Stage;

public class Squelette   {
    private  int pWidth = 1660;
    private  int pHeight = 940;
    private  int pMinHeight = 820;
    private  int pMinWidth = 1460;

    private String pTitle;

    public int getpHeight(){
        return pWidth;
    }
    public int getpWidth() {
        return pHeight;
    }


    public Squelette(String titrePage, Stage leStage) {

        pTitle = "Zen'Etude - " + titrePage;

        leStage.setMinHeight(pMinHeight);
        leStage.setMinWidth(pMinWidth);
        leStage.setTitle(pTitle);

    }
}
