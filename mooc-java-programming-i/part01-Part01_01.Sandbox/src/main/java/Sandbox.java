
import java.lang.reflect.Field;
import java.util.Scanner;
import sun.misc.Unsafe;

public class Sandbox {

    public static void main(String[] args) throws NoSuchFieldException {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            System.out.println(unsafe.toString());
        } catch (IllegalAccessException ex) {
            System.out.println("asd");
        }

    }
}
