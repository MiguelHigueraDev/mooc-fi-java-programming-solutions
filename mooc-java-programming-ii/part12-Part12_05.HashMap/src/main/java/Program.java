
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here
        HashMap<String, String> map = new HashMap<>();
        map.add("test", "testa");
        String test = map.get("test");
        map.add("caca", "cacacac");
        map.add("key", "value");
        System.out.println(test);
        System.out.println(map.get("acac"));
        System.out.println(map.get("caca"));
        map.remove("caca");
        System.out.println(map.get("caca"));
    }

}
