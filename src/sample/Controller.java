package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private Label labelFooter;
    @FXML
    private void initialize() {
        labelFooter.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("x");
            }
        });
    }
}
