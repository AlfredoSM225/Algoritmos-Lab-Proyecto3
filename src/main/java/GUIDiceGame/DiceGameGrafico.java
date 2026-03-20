package GUIDiceGame;

import DiceGameLogica.DiceGameLogica;
import DiceGameLogica.Persona;
import DiceGameLogica.Cola;
import javafx.scene.layout.Pane;

public class DiceGameGrafico {
    private DiceGameLogica logica;
    private Pane ventana;
    private Cola<PersonaGrafico> colaPersonas;

    public DiceGameGrafico(Pane ventana){
        this.ventana = ventana;
        this.logica = new DiceGameLogica();
        colaPersonas = new Cola<PersonaGrafico>();
    }

    public void simulacion(){
        crearColaPersonasG();

    }

    public void crearColaPersonasG(){
        Cola<Persona> colaLogica = logica.getColaPersonas();
        double x = 50;
        for(int i = 0; i <= 9; i++){
            PersonaGrafico p;
            p = new PersonaGrafico(colaLogica.peek(i), x, 50);
            colaPersonas.insertarDato(p);
            x = x + 120;
            this.ventana.getChildren().add(p.getVista());

        }
    }

    public void actualizarVistaTodasFichas(){
        Cola<Persona> colaLogica = logica.getColaPersonas();
        for(int i = 0; i <= 9; i++){
            PersonaGrafico pg = colaPersonas.peek(i);
            pg.actualizarVistaFichas();

        }
    }

    public void actualizarVistaTodosDados(){
        Cola<Persona> colaLogica = logica.getColaPersonas();
        for(int i = 0; i <= 9; i++){
            PersonaGrafico pg = colaPersonas.peek(i);
            pg.actualizarVistaDado();

        }
    }

    public DiceGameLogica getLogica() {
        return logica;
    }

}
