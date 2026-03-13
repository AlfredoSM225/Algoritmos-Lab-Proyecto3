package DiceGameLogica;

import java.util.ArrayList;

public class DiceGameLogica {
    private Cola<Persona> colaPersonas;
    private ArrayList<Ficha> fichaSalida;


    public DiceGameLogica(){
        colaPersonas = new Cola<Persona>();
        LlenarCola();
        Persona p1 = colaPersonas.peek(0);
        p1.recibirFichasIniciales(196);
        fichaSalida = new ArrayList<Ficha>();
    }

    public void LlenarCola(){
        for(int i = 0; i <= 9; i++){
            Persona p = new Persona(i);
            colaPersonas.insertarDato(p);
            System.out.println("Se ha unido: " + p.getIdentificador());
        }
    }

    public void turno(){
        ArrayList<Ficha> fichasSig = new ArrayList<>();

        for(int i = 0; i <= 9; i++) {
            Persona pActual = colaPersonas.peek(i);

            int vDado = pActual.tirarD6();
            ArrayList<Ficha> fichasSacadas = new ArrayList<>();
            int cantidadARetirar = Math.min(vDado, pActual.getFichas().size());
            ArrayList<Ficha> fichasRetiradas = pActual.quitarFichas(cantidadARetirar);


            if(!fichasSig.isEmpty()){
                pActual.recibirFichas(fichasSig);
                fichasSig = new ArrayList<>();
            }

            if(i < 9){
                fichasSig.addAll(fichasRetiradas);
            }else{
                fichaSalida.addAll(fichasRetiradas);
            }
        }
    }

    public void mostrarConsola(){
        String c = "";
        for(int i = 0; i <= 9; i++){
            Persona p = colaPersonas.peek(i);
            if(p != null){
                c = c + p.toString() + "\t";
            }
        }
        System.out.println(c + " Fichas Salidas: " + fichaSalida.size());
    }

    public Cola<Persona> getColaPersonas() {
        return colaPersonas;
    }
}
