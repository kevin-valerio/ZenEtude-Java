package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

         Squelette squelette = new Squelette("Accueil", primaryStage);

        // Creation de la page (grâce au squelette)
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
