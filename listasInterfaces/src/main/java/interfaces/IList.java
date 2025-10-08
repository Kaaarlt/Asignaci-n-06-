
package interfaces;

import com.equipo1.excepciones.ListException;
import java.util.Iterator;

    /**
    *
    * @author Karla Flores
    * Los metodos de esta interfaz son los que deben implementarse en un clase por una clase que modele una lista
    *  
    * @param <T> el tipo de de los objeto que se almacenaran en la lista
    */
public interface IList <T>{
    
    /**
     * Inserta un elemento al final de la lista
     * 
     * @param o es el elemento que desea agregarse a la lista
     * @throws ListException en caso de que la lista este llena
     */
    
    public void append(T o) throws ListException;
    
    /**
     * Agrega un elemento a la lista en el indice indicado
     * @param o elemento que se desea agregar a la lista
     * @param i index en donde se agregara el objeto
     * @throws ListException ListException Si la lista esta vacia o si i es menor a 0 o i supera el tamaño de la lista
     */
    
    public void insert(T o, int i) throws ListException;
    
    /**
     * Inspecciona el elemento en la posicion indicada sin necesidad de extraerlo
     * @param i indice que se desea inspeccionar
     * @return el elemento que se encuentra en el indice
     * @throws ListException Si la lista esta vacia o si i es menor a 0 o i supera el tamaño de la lista
     */
    public T get(int i) throws ListException;
    
    /**
     * Remueve el elemento del indice indicado
     * @param i indice del elemento que se desea remover
     * @return el elemento que se elimino del indice
     * @throws ListException Si la lista esta vacia o si i es menor a 0 o i supera el tamaño de la lista
     */
    public T remove(int i) throws ListException;
    
    /**
     * Comprueba si la lista se encuentra vacia
     * @return true si la lista esta vacia, false en caso contrario
     */
    
    public boolean empty();
    
    /**
     * 
     * @return Regresa el numero de elementos en la lista
     */
    public int size();
    
    /**
     * Regresa un iterador para esta lista
     * @return Un interador para esta lista
     */
    public Iterator<T> iterator();
    
    /**
     * reemplaza el elemento que se encuentra en la
     * posición i de la lista por el objeto del parámetro.
     * @param o el elemento que será de reemplazo
     * @param i el indice en el cual se busca reemplazar
     * @throws ListException Si la lista esta vacia o si i es menor a 0 o i supera el tamaño de la lista
     */
    void set(T o, int i) throws ListException;
    
    /**
     * Elimina el primer elemento que concuerde con el indicado
     * @param o elemento que se buscara eliminar
     * @return true si el elemento existe en la lista, false en caso contrario
     * @throws ListException Si la lista esta vacia
     */
    boolean remove(T o) throws ListException;
    
    /**
     * Regresa el indice del primer elemento de la lista que concuerde con el dado
     * @param o el objeto que se desea buscar
     * @return -1 en caso de que no exista
     */
    int indexOf(T o);
    
    /**
     * Elimina todos elementos de la lista
     */
    void clear();
    
}