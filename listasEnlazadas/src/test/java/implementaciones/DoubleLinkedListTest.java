
package implementaciones;

import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** DoubleLinkedListTest.java
 * 
 * Esta clase se utilizara para poner a prueba los metodos creados anteriormente 
 * en la clase DoubleLinkedTest.java
 *
 * @author Karla Paola Flores Lopez - 00000267460
 */
public class DoubleLinkedListTest {
    
    public DoubleLinkedListTest() {
    }

    @Test
    public void appendTest() {
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        
        lista.append("Karlita Bonita");
        lista.append("Louis Tomlinson");
        
        String exp = "[Karlita Bonita, Louis Tomlinson]";
        String result = lista.toString();
        assertEquals(exp, result);
        
    }
    
    @Test
    public void insertTest() {
        DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();
        
        lista.append(1);
        lista.append(2);
        lista.append(3);
        lista.append(5);
        
        lista.insert(4, 3);
        lista.insert(0, 0);
        lista.insert(6, 6);
        
        String exp = "[0, 1, 2, 3, 4, 5, 6]";
        String result = lista.toString();
        assertEquals(exp, result);
        
    }
    
    @Test
    public void getTest() {
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        
        lista.append("Harry Styles");
        lista.append("Louis Tomlinson");
        lista.append("Zayn Malik");
        lista.append("Niall horan");
        lista.append("Liam Payne");
        
        String exp = "Louis Tomlinson";
        String result = lista.get(1);
        assertEquals(exp, result);
        
    }
    
    @Test
    public void removeTest() {
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        
        lista.append("Harry Styles");
        lista.append("Louis Tomlinson");
        lista.append("Zayn Malik");
        lista.append("Niall horan");
        lista.append("Liam Payne");
        
        String result = lista.remove(2);
        String exp = "Zayn Malik";
        
        assertEquals(exp, result);
        System.out.println(lista.toString());
        
    }
    
    @Test
    public void emptyTest() {
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        
        lista.append("Sandia");
        lista.remove(String.valueOf("Sandia"));
        
        boolean result = lista.empty();
        assertTrue(result);
        
    }
    
    @Test
    public void testSize() {
        DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();
        
        lista.append(10);
        lista.append(20);
        lista.append(30);
        lista.append(40);
        
        int exp = 4;
        int result = lista.size();
        
        assertEquals(exp, result);
        
    }
    
    @Test
    public void testIterator() {
        DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();
        
        lista.append(10);
        lista.append(20);
        lista.append(30);
        lista.append(40);
        
        Iterator<Integer> iterador = lista.iterator();
        
        while (iterador.hasNext()) {            
            Integer elem = iterador.next();
            System.out.println(elem);
        }
        
    }
    
    @Test
    public void testLastIndexOf() {
        DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();
        
        lista.append(9);
        lista.append(8);
        lista.append(7);
        lista.append(6);
        lista.append(9);
        lista.append(2);
        lista.append(3);
        
        int exp = 4;
        int result = lista.lastIndexOf(9);
        assertEquals(exp, result);
        
    }
    
    @Test
    public void removeLast() {
        DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();
        
        lista.append(9);
        lista.append(8);
        lista.append(7);
        lista.append(6);
        lista.append(9);
        lista.append(2);
        lista.append(3);
        
       boolean result = lista.removeLast(9);
        assertTrue(result);
        
    }
    
    @Test
    public void setTest() {
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        
        lista.append("1");
        lista.append("2");
        lista.append("3");
        lista.append("7");
        lista.append("5");
        
        lista.set("4", 3);
        
        String exp = "[1, 2, 3, 4, 5]";
        String result = lista.toString();
        
        assertEquals(exp, result);
        
    }
    
}
