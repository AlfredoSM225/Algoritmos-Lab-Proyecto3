package GUIDiceGame;

import DiceGameLogica.Ficha;
import DiceGameLogica.Persona;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class PersonaGrafico {
    private Persona logica;
    private ImageView avatar;
    private D6Grafico d6;
    private TilePane fichas;
    private VBox vista;

    public PersonaGrafico(Persona logica, double x, double y){
        this.logica = logica;
        avatar = new ImageView();
        avatar.setFitWidth(100);
        avatar.setFitHeight(130);
        setAvatar();

        d6 = new D6Grafico(logica.getDado());

        fichas = new TilePane();
        fichas.setPrefColumns(4);
        fichas.setHgap(2);
        fichas.setVgap(2);
        fichas.setMaxWidth(50);
        actualizarFichas();
        actualizarVista();

        vista = new VBox(2);
        vista.setLayoutX(x);
        vista.setLayoutY(y);
        VBox.setMargin(d6.getImagen(), new Insets(5, 0, 0, 30));

        vista.getChildren().addAll(this.avatar, this.d6.getImagen(), fichas);
    }

    public void setAvatar(){
        String ruta = "/Imagenes/persona.png";

        if (getClass().getResource(ruta) != null) {
            avatar.setImage(new Image(getClass().getResource(ruta).toExternalForm()));
        } else {
            System.out.println("Error: No se encontró la imagen en " + ruta);
        }
    }

    public void actualizarFichas(){
        fichas.getChildren().clear();
        for(Ficha f : logica.getFichas()){
            FichaGrafica fichaG = new FichaGrafica(f);
            fichas.getChildren().add(fichaG.getImagen());
        }
    }

    public void actualizarVista(){
        d6.actualizarVista();
        actualizarFichas();

        if (logica.getIdentificador() == 0) {
            this.fichas.setVisible(false);
        } else {
            this.fichas.setVisible(true);
        }
    }

    public ImageView getAvatar(){
        return avatar;
    }

    public VBox getVista() {
        return vista;
    }
}
