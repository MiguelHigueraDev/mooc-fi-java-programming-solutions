
public class MainProgram {

    public static void main(String[] args) {
        Money a = new Money(10, 0);
        Money b = new Money(3, 0);
        Money c = new Money(5, 0);

        System.out.println(a.lessThan(b));  // false
        System.out.println(b.lessThan(c));  // true
        Money firstMoneyObject = new Money(1, 0);
        Money secondMoneyObject = new Money(1, 50);
        Money thirdMoneyObject = new Money(-3, 5);
        Money fourthMoneyObject = new Money(2, 0);
        boolean test = firstMoneyObject.lessThan(thirdMoneyObject);
        boolean test2 = fourthMoneyObject.lessThan(secondMoneyObject);
        System.out.println(test2);
    }
}
