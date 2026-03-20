package DiceGameLogica;

import java.util.ArrayList;

public class Persona {
    private int identificador;
    private D6 dado;
    private ColaCircular<Ficha> fichas;

    public Persona(int identificador){
        this.identificador = identificador;
        dado = new D6();
        fichas = new ColaCircular<Ficha>();
        recibirFichasIniciales(4);
    }

    public ArrayList<Ficha> quitarFichas(int num){
        ArrayList sacadas = new ArrayList<Ficha>();
        for(int i = 0; i < num; i++){
            Ficha f = fichas.eliminarCircular();
            sacadas.add(f);
        }
        return sacadas;
    }

    public ArrayList<Ficha> quitarTodasFichas(){
        ArrayList<Ficha> sacadas = new ArrayList<Ficha>();
        while(fichas.getTamano() > 0){
            sacadas.add(fichas.eliminarCircular());
        }
        return sacadas;
    }

    public void recibirFichasIniciales(int numFichas){
        for (int i = 1; i <= numFichas; i++){
            fichas.insertarCircular(new Ficha(false));
        }
    }

    public void recibirFichas(ArrayList<Ficha> recibidas){
        for(Ficha f : recibidas){
            this.fichas.insertarCircular(f);
        }

    }

    public void aumentarTurnosTodasFichas(){
        int total = fichas.getTamano();
        for (int i = 0; i < total; i++) {
            Ficha f = fichas.eliminarCircular();
            if(f != null){
                f.AumentarTurnosFicha();
                fichas.insertarCircular(f);
            }
        }
    }

    public int tirarD6(){
        return dado.rollD6();
    }

    public int getIdentificador() {
        return identificador;
    }

    public D6 getDado() {
        return dado;
    }

    public void setDado(D6 dado) {
        this.dado = dado;
    }

    public ColaCircular<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ColaCircular<Ficha> fichas) {
        this.fichas = fichas;
    }

    public int getNumFichas(){
        return fichas.getTamano();
    }

    @Override
    public String toString(){
        return dado.getValorD6() + " " + fichas.getTamano();
    }
}
