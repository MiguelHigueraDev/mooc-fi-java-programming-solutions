
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

    public Money plus(Money addition) {
        Money newMoney = new Money(this.euros + addition.euros(), this.cents + addition.cents());
        return newMoney;
    }

    public boolean lessThan(Money compared) {
        // First check if euros are less
        if (compared.euros > this.euros) {
            return true;
        } else if (compared.euros < this.euros) {
            return false;
        } else {
           // Check cents
           return compared.cents > this.cents;
        }

    }
    
    public Money minus(Money decreaser) {
        // First check if decreaser is larger
        if (decreaser.euros > this.euros) {
            return new Money(0, 0);
        }
        int cents = 0;
        int euros = this.euros;
        
        int centDifference = this.cents - decreaser.cents;

        
        if (centDifference >= 0) {
            cents = this.cents - decreaser.cents;
        } else {
            // Take 1 euro as well because centDifference is larger than 0
            cents = 100 - Math.abs(centDifference);
            euros--;
        }
        
        if (euros > 0) {
            euros -= decreaser.euros;
        } else {
            euros = 0;
            cents = 0;
        }
        return new Money(euros, cents);
    }

}
