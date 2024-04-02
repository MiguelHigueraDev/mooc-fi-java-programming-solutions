
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Divisible {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(-17);
        numbers.add(-5);
        numbers.add(7);

        ArrayList<Integer> divisible = divisible(numbers);

        divisible.stream()
                .forEach(luku -> System.out.println(luku));
    }

    public static ArrayList<Integer> divisible(ArrayList<Integer> numbers) {
        ArrayList<Integer> divisible = numbers.stream()
                .filter(Divisible::divisibleByTwoThreeOrFive)
                .collect(Collectors.toCollection(ArrayList::new));
        return divisible;
    }

    public static boolean divisibleByTwo(int number) {
        return number % 2 == 0;
    }

    public static boolean divisibleByThree(int number) {
        return number % 3 == 0;
    }

    public static boolean divisibleByFive(int number) {
        return number % 5 == 0;
    }
    
    public static boolean divisibleByTwoThreeOrFive(int number) {
        return divisibleByTwo(number) || divisibleByThree(number) || divisibleByFive(number);
    }
}
