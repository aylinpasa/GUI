import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Graphic extends Application {


    final static String kötü = "0-20";
    final static String düşük = "20-40";
    final static String orta = "40-60";
    final static String iyi = "60-80";
    final static String yüksek = "80-100";
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final StackedBarChart<Number, String> sbc =
            new StackedBarChart<Number, String>(yAxis, xAxis);
    final XYChart.Series<Number, String> series1 =
            new XYChart.Series<Number, String>();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        sbc.setTitle("Grade Summary");
        xAxis.setLabel("Grades ");
        xAxis.setCategories(FXCollections.<String>observableArrayList(
                Arrays.asList(kötü, düşük, orta,iyi , yüksek)));
        yAxis.setLabel(" Number of Students ");
        // plus value
        series1.getData().add(new XYChart.Data<Number, String>(0, kötü));
        series1.getData().add(new XYChart.Data<Number, String>( 0, düşük));
        series1.getData().add(new XYChart.Data<Number, String>(0, orta));
        series1.getData().add(new XYChart.Data<Number, String>(0, iyi));
        series1.getData().add(new XYChart.Data<Number, String>(0, yüksek));

        series1.getData().add(new XYChart.Data<Number, String>( 15, kötü));
        series1.getData().add(new XYChart.Data<Number, String>(27, düşük));
        series1.getData().add(new XYChart.Data<Number, String>(20, orta));
        series1.getData().add(new XYChart.Data<Number, String>(11, iyi));
        series1.getData().add(new XYChart.Data<Number, String>(5, yüksek));

        Scene scene = new Scene(sbc, 800, 600);
        sbc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }

}
