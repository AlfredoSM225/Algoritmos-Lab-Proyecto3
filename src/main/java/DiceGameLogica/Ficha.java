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

    //Aumenta el contaddor de turnos interno de la ficha, usado para las graficas
    public void AumentarTurnosFicha(){
        turnos = turnos +1;
    }

    //Cambia el tipo de ficha a Nueva para diferencias de la iniciales
    public void fichaNueva(){
        tipoFicha = true;
    }

    //Setters y Getters

    public boolean getTipoFicha(){
        return tipoFicha;
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
