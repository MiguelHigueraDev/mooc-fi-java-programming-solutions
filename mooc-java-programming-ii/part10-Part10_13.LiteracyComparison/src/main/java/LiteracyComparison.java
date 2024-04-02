
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LiteracyComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            List<LiteracyLevel> rows = new ArrayList<>();
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.trim())
                    .map(line -> line.split(","))
                    .forEach(line -> rows.add(new LiteracyLevel(line[3], Integer.valueOf(line[4]), line[2], Double.valueOf(line[5]))));
            
            Collections.sort(rows, (l1, l2) -> Double.compare(l1.getPercentage(), l2.getPercentage()));
            rows.forEach(row -> System.out.println(row));
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
