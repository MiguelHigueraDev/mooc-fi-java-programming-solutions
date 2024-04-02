
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Points("12-04.1 12-04.2")
public class ListTest {

    @Test
    public void noTests() {

    }

    @Test
    public void sizeOneElement() {
        List<String> list = new List<>();
        list.add("Hello");
        assertEquals(1, list.size());
    }

    @Test
    public void sizeThreeElements() {
        List<String> list = new List<>();
        list.add("Hello");
        list.add("How");
        list.add("Are you doing");
        assertEquals(3, list.size());
    }

    @Test
    public void contains() {
        List<Integer> list = new List<>();
        list.add(42);
        assertTrue(list.contains(42));
    }

    @Test
    public void doesntContain() {
        List<Integer> list = new List<>();
        list.add(42);
        assertFalse(list.contains(84));
    }
    
    @Test
    public void removeOneElement() {
        List<Double> list = new List<>();
        list.add(0.2);
        list.add(0.3);
        list.add(1.2);
        list.remove(0.2);
        assertEquals(2, list.size());
    }
    
    @Test
    public void getValue() {
        List<String> list = new List<>();
        list.add("Misfit");
        list.add("Inadaptado");
        String word = list.value(1);
        assertEquals(word, "Inadaptado");
    }
    
    @Test
    public void getIndexOfValue() {
        List<Integer> list = new List<>();
        for (int i = 0; i < 4; i++) {
            list.add(i + 1);
        }
        int index = list.indexOfValue(4);
        assertEquals(index, 3);
    }
    
    @Test
    public void getIndexOfValueDoesntExist() {
        List<String> list = new List<>();
        list.add("Test");
        list.add("Prueba");
        int index = list.indexOfValue("Prova");
        assertEquals(index, -1);
    }

}
