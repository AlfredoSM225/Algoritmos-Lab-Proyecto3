package DiceGameLogica;

import java.util.Random;

public class D6 {
    private int valorD6;

    public D6(){
        this.valorD6 = 1;
    }

    //"Tira" el dado y regresa el valor
    public int rollD6(){
        setValorD6();
        return getValorD6();
    }

    //Genera un número al azar del 1 al 6 y lo guarda en valorD6
    public void setValorD6(){
        Random r = new Random();
        this.valorD6 = r.nextInt(6) + 1;
    }

    //Regresa el valor actual del dado
    public int getValorD6() {
        return valorD6;
    }
}
