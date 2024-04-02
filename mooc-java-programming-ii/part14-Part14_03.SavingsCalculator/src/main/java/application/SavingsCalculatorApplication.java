package application;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) {
        // Main layout
        BorderPane layout = new BorderPane();

        // Line chart
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings");
        lineChart.setLegendVisible(false);

        // Initial values
        int[] monthlySavings = {25}; // Array to store effectively final value
        int[] yearlyInterestRate = {10}; // Array to store effectively final value

        // Add data to line chart
        XYChart.Series savingsData = getSavingsData(monthlySavings[0]);
        lineChart.getData().add(savingsData);

        XYChart.Series interestData = getInterestData(monthlySavings[0], yearlyInterestRate[0]);
        lineChart.getData().add(interestData);

        BorderPane msPane = makeSavingsPane(monthlySavings[0]);
        BorderPane yirPane = makeInterestRatePane(yearlyInterestRate[0]);

        // VBox for two panes
        VBox panes = new VBox();
        panes.getChildren().addAll(msPane, yirPane);

        // Add panes to main layout
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setTop(panes);
        layout.setCenter(lineChart);

        Scene view = new Scene(layout, 1280, 720);
        stage.setScene(view);
        stage.show();

        // Attach listeners to update data
        attachSliderListeners(msPane, yirPane, monthlySavings, yearlyInterestRate, lineChart);
    }

    private BorderPane makeInterestRatePane(int yearlyInterestRate) {
        // Yearly interest rate
        IntegerProperty yearlyInterestRateProperty = new SimpleIntegerProperty(yearlyInterestRate);
        Slider yirSlider = new Slider(0, 10, yearlyInterestRate);
        yirSlider.setShowTickMarks(true);
        yirSlider.setShowTickLabels(true);
        yirSlider.valueProperty().bindBidirectional(yearlyInterestRateProperty);

        BorderPane yirPane = new BorderPane();
        Label yirLabel = new Label("Yearly interest rate");
        Label yirState = new Label();
        // Bind label to current state
        yirState.textProperty().bind(yearlyInterestRateProperty.asString());
        yirPane.setCenter(yirSlider);
        yirPane.setLeft(yirLabel);
        yirPane.setRight(yirState);

        return yirPane;
    }

    private BorderPane makeSavingsPane(int monthlySavings) {
        // Monthly savings
        // Bind property with slider
        IntegerProperty monthlySavingsProperty = new SimpleIntegerProperty(monthlySavings);
        Slider msSlider = new Slider(25, 250, monthlySavings);
        msSlider.setShowTickMarks(true);
        msSlider.setShowTickLabels(true);
        msSlider.valueProperty().bindBidirectional(monthlySavingsProperty);

        BorderPane msPane = new BorderPane();
        Label msLabel = new Label("Monthly savings");
        Label msState = new Label();
        // Bind label to current state
        msState.textProperty().bind(monthlySavingsProperty.asString());
        msPane.setCenter(msSlider);
        msPane.setLeft(msLabel);
        msPane.setRight(msState);

        return msPane;
    }

    private XYChart.Series getSavingsData(int monthlySavings) {
        XYChart.Series data = new XYChart.Series();
        int NUMBER_OF_YEARS = 30;
        for (int i = 0; i <= NUMBER_OF_YEARS; i++) {
            int yearlySavings = monthlySavings * i * 12;
            data.getData().add(new XYChart.Data(i, yearlySavings));
        }

        return data;
    }

    private XYChart.Series getInterestData(int monthlySavings, int interest) {
        XYChart.Series data = new XYChart.Series();
        int NUMBER_OF_YEARS = 30;
        double savings = 0.0;
        double interests = 0.0;
        for (int i = 0; i <= NUMBER_OF_YEARS; i++) {
            data.getData().add(new XYChart.Data(i, interests));
            savings += monthlySavings * 12;
            interests = (interests + monthlySavings * 12) * (1.0 + interest / 100.0);
        }
        return data;
    }

    private void attachSliderListeners(BorderPane msPane, BorderPane yirPane, int[] monthlySavings, int[] yearlyInterestRate, LineChart lineChart) {
        Slider msSlider = (Slider) msPane.getCenter();
        Slider yirSlider = (Slider) yirPane.getCenter();

        msSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            monthlySavings[0] = newValue.intValue();
            lineChart.getData().set(0, getSavingsData(monthlySavings[0]));
            lineChart.getData().set(1, getInterestData(monthlySavings[0], yearlyInterestRate[0]));
        });

        yirSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            yearlyInterestRate[0] = newValue.intValue();
            lineChart.getData().set(0, getSavingsData(monthlySavings[0]));
            lineChart.getData().set(1, getInterestData(monthlySavings[0], yearlyInterestRate[0]));
        });
    }

}
