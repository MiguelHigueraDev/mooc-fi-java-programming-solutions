package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);

    }

    @Override
    public void start(Stage window) {

        // Scene initialization
        BorderPane bp = new BorderPane();
        Scene first = new Scene(bp);
        VBox vb = new VBox();
        Scene second = new Scene(vb);
        GridPane gp = new GridPane();
        Scene third = new Scene(gp);

        // Scene 1
        Button btn1 = new Button("To the second view!");
        btn1.setOnAction((event) -> {
            window.setScene(second);
        });
        bp.topProperty().set(new Label("First view!"));
        bp.centerProperty().set(btn1);

        // Scene 2
        Button btn2 = new Button("To the third view!");
        btn2.setOnAction((event) -> {
            window.setScene(third);
        });
        vb.getChildren().addAll(btn2, new Label("Second view!"));

        // Schene 3
        Button btn3 = new Button("To the first view!");
        btn3.setOnAction((event) -> {
            window.setScene(first);
        });
        gp.add(new Label("Third view!"), 0, 0);
        gp.add(btn3, 1, 1);
        
        window.setScene(first);
        window.show();

    }

}
