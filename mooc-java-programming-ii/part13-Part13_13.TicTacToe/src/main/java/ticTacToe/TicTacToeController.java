/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author misfit
 */
public class TicTacToeController {

    private Symbol currentTurn;
    private List<Symbol> board;

    // Board -> ['0','1','2',
    //          '3','4','5',
    //          '6','7','8']
    // Start an empty board and mark the first turn as X
    public TicTacToeController() {
        this.currentTurn = Symbol.X;
        this.board = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            this.board.add(Symbol.EMPTY);
        }
    }

    // Get the current turn
    public Symbol getTurn() {
        return currentTurn;
    }

    // Get the current board
    public List<Symbol> getBoard() {
        return board;
    }

    // Make a move (only if there isn't a Symbol already placed)
    public boolean play(int index) {
        if (this.board.get(index) == Symbol.EMPTY) {
            this.board.set(index, currentTurn);
            return true;
        }

        return false;
    }

    // Advances to the next turn and returns it
    public Symbol nextTurn() {
        if (this.currentTurn == Symbol.X) {
            this.currentTurn = Symbol.O;
            return Symbol.O;
        } else {
            this.currentTurn = Symbol.X;
            return Symbol.X;
        }
    }

    // Checks if game ended (all symbols are completed)
    public boolean checkGameEnded() {
        return this.board.stream().allMatch(symbol -> symbol != Symbol.EMPTY);
    }

    // Checks if there is a winner and returns the winning Symbol (or null if there's no winner)
    public Symbol checkWinner() {
        int[][] winningCombinations = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
        };

        // Loop over all winningCombination's indexes in the board
        for (int i = 0; i < winningCombinations.length; i++) {
            int matches = 0;
            Symbol currSymbol = board.get(winningCombinations[i][0]);
            for (int j = 0; j < winningCombinations[i].length; j++) {
                if (board.get(winningCombinations[i][j]) == currSymbol && currSymbol != Symbol.EMPTY) {
                    matches++;
                }
            }
            if (matches == 3) {
                return currSymbol;
            }
        }

        return null;
    }

    // Gets the 2 dimensional coordinates of the provided board index to generate the game board UI.
    public int[] get2dCoords(int index) {
        switch (index) {
            case 0:
                return new int[]{0, 0};
            case 1:
                return new int[]{0, 1};
            case 2:
                return new int[]{0, 2};
            case 3:
                return new int[]{1, 0};
            case 4:
                return new int[]{1, 1};
            case 5:
                return new int[]{1, 2};
            case 6:
                return new int[]{2, 0};
            case 7:
                return new int[]{2, 1};
            case 8:
                return new int[]{2, 2};
        }
        return new int[]{0, 0};
    }
}
