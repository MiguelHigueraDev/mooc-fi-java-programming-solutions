
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        int[][] t = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        MagicSquare ms = createMagicSquare(t);

        ArrayList<Integer> sumsOfDiagonals = ms.sumsOfDiagonals();
        
        System.out.println(sumsOfDiagonals);

        MagicSquareFactory msFactory = new MagicSquareFactory();
        System.out.println(msFactory.createMagicSquare(5));
    }

    public static MagicSquare createMagicSquare(int[][] numbers) {
        MagicSquare ms = new MagicSquare(numbers.length);
        for (int y = 0; y < numbers.length; y++) {
            for (int x = 0; x < numbers[y].length; x++) {
                ms.placeValue(x, y, numbers[y][x]);
            }
        }

        return ms;
    }
}
