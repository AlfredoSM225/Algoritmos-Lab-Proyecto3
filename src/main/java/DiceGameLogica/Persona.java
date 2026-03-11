package DiceGameLogica;

import java.util.ArrayList;

public class Persona {
    private D6 dado;
    private ArrayList<Ficha> fichas;

    public Persona(){
        dado = new D6();
        fichas = new ArrayList<>();
    }

    public ArrayList<Ficha> quitarFichas(int num){
        return (ArrayList<Ficha>) fichas.subList(0,num);
    }

    public void recibirFichas(ArrayList<Ficha> recibidas){
        fichas.addAll(recibidas);
    }

    public int tirarD6(){
        return dado.rollD6();
    }

    public D6 getDado() {
        return dado;
    }

    public void setDado(D6 dado) {
        this.dado = dado;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }
}
