
package com.equipo1.implementaciones;

import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Equipo 1
 */
public class ArrayListTest {
    
    public ArrayListTest() {
    }

    /**
     * Test of set method, of class ArrayList.
     */
    @Test
    public void testSet() {
        ArrayList<String> array = new ArrayList<>(String.class, 4);
        
        array.append("Hola1");
        array.append("Hola2");
        array.append("Hola3");
        
        array.set("Hola4", 2);
        String exp = "[Hola1, Hola2, Hola4]";
        String result = array.toString();
        assertEquals(exp,result);
    }

    /**
     * Test of remove method, of class ArrayList.
     */
    @Test
    public void testRemove_GenericType() {
        ArrayList<String> array = new ArrayList<>(String.class, 5);
        array.append("Erik");
        array.append("Sarai");
        array.append("Karla");
        array.append("Marlenne");
        array.append("Ricardo");
        
        array.remove("Marlenne");
        
        String exp = "[Erik, Sarai, Karla, Ricardo]";
        String resul = array.toString();
        
        assertEquals(exp, resul);
    }

    /**
     * Test of indexOf method, of class ArrayList.
     */
    @Test
    public void testIndexOf() {
         ArrayList<String> array = new ArrayList<>(String.class, 5);
        array.append("Hola1");
        array.append("Hola2");
        array.append("Hola3"); //Index 2
        array.append("Hola4");
        array.append("Hola5");
        
        int exp = 2;
        int result = array.indexOf("Hola3");
        assertEquals(exp, result);
         
    }

    /**
     * Test of clear method, of class ArrayList.
     */
    @Test
    public void testClear() {
        ArrayList<String> array = new ArrayList<>(String.class, 4);
        array.append("Hola1");
        array.append("Hola2");
        array.append("Hola3");
        array.append("Hola4");
        
        array.clear();
        
        String exp = "[]";
        String result = array.toString();
        
        assertEquals(exp,result);
    }

    /**
     * Test of append method, of class ArrayList.
     */
    @Test
    public void testAppend() {
         ArrayList<String> array = new ArrayList<>(String.class, 4);
         array.append("1");
         array.append("2");
         array.append("3");
         array.append("4");
         
         String exp = "[1, 2, 3, 4]";
         String result = array.toString();
         
         assertEquals(exp, result);
    }

    /**
     * Test of insert method, of class ArrayList.
     */
    @Test
    public void testInsert() {
        ArrayList<String> array = new ArrayList<>(String.class, 4);
        array.append("1");
        array.append("3");
        
        array.insert("2", 1);
        array.insert("4", 3);
        
        String exp = "[1, 2, 3, 4]";
        String result = array.toString();
        
        assertEquals(exp, result);
    }

    /**
     * Test of get method, of class ArrayList.
     */
    @Test
    public void testGet() {
        ArrayList<String> array = new ArrayList<>(String.class, 4);
        array.append("1");
        array.append("2");
        array.append("3");
        array.append("4");
        
        String exp = "3";
        String result = array.get(2);
        
        assertEquals(exp, result);
    }

    /**
     * Test of empty method, of class ArrayList.
     */
    @Test
    public void testEmpty() {
        ArrayList<String> array = new ArrayList<>(String.class, 4);
        array.append("1");
        
        boolean result = array.empty();
        boolean exp = false;
        assertEquals(exp, result);
    }

    /**
     * Test of remove method, of class ArrayList.
     */
    @Test
    public void testRemove_int() {
        ArrayList<String> array = new ArrayList<>(String.class, 4);
        array.append("1");
        array.append("2");
        array.append("3");
        array.append("4");
        
        array.remove(1);
        
        String exp = "[1, 3, 4]";
        String result = array.toString();
        
        assertEquals(exp, result);
    }

    /**
     * Test of size method, of class ArrayList.
     */
    @Test
    public void testSize() {
        ArrayList<Integer> array = new ArrayList<>(Integer.class, 4);
        array.append(1);
        array.append(2);
        array.append(3);
        
        int exp = 3;
        int result = array.size();
        
        assertEquals(exp, result);
        
    }

    /**
     * Test of iterator method, of class ArrayList.
     */
    @Test
    public void testIterator() {
        ArrayList<Integer> array = new ArrayList<>(Integer.class, 4);
        array.append(1);
        array.append(2);
        array.append(3);
        
        Iterator<Integer> it = array.iterator();
        
        while (it.hasNext()) {
            Integer elem = it.next();
            System.out.println(elem);
        }
        
    }

    /**
     * Test of toString method, of class ArrayList.
     */
    @Test
    public void testToString() {
        ArrayList<Integer> array = new ArrayList<>(Integer.class, 4);
        array.append(100);
        array.append(101);
        array.append(102);
        array.append(103);
        
        String exp = "[100, 101, 102, 103]";
        String result = array.toString();
        
        assertEquals(exp, result);
    }
    
}
