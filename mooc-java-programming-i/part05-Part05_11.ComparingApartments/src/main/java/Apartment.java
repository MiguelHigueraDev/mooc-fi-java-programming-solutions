
public class Apartment {

    private int rooms;
    private int squares;
    private int pricePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getSquares() {
        return squares;
    }

    public void setSquares(int squares) {
        this.squares = squares;
    }

    public int getPricePerSquare() {
        return pricePerSquare;
    }

    public void setPricePerSquare(int pricePerSquare) {
        this.pricePerSquare = pricePerSquare;
    }
    
    
    public boolean largerThan(Apartment compared) {
        return this.getSquares() > compared.getSquares();
    }
    
    public int priceDifference(Apartment compared) {
        int thisPrice = this.squares * this.pricePerSquare;
        int comparedPrice = compared.getSquares() * compared.getPricePerSquare();
        
        return Math.abs(thisPrice - comparedPrice);
    }
    
    public boolean moreExpensiveThan(Apartment compared) {
        int thisPrice = this.squares * this.pricePerSquare;
        int comparedPrice = compared.getSquares() * compared.getPricePerSquare();
        
        return thisPrice > comparedPrice;
    }

}
