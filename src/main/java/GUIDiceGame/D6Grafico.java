package GUIDiceGame;

import DiceGameLogica.D6;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class D6Grafico {
    private D6 logica;
    private ImageView vista;

    public D6Grafico(D6 logica){
        this.logica = logica;
        vista = new ImageView();
        vista.setFitHeight(40);
        vista.setFitWidth(40);
        setImagen(1);

    }

    //Actualiza la vista según el valor recibido de la lógica
    public void actualizarVista(){
        setImagen(logica.getValorD6());
    }


    //Setters y Getters

    public void setImagen(int valor){
        String ruta = "/Imagenes/D" + valor + ".png";

        if (getClass().getResource(ruta) != null) {
            vista.setImage(new Image(getClass().getResource(ruta).toExternalForm()));
        } else {
            System.out.println("Error: No se encontró la imagen en " + ruta);
        }
    }

    public ImageView getImagen(){
        return vista;
    }
}
