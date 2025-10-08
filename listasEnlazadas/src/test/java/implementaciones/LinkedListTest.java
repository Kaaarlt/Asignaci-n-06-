package implementaciones;

import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**LinkedListTest.java
 * 
 * Clase para probar los metodos de la clase LinkedTest
 *
 * @author Equipo 1
 */
public class LinkedListTest {
    
    public LinkedListTest() {
    }
    
    @Test
    public void testAppend(){
        LinkedList<Integer> lista = new LinkedList<>();
        
        lista.append(10);
        lista.append(20);
        lista.append(40);
         lista.append(30);
        
        String exp = "[10, 20, 40, 30]";
        String result = lista.toString();
        assertEquals(exp, result);
        
    }
    
    @Test
    public void testInsert(){
        LinkedList<Integer> lista = new LinkedList<>();
        
        lista.append(10);//0
        lista.append(20);//1
        lista.append(40);//2
        lista.append(30);//3
        
        lista.insert(30, 0);
        
        String exp = "[30, 10, 20, 40, 30]";
        String result = lista.toString();
        assertEquals(exp, result);
        
    }
    
    @Test
    public void testGet(){
         LinkedList<Integer> lista = new LinkedList<>();
         
        lista.append(10);//0
        lista.append(20);//1
        lista.append(40);//2
        lista.append(30);//3
        
        int result = lista.get(2);
        int exp =40;
        assertEquals(exp, result);
         
    }
    
    @Test
    public void testRemove(){
        LinkedList<Integer> lista = new LinkedList<>();
        
        lista.append(10);//0
        lista.append(20);//1
        lista.append(40);//2
        lista.append(30);//3
        
        lista.remove(0);
        int expSize = 3;
        int resultSize = lista.size();
        assertEquals(expSize, resultSize);
        
        String exp = "[20, 40, 30]";
        String result = lista.toString();
        assertEquals(exp, result);
        
    }
    
    @Test
    public void testEmpty() {
        LinkedList<String> lista = new LinkedList<>();
        LinkedList<String> lista1 = new LinkedList<>();
        
        boolean exp = lista.empty();
        assertTrue(exp);
        
        lista1.append("Hola");
        boolean exp1 = lista1.empty();
        assertFalse(exp1);
        
    }
    
    @Test
    public void testSize() {
        LinkedList<String> lista = new LinkedList<>();
        
        lista.append("Hola1");
        lista.append("Hola2");
        lista.append("Hola3");
        lista.append("Hola4");
        
        int exp = 4;
        int result = lista.size();
        assertEquals(exp, result);
        
    }
    
    @Test
    public void testIterator() {
        LinkedList<String> lista = new LinkedList<>();
        
        Iterator result = lista.iterator();
        assertNotNull(result);
        
    }
    
    @Test
    public void testToString() {
        LinkedList<String> lista = new LinkedList<>();
        
        lista.append("H");
        lista.append("O");
        lista.append("L");
        lista.append("A");
        
        String exp = "[H, O, L, A]";
        String resul = lista.toString();
        assertEquals(exp, resul);
        
    }
    
    @Test
    public void testClear() {
        LinkedList<String> lista = new LinkedList<>();
        
        lista.append("H");
        lista.append("O");
        lista.append("L");
        lista.append("A");
        
        lista.clear();
        
        int exp = 0;
        int resul = lista.size();
        assertEquals(exp, resul);
        
    }
    
    @Test
    public void testIndexOf() {
        LinkedList<String> lista = new LinkedList<>();
        
        lista.append("H");
        lista.append("O");
        lista.append("L");
        lista.append("A");
        
        int exp = 2;
        int resul = lista.indexOf("L");
        assertEquals(exp, resul);
    }
    
    @Test
    public void testRemove2() {
        LinkedList<String> lista = new LinkedList<>();
        
        lista.append("H");
        lista.append("O");
        lista.append("L");
        lista.append("A");
        
        lista.remove("L");
        
        String exp = "[H, O, A]";
        String resul = lista.toString();
        assertEquals(exp, resul);
    }
    
}
