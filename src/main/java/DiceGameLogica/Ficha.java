package DiceGameLogica;

public class Ficha {
    int movimientos;
    int posicion;

    public Ficha(){
        movimientos = 0;
        posicion = 0;
    }

    public void MoverFicha(){
        movimientos = movimientos +1;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
