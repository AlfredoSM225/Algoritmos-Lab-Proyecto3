package GUIDiceGame;

import DiceGameLogica.DiceGameLogica;
import DiceGameLogica.Persona;
import javafx.scene.layout.Pane;

public class DiceGameGrafico {
    private DiceGameLogica logica;
    private Pane ventana;

    public DiceGameGrafico(Pane ventana){
        this.ventana = ventana;
        this.logica = new DiceGameLogica();
    }

    public void simulacion(){
        Persona p = new Persona(1);
        PersonaGrafico persona = new PersonaGrafico(p, 200, 200);
        this.ventana.getChildren().add(persona.getVista());
    }

}
