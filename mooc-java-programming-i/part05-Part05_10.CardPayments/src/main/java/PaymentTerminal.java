
public class PaymentTerminal {

    private double money;  // amount of cash
    private int affordableMeals; // number of sold affordable meals
    private int heartyMeals;  // number of sold hearty meals

    public PaymentTerminal() {
        // register initially has 1000 euros of money
        this.money = 1000;
    }

    public double eatAffordably(double payment) {
        // an affordable meal costs 2.50 euros
        // increase the amount of cash by the price of an affordable mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        double price = 2.50;
        if (price > payment) {
            return payment;
        } else {
            double change = payment - price;
            this.money -= change;
            this.money += payment;
            this.affordableMeals++;
            return change;
        }

    }

    public double eatHeartily(double payment) {
        // a hearty meal costs 4.30 euros
        // increase the amount of cash by the price of a hearty mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        double price = 4.30;
        if (price > payment) {
            return payment;
        } else {
            double change = payment - price;
            this.money -= change;
            this.money += payment;
            this.heartyMeals++;
            return change;
        }
    }

    public boolean eatAffordably(PaymentCard card) {
        double price = 2.50;
        if (price > card.balance()) {
            return false;
        } else {
            card.takeMoney(price);
            this.affordableMeals++;
            return true;
        }
    }

    public boolean eatHeartily(PaymentCard card) {
        double price = 4.30;
        if (price > card.balance()) {
            return false;
        } else {
            card.takeMoney(price);
            this.heartyMeals++;
            return true;
        }
    }
    
    public void addMoneyToCard(PaymentCard card, double sum) {
        if (sum < 0) return;
        this.money += sum;
        card.addMoney(sum);
    }

    @Override
    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}
