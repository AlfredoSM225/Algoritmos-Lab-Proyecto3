package GUIDiceGame;

import DiceGameLogica.Ficha;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Graficos {
    private GridPane contenedor;
    private BarChart<String, Number> graficaSalidas;
    private XYChart.Series<String, Number> serieSalidas;
    private BarChart<String, Number> graficaTotales;
    private XYChart.Series<String, Number> serieTotales;
    private BarChart<String, Number> graficaTiempos;
    private XYChart.Series<String, Number> serieTiempos;
    private BarChart<String, Number> graficaActividad;
    private ArrayList<XYChart.Series<String, Number>> todasSeries;
    private ComboBox<String> selector;
    private int turnos;

    public Graficos(){
        contenedor = new GridPane();
        contenedor.setHgap(10);
        contenedor.setVgap(10);
        turnos = 0;

        inicializarGraficaSalidas();
        inicializarGraficaTotales();
        inicializarGraficaTiempos();
        inicializarGraficoActividad();
        contenedor.add(graficaSalidas,0,1);
        contenedor.add(graficaTotales,0,2);
        contenedor.add(graficaTiempos, 1, 1);
    }

    //Los siguientes métodos inicializan las gráficas

    public void inicializarGraficaSalidas(){
        CategoryAxis x = new CategoryAxis();
        x.setLabel("Número de Turno");
        NumberAxis y = new NumberAxis(0, 70, 5);
        y.setLabel("Fichas Salidas");

        graficaSalidas = new BarChart<>(x, y);
        graficaSalidas.setTitle("Salida de fichas");

        serieSalidas = new XYChart.Series<>();
        serieSalidas.setName("Número de fichas");
        graficaSalidas.getData().add(serieSalidas);
    }

    public void inicializarGraficaTotales(){
        CategoryAxis x = new CategoryAxis();
        x.setLabel("Número de Turno");
        NumberAxis y = new NumberAxis(0, 100, 10);
        y.setLabel("Fichas en el sistema");

        graficaTotales = new BarChart<>(x, y);
        graficaTotales.setTitle("Fichas en sistema");

        serieTotales = new XYChart.Series<>();
        serieTotales.setName("Número de fichas");
        graficaTotales.getData().add(serieTotales);
    }

    public void inicializarGraficaTiempos() {
        CategoryAxis x = new CategoryAxis();
        x.setLabel("Orden de llegada");
        NumberAxis y = new NumberAxis(0, 20, 2);
        y.setLabel("Tiempo en el sistema");

        graficaTiempos = new BarChart<>(x, y);
        graficaTiempos.setTitle("Tiempo en sistema");

        serieTiempos = new XYChart.Series<>();
        serieTiempos.setName("Tiempo por ficha");
        graficaTiempos.getData().add(serieTiempos);
    }

    public void inicializarGraficoActividad(){
        CategoryAxis x = new CategoryAxis();
        x.setLabel("Número de turno");
        NumberAxis y = new NumberAxis();
        y.setLabel("Valor");

        graficaActividad = new BarChart<>(x, y);
        graficaActividad.setTitle("Actividad");
        todasSeries = new ArrayList<>();

        selector = new ComboBox<>();
        selector.getItems().add("Todos");
        for(int i = 1; i <= 10; i++){
            selector.getItems().add("Persona " + i);
            XYChart.Series<String, Number> serie = new XYChart.Series<>();
            serie.setName("P" + i);
            todasSeries.add(serie);
        }
        XYChart.Series<String, Number> serieGrupo = new XYChart.Series<>();
        serieGrupo.setName("Todos");
        todasSeries.add(serieGrupo);

        selector.setValue("Todos");
        selector.setOnAction(e -> actualizarSeries());
        graficaActividad.getData().add(todasSeries.get(10));

        VBox graficaA = new VBox(5, selector, graficaActividad);
        contenedor.add(graficaA,1, 2);
    }

    //Actualiza los datos de cada gráfica y su parte visual
    public void actualizarGrafica(int numFichas, int totalFichas, ArrayList<Ficha> fichasP){
        turnos++;
        String t = String.valueOf(turnos);
        serieSalidas.getData().add(new XYChart.Data<>(t, numFichas));
        serieTotales.getData().add(new XYChart.Data<>(t, totalFichas));

        for (Ficha f : fichasP) {
            String idFicha = String.valueOf(fichasP.indexOf(f) + 1);
            serieTiempos.getData().add(new XYChart.Data<>(idFicha, f.getTurnos()));
        }
    }

    //Actualiza específicamente la gráfica de actividad, ya que es más compleja
    public void actualizarGraficaActividad(int turno, int[] valoresDado){
        int sumatoria = 0;
        String t = String.valueOf(turno);
        for(int i = 0; i < 10; i++){
            int valor = valoresDado[i];
            todasSeries.get(i).getData().add(new XYChart.Data<>(t, valor));
            sumatoria += valor;
        }
        todasSeries.get(10).getData().add(new XYChart.Data<>(t, sumatoria));
    }

    //Actualiza las series para las gráficas
    public void actualizarSeries(){
        graficaActividad.getData().clear();
        int idx = selector.getSelectionModel().getSelectedIndex();
        if(idx == 0){
            graficaActividad.getData().add(todasSeries.get(10));
        } else if (idx > 0) {
            graficaActividad.getData().add(todasSeries.get(idx - 1));
        }
    }


    //Setters y Getters

    public GridPane getVista(){
        return contenedor;
    }
}