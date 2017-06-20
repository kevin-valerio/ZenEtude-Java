package ZenEtude;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *   Main est la classe représentant le main
 *
 * @author Equipe 19
 * @version 1.0
 */

public class Main extends Application {
    private static Stage mainStage;

    /**
     *
     * @return le stage main
     */

    public static Stage getMainStage() {
        return mainStage;
    }

    @Override
    /**
     * @throws Exception si erreur lors de l"execution
     * crée la page
     * @see Squelette
     */
    public void start(Stage primaryStage) throws Exception {

        mainStage = primaryStage;

        //Creation de la page (grâce au squelette)

        Squelette squelette = new Squelette("Accueil", primaryStage);
        Parent root = squelette.loadFXML("../xml_design/accueil.fxml");
        Scene scene = new Scene(root, squelette.getpHeight(), squelette.getpWidth());
        primaryStage.setScene(scene);
        primaryStage.show();

        // Fin création page

    }

    /**
     * lance l'éxécution
     * @param args
     * args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
}
