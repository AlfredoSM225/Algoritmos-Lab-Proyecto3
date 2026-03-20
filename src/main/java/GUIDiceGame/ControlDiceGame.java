package GUIDiceGame;

import DiceGameLogica.Ficha;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ControlDiceGame implements Initializable {
    @FXML private Pane mesa;
    @FXML private Label turnoActual;
    @FXML private Label fichasIniciales;
    @FXML private Label fichasNuevas;
    @FXML private Button Roll;

    private DiceGameGrafico juego;
    private boolean fase = true;
    private Graficos graficos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        juego = new DiceGameGrafico(mesa);
        juego.simulacion();
        graficos = new Graficos();

    }

    @FXML
    public void turno(){
        if(juego.getLogica().getTurnos() >= 22){
            return;
        }
        if(fase){
            Roll.setText("Pasar fichas");
            juego.getLogica().lanzamientoDeDados();
            int[] dados = juego.getLogica().getDadosTirados();
            System.out.println(Arrays.toString(dados));
            int turnoA = juego.getLogica().getTurnos();
            graficos.actualizarGraficaActividad(turnoA, dados);
            juego.actualizarVistaTodosDados();
            fase = false;
        } else {
            Roll.setText("Tirar dados");
            int turnos = juego.getLogica().getTurnos();
            if(turnos == 21){
                turnoActual.setText("Juego terminado");
            }else {
                turnoActual.setText("Turno: " + turnos);
            }
            System.out.println(turnos);
            int contFichas = juego.getLogica().pasoDeFichas();
            int totalFichas = juego.getLogica().getFichasSistema();
            ArrayList<Ficha> fichasP = juego.getLogica().getFichasProcesadas();
            System.out.println(totalFichas);
            graficos.actualizarGrafica(contFichas, totalFichas, fichasP);
            juego.actualizarVistaTodasFichas();
            int fNuevas = juego.getLogica().getNumFichasProcesadas();
            int fIniciales = juego.getLogica().getNumFichasSalida() - fNuevas;
            fichasIniciales.setText("Fichas Iniciales: " + fIniciales);
            fichasNuevas.setText("Fichas Nuevas: " + fNuevas);
            fase = true;
        }

    }

    @FXML
    public void mostrarEstadisticas(){
        Stage ventanaEst = new Stage();
        ventanaEst.setTitle("Estadisticas");

        GridPane panelG = graficos.getVista();
        Scene escena = new Scene(panelG, 800, 600);
        ventanaEst.setScene(escena);
        ventanaEst.show();
    }

}