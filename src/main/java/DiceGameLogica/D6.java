package DiceGameLogica;

import java.util.Random;

public class D6 {
    private int valorD6;

    public D6(){
        this.valorD6 = 1;
    }

    public int rollD6(){
        setValorD6();
        return getValorD6();
    }

    public void setValorD6(){
        Random r = new Random();
        this.valorD6 = r.nextInt(6) + 1;
    }

    public int getValorD6() {
        return valorD6;
    }
}
