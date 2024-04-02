package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) {

        try {
            // Get the parties information
            Map<String, Map<Integer, Double>> parties = loadPartyData();
            System.out.println(parties);

            NumberAxis xAxis = new NumberAxis(1968, 2008, 2);
            NumberAxis yAxis = new NumberAxis();

            LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
            lineChart.setTitle("Relative support of the parties");

            // Add each party's data
            parties.keySet().stream().forEach(party -> {
                XYChart.Series data = new XYChart.Series();
                data.setName(party);

                parties.get(party).entrySet().stream().forEach(pair -> {
                    data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                });

                lineChart.getData().add(data);
            });

            Scene view = new Scene(lineChart, 1280, 720);
            stage.setScene(view);
            stage.show();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading file: " + e);
        }

    }

    private Map<String, Map<Integer, Double>> loadPartyData() throws FileNotFoundException {
        // Read data from TSV file
        File file = new File("partiesdata.tsv");
        Scanner scanner = new Scanner(file);

        // Create map to store the data
        Map<String, Map<Integer, Double>> parties = new HashMap<>();

        // Store all the years (in the first line)
        List<Integer> yearsList = new ArrayList<>();
        String yearsStr = scanner.nextLine();
        String[] years = yearsStr.split("\t");
        
        // Ignore first index because it's useless (just a label)
        for (int i = 1; i < years.length; i++) {
            yearsList.add(Integer.valueOf(years[i]));
        }

        // Loop over each party and get their information
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String[] data = line.split("\t");

            Map<Integer, Double> supports = new HashMap<>();

            // Ignore first index (this is the party name)
            for (int i = 1; i < data.length; i++) {
                // Treat dashes as zero
                if (data[i].equals("-")) {
                    supports.put(Integer.valueOf(yearsList.get(i - 1)), 0.0);
                } else {
                    supports.put(Integer.valueOf(yearsList.get(i - 1)), Double.valueOf(data[i]));
                }
            }

            String partyName = data[0];
            parties.put(partyName, supports);
        }

        return parties;
    }

}
