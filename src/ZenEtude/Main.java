package ZenEtude;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainStage = primaryStage;

        //Creation de la page (grâce au squelette)
        Squelette squelette = new Squelette("Accueil", primaryStage);
        Parent root = squelette.loadFXML("../xml_design/accueil.fxml");

        Scene scene = new Scene(root, squelette.getpHeight(), squelette.getpWidth());

        primaryStage.setScene(scene);
        primaryStage.show();
        // Fin création page

    }


    public static void main(String[] args) {
        launch(args);

    }
}
