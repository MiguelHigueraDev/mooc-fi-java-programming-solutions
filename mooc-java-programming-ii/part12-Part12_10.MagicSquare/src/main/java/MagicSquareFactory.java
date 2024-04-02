
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        // First place first square (in the center of the first row)
        int middle = (int) Math.ceil(size / 2);
        int currentValue = 1;
        square.placeValue(middle, 0, currentValue);

        // These represent the current x and y location
        int x = middle;
        int y = 0;

        while (currentValue < size * size) {
            currentValue++;
            // Calculate the next position
            int nextX = (x + 1) % size;
            int nextY = (y - 1 + size) % size;
            // If the next position is already occupied
            if (square.readValue(nextX, nextY) != 0) {
                // Move down one position
                nextX = x;
                nextY = (y + 1) % size;
            }
            // Place the value in the next position
            square.placeValue(nextX, nextY, currentValue);
            // Update current position
            x = nextX;
            y = nextY;
        }

        return square;
    }

}
