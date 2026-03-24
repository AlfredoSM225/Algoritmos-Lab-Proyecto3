package DiceGameLogica;

public class ColaCircular<T> {
    private T[] colaC;
    private int inicio;
    private int fin;

    public ColaCircular() {
        colaC = (T[]) new Object[1000];
        inicio = -1;
        fin = -1;
    }

    //Inserta objetos a la ColaCircular
    public void insertarCircular(T dato) {
        if ((fin == colaC.length - 1 && inicio == 0) || (fin + 1 == inicio)) {
            System.out.println("Desbordamiento");
            return;
        }

        if (fin == colaC.length - 1) {
            fin = 0;
        } else {
            fin = fin + 1;
        }

        colaC[fin] = dato;

        if (inicio == -1) {
            inicio = 0;
        }
    }

    //Elimina objetos de la ColaCircular
    public T eliminarCircular() {
        if (inicio == -1) {
            System.out.println("Subdesbordamiento");
            return null;
        }

        T dato = colaC[inicio];

        if (inicio == fin) {
            inicio = -1;
            fin = -1;
        } else {
            if (inicio == colaC.length - 1) {
                inicio = 0;
            } else {
                inicio = inicio + 1;
            }
        }
        return dato;
    }

    //Regresa el tamaño de la ColaCircular
    public int getTamano() {
        if (inicio == -1) return 0;
        if (fin >= inicio) return fin - inicio + 1;
        return (colaC.length - inicio) + (fin + 1);
    }
}
