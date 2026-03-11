package DiceGameLogica;

import java.util.ArrayList;

public class Persona {
    private int identificador;
    private D6 dado;
    private ArrayList<Ficha> fichas;

    public Persona(int identificador){
        this.identificador = identificador;
        dado = new D6();
        fichas = new ArrayList<>();
        recibirFichasIniciales(4);
    }

    public ArrayList<Ficha> quitarFichas(int num){
        ArrayList<Ficha> sacadas = new ArrayList<>(fichas.subList(0,num));
        fichas.subList(0,num).clear();
        return sacadas;
    }

    public ArrayList<Ficha> quitarTodasFichas(){
        ArrayList<Ficha> sacadas = new ArrayList<>();
        sacadas.addAll(fichas);
        fichas.clear();
        return sacadas;
    }

    public void recibirFichasIniciales(int numFichas){
        for (int i = 1; i <= numFichas; i++){
            fichas.add(new Ficha());
        }
    }

    public void recibirFichas(ArrayList<Ficha> recibidas){
        for(Ficha f : recibidas){
            f.MoverFicha();
            this.fichas.add(f);
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

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }

    @Override
    public String toString(){
        return dado.getValorD6() + " " + fichas.size();
    }
}
