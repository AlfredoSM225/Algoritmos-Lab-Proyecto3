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

    //Inserta objetos a la Cola
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

    //Elimina objetos de la Cola
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

    //Permite ver un elemento sin eliminarlo segun su indice
    public T peek(int indice){
        return cola[indice];
    }

    //Regresa el tamaño de la Cola
    public int getTamano() {

        if (inicio == -1) {

            return 0;

        }

        return fin - inicio + 1;

    }

}

