package DiceGameLogica;

import java.util.ArrayList;

public class DiceGameLogica {
    private Cola<Persona> colaPersonas;
    private ArrayList<Ficha> fichaSalida;
    private ArrayList<Ficha> fichasProcesadas;
    private ArrayList<ArrayList<Ficha>> fichasDPaso;
    private int turnos;


    public DiceGameLogica(){
        colaPersonas = new Cola<Persona>();
        fichasProcesadas = new ArrayList<>();
        LlenarCola();
        Persona p1 = colaPersonas.peek(0);
        p1.recibirFichasIniciales(196);
        fichaSalida = new ArrayList<Ficha>();

        fichasDPaso = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            fichasDPaso.add(new ArrayList<>());
        }
        turnos = 1;
    }

    //Inicializa la Cola con 10 personas
    public void LlenarCola(){
        for(int i = 0; i <= 9; i++){
            Persona p = new Persona(i);
            colaPersonas.insertarDato(p);
            System.out.println("Se ha unido: " + p.getIdentificador());
        }
    }

    //Gestiona la primera parte del turno, el lanzamiento de dados, el
    // retirado de fichas y actualización del tipo de ficha
    public void lanzamientoDeDados(){
        turnos = turnos +1;
        aumentarContTurnosFichas();
        ArrayList<Ficha> fichasSig = new ArrayList<>();

        for(int i = 0; i <= 9; i++) {
            Persona pActual = colaPersonas.peek(i);

            int vDado = pActual.tirarD6();
            ArrayList<Ficha> fichasSacadas = new ArrayList<>();
            int cantidadARetirar = Math.min(vDado, pActual.getNumFichas());
            ArrayList<Ficha> fichasRetiradas = pActual.quitarFichas(cantidadARetirar);

            if (pActual.getIdentificador() == 0) {
                for (Ficha f : fichasRetiradas) {
                    f.fichaNueva();
                }
            }
            fichasDPaso.set(i, fichasRetiradas);
        }
    }

    //Gestiona la segunda parte del turno donde cada persona recibe las fichas que le corresponden
    //o las saca del sistema
    public int pasoDeFichas(){
        for (int i = 0; i <= 9; i++) {
            ArrayList<Ficha> fichasRecibidas = fichasDPaso.get(i);

            if (i < 9) {
                Persona pSiguiente = colaPersonas.peek(i + 1);
                pSiguiente.recibirFichas(fichasRecibidas);
            } else {
                contTurnosFicha(fichasRecibidas);
                fichaSalida.addAll(fichasRecibidas);
            }
            fichasDPaso.set(i, new ArrayList<>());
        }
        return fichaSalida.size();
    }

    //Separa las fichas iniciales de las nuevas, ya que las gráficas se basan en las nuevas
    public  void contTurnosFicha(ArrayList<Ficha> fichasRecibidas){
        for(Ficha f : fichasRecibidas){
            if(f.getTipoFicha()){
                fichasProcesadas.add(f);
            }
        }
    }

    //Aumenta el contador de turnos de cada ficha por cada persona en la Cola de personas
    public void aumentarContTurnosFichas(){
        for(int i = 0; i <= 9; i++){
           Persona p = colaPersonas.peek(i);
           p.aumentarTurnosTodasFichas();
        }
    }

    //Regresa un arreglo con los valores de dado sacado por cada persona
    public int[] getDadosTirados(){
        int[] dados = new int[10];
        for(int i = 0; i <= 9; i++){
            Persona p = colaPersonas.peek(i);
            if(p != null){
                dados[i] = p.getDado().getValorD6();
            }
        }
        return dados;
    }


    //Setters y Getters

    public int getTurnos() {
        return turnos;
    }

    public Cola<Persona> getColaPersonas() {
        return colaPersonas;
    }

    public ArrayList<Ficha> getFichaSalida() {
        return fichaSalida;
    }

    public ArrayList<Ficha> getFichasProcesadas() {
        return fichasProcesadas;
    }

    public int getNumFichasSalida(){
        return fichaSalida.size();
    }

    public int getNumFichasProcesadas(){
        return fichasProcesadas.size();
    }

    public int getFichasSistema(){
        int total = 0;
        for(int i = 1; i <= 9; i++) {
            Persona pActual = colaPersonas.peek(i);
            total = total + pActual.getNumFichas();
        }
        return total;
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
}
