
package interfaces;

import com.equipo1.excepciones.ListException;

/** IDoubleList.java
 * 
 *Esta imterfaz generica establece los metodos que deberá llevar
 * una clase que utilice una lista doblemente enlazada
 * 
 * @param <T> El tipo del objeto que se almacenará en la lista
 * 
 * @author Karla Flores - 
 */
public interface IDoubleList <T> extends IList<T> {
    
    
    /**
     * Regresa el indice del ultimo elemento que coincida con el proporcionado
     * o -1 en caso de que no exista
     * @param o Elemento que se buscara en la lista
     * @return regresa el indice del ultimo elemento que coincida o -1 en caso de que no exista
     */
    int lastIndexOf(T o);
    
    /**
     * Elimina el ultimo elemento que coincida con el que fue proporcionado
     * @param o elemento a eliminarse
     * @return true si el elemento existe, false en caso contrario
     * @throws ListException si la lista se encuentra vacia
     */
    boolean removeLast(T o) throws ListException;
}
