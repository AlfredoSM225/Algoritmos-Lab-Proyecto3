package DiceGameLogica;

public class Cola <T> {
    private int max;
    private int inicio;
    private int fin;
    private T[] cola;

    public Cola(){
        max = 10;
        inicio = -1;
        fin = -1;
        cola = (T[]) new Object[max];
    }

    public void insertarDato(T dato){
        if(fin < max -1) {
            fin = fin + 1;
            cola[fin] = dato;

            if (fin == 0) {
                inicio = 0;
            }
        }else{
            System.out.println("Desbordamiento");
        }

    }

    public T eliminarDato(){
        T regreso = null;
        if(inicio != -1){
            regreso = cola[inicio];
            if (inicio == fin){
                inicio = -1;
                fin = -1;
            }else{
                inicio = inicio +1;
            }
        }else{
            System.out.println("Subdesbordamiento");
        }
        return regreso;
    }

    public T peek(int indice){
        return cola[indice];
    }

}

