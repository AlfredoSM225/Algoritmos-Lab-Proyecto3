package DiceGameLogica;

import java.util.Scanner;

public class DiceGame {
    private DiceGameLogica logica;

    public DiceGame(){
        logica = new DiceGameLogica();
    }

    public void Juego(){
        Scanner sc = new Scanner(System.in);
        logica.mostrarConsola();

        for(int i = 1;i <= 20; i++){
            sc.nextLine();

            //logica.turno();

            System.out.print("Turno " + i + ":\t");
            logica.mostrarConsola();
        }
    }
}
