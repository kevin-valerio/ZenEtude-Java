package ZenEtude;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;


public class Main extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        Squelette squelette = new Squelette("Accueil", primaryStage);

        //Creation de la page (grâce au squelette)

        Parent root = FXMLLoader.load(getClass().getResource("../xml_design/accueil.fxml"));
        Scene scene = new Scene(root, squelette.getpHeight(), squelette.getpWidth());
        primaryStage.setScene(scene);
        primaryStage.show();

        // Fin création page

    }


    public static void main(String[] args) {
        launch(args);

    }
}
