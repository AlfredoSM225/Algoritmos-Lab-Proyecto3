package GUIDiceGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlDiceGame implements Initializable {
    @FXML private Pane mesa;

    private DiceGameGrafico juego;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        juego = new DiceGameGrafico(mesa);
        juego.simulacion();

    }

}