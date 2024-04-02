package ticTacToe;

import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Initialize a new game
        TicTacToeController game = new TicTacToeController();

        // Create main layout
        BorderPane layout = new BorderPane();

        // Create game status label
        Label gameStatus = new Label("Turn: X");
        gameStatus.setFont(Font.font("Monospaced", 20));
        layout.setTop(gameStatus);

        // Create layout buttons with current game status
        GridPane buttons = generateButtons(game, gameStatus);
        layout.setCenter(buttons);

        Scene view = new Scene(layout, 240, 280);
        stage.setScene(view);
        stage.show();
    }

    public GridPane generateButtons(TicTacToeController game, Label gameStatus) {
        List<Symbol> board = game.getBoard();
        GridPane buttons = new GridPane();

        for (int i = 0; i < board.size(); i++) {
            int[] coordinates = game.get2dCoords(i);
            int x = coordinates[0];
            int y = coordinates[1];

            // Get button text
            Symbol currSymbol = board.get(i);
            String buttonText = " ";
            if (currSymbol == Symbol.O) {
                buttonText = "O";
            } else if (currSymbol == Symbol.X) {
                buttonText = "X";
            }
            Button btn = new Button(buttonText);
            btn.setFont(Font.font("Monospaced", 40));

            // Add listener to button to update UI status
            final int finalI = i;
            btn.setOnMouseClicked((event) -> {
                // Don't do anything if the game already ended
                if (game.checkGameEnded() || game.checkWinner() != null) {
                    return;
                }
                
                // Make a play if it's valid (empty square)
                boolean validPlay = game.play(finalI);

                if (validPlay) {
                    // Update buttons with game status
                    String turn = game.getTurn().toString();
                    btn.setText(turn);

                    // Change turn and update turn label
                    String nextTurn = game.nextTurn().toString();
                    gameStatus.setText("Turn: " + nextTurn);

                    // Check if there is a winner or game ended in a tie
                    Symbol checkWinner = game.checkWinner();
                    boolean tie = game.checkGameEnded();
                    if (checkWinner != null || tie) {
                        gameStatus.setText("The end!");
                        return;
                    }
                }
            });

            buttons.add(btn, y, x);
        }
        return buttons;
    }

}
