
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < square.length; i++) {
            int sum = 0;
            for (int j = 0; j < square[i].length; j++) {
                sum += square[i][j];
            }
            sums.add(sum);
        }
        return sums;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < square.length; i++) {
            int sum = 0;
            for (int j = 0; j < square.length; j++) {
                sum += square[j][i];
            }
            sums.add(sum);
        }
        return sums;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sums = new ArrayList<>();
        int leftDiagonalSum = getLeftDiagonals().stream().mapToInt(Integer::intValue).sum();
        int rightDiagonalSum = getRightDiagonals().stream().mapToInt(Integer::intValue).sum();
        sums.add(leftDiagonalSum);
        sums.add(rightDiagonalSum);
        return sums;
    }

    // Left diagonal is i - 1, j + 1;
    public ArrayList<Integer> getLeftDiagonals() {
        ArrayList<Integer> diagonal = new ArrayList<>();
        int j = 0;
        int i = square.length - 1;
        diagonal.add(square[i][j]);
        while (i > 0 && j + 1 < square.length) {
            diagonal.add(square[i - 1][j + 1]);
            j++;
            i--;
        }
        return diagonal;
    }

    // Right diagonal is i + 1, j + 1;
    public ArrayList<Integer> getRightDiagonals() {
        ArrayList<Integer> diagonal = new ArrayList<>();
        int j = 0;
        int i = 0;
        diagonal.add(square[i][j]);
        while (i + 1 < square.length && j + 1 < square.length) {
            diagonal.add(square[i + 1][j + 1]);
            j++;
            i++;
        }
        return diagonal;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
