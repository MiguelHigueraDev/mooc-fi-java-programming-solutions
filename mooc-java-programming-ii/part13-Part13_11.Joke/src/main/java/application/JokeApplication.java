package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        layout.setPrefSize(600, 300);
        
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        Button question = new Button("Joke");
        Button answer = new Button("Answer");
        Button explanation = new Button("Explanation");
        
        menu.getChildren().addAll(question, answer, explanation);
        
        layout.setTop(menu);
        
        StackPane questionLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("A gummy bear isn't a real bear.");
        
        question.setOnAction((event) -> layout.setCenter(questionLayout));
        answer.setOnAction((event) -> layout.setCenter(answerLayout));
        explanation.setOnAction((event) -> layout.setCenter(explanationLayout));
        
        layout.setCenter(questionLayout);
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
        
    }
    
    private StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 100);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);
        return layout;
    }
}
