package GUIDiceGame;

import DiceGameLogica.Ficha;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FichaGrafica {
    private Ficha logica;
    private ImageView vista;

    public FichaGrafica(Ficha logica){
        this.logica = logica;
        vista = new ImageView();
        vista.setFitHeight(10);
        vista.setFitWidth(10);
        setImagen();
    }

    public void setImagen(){
        if(logica.getTipoFicha()) {
            String ruta = "/Imagenes/ficha.png";

            if (getClass().getResource(ruta) != null) {
                vista.setImage(new Image(getClass().getResource(ruta).toExternalForm()));
            } else {
                System.out.println("Error: No se encontró la imagen en " + ruta);
            }
        }else{
            String ruta = "/Imagenes/fichaI.png";

            if (getClass().getResource(ruta) != null) {
                vista.setImage(new Image(getClass().getResource(ruta).toExternalForm()));
            } else {
                System.out.println("Error: No se encontró la imagen en " + ruta);
            }
        }
    }

    public ImageView getImagen(){
        return vista;
    }
}
