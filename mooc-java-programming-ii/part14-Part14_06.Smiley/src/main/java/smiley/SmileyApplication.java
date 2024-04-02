package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application {


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        
        Canvas canvas = new Canvas(440, 440);
        layout.setCenter(canvas);
        GraphicsContext painter = canvas.getGraphicsContext2D();
        
        // Draw smiley
        painter.setFill(Color.BLACK);
        
        // Eyes
        painter.fillRect(100, 30, 60, 60);
        painter.fillRect(280, 30, 60, 60);
        
        // Mouth
        painter.fillRect(40, 260, 60, 60);
        painter.fillRect(100, 320, 60, 60);
        painter.fillRect(160, 320, 60, 60);
        painter.fillRect(220, 320, 60, 60);
        painter.fillRect(280, 320, 60, 60);
        painter.fillRect(340, 260, 60, 60);
        
        Scene view = new Scene(layout);
        stage.setScene(view);
        stage.show();
    }

}
