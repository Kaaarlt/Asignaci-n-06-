
package implementaciones;

import com.equipo1.excepciones.ListException;
import interfaces.IList;
import java.util.Iterator;

/**LinkedList.java
 * 
 * @author Karla Flores
 * @param <T> Tipo del dato que se almacenara
 * 
 *  esta clase implementa una lista generica sobre una lista enlazada simple
 * 
 * el nodo es una clase miembro
 */
public class LinkedList<T> implements Iterable<T>, IList<T>{
    NodoSimple<T> inicio;
    int nElementos;

    
    /**
     * Este metodo reemplaza el dato de un nodo 
     * @param o el dato con el cual se busca reemplazar
     * @param i indice del nodo que sera reemplazado su valor
     * @throws ListException en caso de que el indice este fuera de los limites o que la lista este vacia
     */
    @Override
    public void set(T o, int i) throws ListException {
        
        if (empty()) {
            throw new ListException("La lista esta vacia");
        }
        
       if (i <  0 || i >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }
       
       NodoSimple<T> nodo = inicio;
        for (int j = 0; j < i; j++) {
            nodo = nodo.sig;
        }
        
       nodo.dato = o;
    }
    
    /**
     * Este metodo remueve el primer elemento que concuerde 
     * @param o elemento que se desea eliminar
     * @return true si el elemento existe en la lista, false en caso contrario
     * @throws ListException 
     */
    @Override
    public boolean remove(T o) throws ListException {
        
        if (empty()) {
            throw new ListException("La lista esta vacia");
        }
        
        NodoSimple<T> nodo = inicio;
        if (inicio.dato.equals(o)) {
            inicio = inicio.sig;
            nElementos--;
            return true;
        }
        
        while(nodo.sig != null) {
            if (nodo.sig.dato.equals(o)) {
                nodo.sig = nodo.sig.sig;
                nElementos--;
                return true;
            }
            nodo = nodo.sig;
        }
        
        return false;
    }
    
    /**
     * Este metodo regresa el indice del elemento que se busca
     * @param o el elemento que se busca su indice
     * @return el indice en caso de que exista el elemento, -1 en caso contrario
     * @throws ListException en caso de que la lista este vacia
     */
    @Override
    public int indexOf(T o) {
        
        if (empty()) {
            throw new ListException("La lista esta vacia");
        }
        NodoSimple<T> nodo = inicio;
        for (int i = 0; i < nElementos; i++) {
            if (nodo.dato.equals(o)) {
                return i;
            }
            nodo = nodo.sig;
        }
        
        return -1;
    }
    
    /**
     * Este metodo se encarga de eliminar toda la lista
     */
    @Override
    public void clear() {
        inicio = null;
        nElementos = 0;
    }
    
    /**
     * Esta clase miembro representa un nodo de una lista enlazada simple
     *   
     */
    private class NodoSimple<T>{
        T dato;
        NodoSimple<T> sig;
        
        /**Inicializa el valor de dato con el valor del parametro
         * 
         * @param dato dato que se almacenara en el nodo
         */
        
        public NodoSimple(T dato){
            this.dato=dato;
        }
    }
    
    /**
     * 
     * Esta clase representa un iterador para esta llista
     */
    private class ListIterator<T> implements Iterator<T>{
        private NodoSimple<T> nodoActual;
        
        
        public ListIterator(NodoSimple<T> inicio){
            nodoActual = inicio;
        }
        
        /**
         * 
         * @return true si el iterador tiene otro elemento que regresar
         */
        @Override
        public boolean hasNext() {
            return nodoActual != null; 
        }
            
        /**
         * Regresa una referencia al siguiente elemento de la coleccion y avanza el iterador a la siguiente posicion
         * 
         * @return Una referencia al siguiente elemento de la coleccion
         * @throws Una excepcion del tipo NoSuchElementException si ya no hay elementos que regresar
         */
        @Override
        public T next() {
            T dato = nodoActual.dato;
            nodoActual = nodoActual.sig;
             return dato;
        } 
    }
    /**
     * Inicializa la referencia al inicio de la lista
     * y el contador de elementos en la lista
     */
    
    public LinkedList() {
        inicio = null;
        nElementos = 0;
    }
    
    /**
     * Inserta un elemento al final de la lista
     * 
     * @param o es el elementop que se desea insertar al final de la lista
     */
    @Override
    public void append(T o){
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);
        NodoSimple<T> nodo = inicio;
        
        if (inicio == null) {
            //Si es que la lista esta vacia
            inicio = nodoNuevo;
        }else{
            //Si la lista no esta vacia, el nodo debe apuntar al ultimo elemento de la lista
            while(nodo.sig != null){
                nodo = nodo.sig;
            }
            nodo.sig = nodoNuevo;
        }
        nElementos++;
    }
    
    /**
     * Inserta un elemento en el indice de la lista indicado
     * @param o elemento que se agregara
     * @param i indice al cual se agregara
     * @throws ListException Si el indice es menor que cero o mayor al numero de elementos
     */
    @Override
    public void insert(T o, int i) throws ListException{
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);
        
        if (i <  0 || i > nElementos) {
            throw new ListException("Indice fuera de limites");
        }
        //Inserta el elemento al inicio de la lista
        if(i == 0){
            if (inicio != null) {
                //Si la lista no esta vacia, agregala detras del nodo nuevo
                nodoNuevo.sig = inicio;
            }
            inicio = nodoNuevo;
        }else{
            //Inserta el elemento en el indice i de la lista
            NodoSimple<T> nodo = inicio;
            //El nodo apunta al nodo anterior de donde se insertara
            for (int j = 0; j < i-1; j++) {
                nodo = nodo.sig;
            }
            //Mueve la lista a la derecha del punto de donde se inserto el elemento
            nodoNuevo.sig = nodo.sig;
            //Agrega el nuevo nodo a la izquiera de donde se inserto el elemento
            nodo.sig = nodoNuevo;
        }
        nElementos++;
        
    }
    
    /**
     * Inspecciona el elemento en la posicion i de la lista sin modificarlo o extraerlo
     * 
     * @param i indice que se desea inspeccionar
     * @return el valor del dato del nodo que se inpecciona
     * @throws ListException si la lista esta vacia o i es menor a cero o mayor e igual al limite de la lista
     */
    @Override
    public T get(int i) throws ListException {
        if (empty()) {
            throw new ListException("La lista se encuentra vacia");
        }
        
        if (i < 0 || i>= nElementos) {
            throw new ListException("Indice fuera de los limites");
        }
        
        NodoSimple<T> nodo = inicio;
        // Nodo debe apuntar al nodo a modificar
        for (int j = 0; j < i; j++) {
            nodo = nodo.sig;
        }
        // Regresa el dato en la posicion i
        return nodo.dato;
    }
    
    /**
     * Extrae el elemento de la posicion i de la lista
     * 
     * @param i posicion del elemento que se eliminara de la lista
     * @return el elemetno en la posicion i que se elimino
     * @throws ListException en caso de que la lista se encuentre vacia o el indice en menor a cero o mayor al numero de elementos
     */
    @Override
    public T remove (int i) throws ListException{
        T o;
        
        if (empty()) {
            throw new ListException("La lista esta vacia");
        }
        
        if (i < 0 || i >= nElementos) {
            throw new ListException("Indice fuera de los limites");
        }
        
        if (i == 0) {
            // Si el nodo que se eliminara al inicio esta al inicio de la lista, obtiene el dato
            o = inicio.dato;
            //Quita el elemento al inicio de la lista
            inicio = inicio.sig;
        } else {
            // Cuando el nodo esta en un indice diferente al inicio
            NodoSimple<T> nodo = inicio;
            //El nodo debe apuntar al indice que busca eliminarse
            for (int j = 0; j < i-1; j++) {
                nodo = nodo.sig;
            }
            
            o = nodo.sig.dato;
            nodo.sig = nodo.sig.sig;
        }
        nElementos--;
        //Regresa el dato que se elimino
        return o;
    }
    /**
     * Determina si la lista esta vacia
     * 
     * @return true si la lista esta vacia, false en caso contrario
     */
    @Override
    public boolean empty(){
        return inicio == null;
    }
    
    /**
     * Regresa el numero de elementos en la lista
     * @return la cantidad de elementos en la lista
     */
    @Override
    public int size(){
        return nElementos;
    }
    
    /**
     * Regresa un iterador para esta lista
     * @return un iterador para esta lista
     */
    @Override
    public Iterator<T> iterator(){
        return new ListIterator(inicio);
    }
    
    /**
     * Genera una cadena con los valores de los elementos de la lista
     * @return 
     */
    @Override
    public String toString() {
        String s = "[";
        NodoSimple<T> nodo = inicio;
        
        while(nodo != null){
            s += nodo.dato;
            if (nodo.sig != null ) {
                s += ", ";
            }
            nodo = nodo.sig;
        }
        s += "]";
        return s;
    }
    
}
