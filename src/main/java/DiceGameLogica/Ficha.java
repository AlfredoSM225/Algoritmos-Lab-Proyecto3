package DiceGameLogica;

public class Ficha {
    int turnos;
    int posicion;
    boolean tipoFicha;

    public Ficha(boolean tipoFicha){
        turnos = 0;
        posicion = 0;
        this.tipoFicha = tipoFicha;
    }

    public void AumentarTurnosFicha(){
        turnos = turnos +1;
    }

    public boolean getTipoFicha(){
        return tipoFicha;
    }

    public void fichaNueva(){
        tipoFicha = true;
    }

    public int getTurnos() {
        return turnos;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
