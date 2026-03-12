package GUIDiceGame;

import DiceGameLogica.Persona;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PersonaGrafico {
    private Persona logica;
    private ImageView avatar;
    private D6Grafico d6;
    private VBox vista;

    public PersonaGrafico(Persona logica, double x, double y){
        this.logica = logica;
        avatar = new ImageView();
        avatar.setFitWidth(50);
        avatar.setFitHeight(70);
        setAvatar();
        this.d6 = new D6Grafico(logica.getDado());
        vista = new VBox(2);
        vista.setLayoutX(x);
        vista.setLayoutY(y);
        vista.getChildren().addAll(this.avatar, this.d6.getImagen());
    }

    public void setAvatar(){
        String ruta = "/Imagenes/persona.png";

        if (getClass().getResource(ruta) != null) {
            avatar.setImage(new Image(getClass().getResource(ruta).toExternalForm()));
        } else {
            System.out.println("Error: No se encontró la imagen en " + ruta);
        }
    }

    public ImageView getAvatar(){
        return avatar;
    }

    public VBox getVista() {
        return vista;
    }
}
