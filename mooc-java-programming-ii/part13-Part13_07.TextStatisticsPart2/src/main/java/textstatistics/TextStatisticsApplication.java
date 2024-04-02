package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) {

        HBox texts = new HBox();
        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestWordLabel = new Label("The longest word is:");
        texts.getChildren().addAll(lettersLabel, wordsLabel, longestWordLabel);

        BorderPane layout = new BorderPane();
        TextArea input = new TextArea();
        input.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            lettersLabel.setText("Letters: " + characters);
            wordsLabel.setText("Words: " + words);
            longestWordLabel.setText("The longest word is: " + longest);
        });

        layout.setCenter(input);
        layout.setBottom(texts);

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }

}
