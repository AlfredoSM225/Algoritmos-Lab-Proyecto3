package GUIDiceGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainDiceGame extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String ruta = "/DiceGame.fxml";
        var recurso = getClass().getResource(ruta);

        Parent root = FXMLLoader.load(recurso);
        stage.setScene(new Scene(root));
        stage.setTitle("DiceGame");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
