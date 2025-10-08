package implementaciones;

import com.equipo1.excepciones.ListException;
import interfaces.IDoubleList;
import java.util.Iterator;

/**DoubleLinkedList.java
 * Esta clase generica implementa la funcion de una lista doblemente enlazada con la ayuda de una clase miembro
 * de nombre nodo
 *
 * @author Karla Paola Flores Lopez - 00000267460
 * @param <T> el tipo de variable que se utilizara
 */
public class DoubleLinkedList <T> implements IDoubleList<T>,  Iterable<T> {
    
    private NodoDoble<T> inicio;
    private NodoDoble<T> ultimo;
    private int numElementos;
    
    /**
     * Este metodo devuelve el  indice del ultimo elemento que coincide con el proporcionado
     * @param o el ellemento al cual se le buscara el indice
     * @return el indice del elemento, -1 en caso de que no exista
     */
    @Override
    public int lastIndexOf(T o) {
       NodoDoble<T> nodo = ultimo;
       
       
        for (int i = numElementos-1; i >=0; i--) {
            if (nodo.dato.equals(o)) {
                return i;
            }
            nodo = nodo.anterior;
        }
       return -1;
    }
    
    /**
     * Este metodo remueve el ultimo elemento que coincida con el proporcionado
     * 
     * @param o elemento que se eliminara
     * @return true en caso de que exista el elemento en la lista, false en caso de que no
     */
    @Override
    public boolean removeLast(T o) {
       
        NodoDoble<T> nodo = ultimo;
        
        while (nodo != null) {            
            if (nodo.dato.equals(o)) {
                if (nodo.anterior != null) {
                    nodo.anterior.siguiente = nodo.siguiente;
                } else {
                    inicio = nodo.siguiente;
                }
                
                if (nodo.siguiente != null) {
                    nodo.siguiente.anterior = nodo.anterior;
                } else {
                    ultimo = nodo.anterior;
                }
                
                numElementos--;
                return true;
            }
            nodo = nodo.anterior;
        }
        
        return false;
    }
    
    /**
     * Este metodo reemplaza el elemento del indice indicado
     * 
     * @param o elemento que reemplazara
     * @param i indice que se busca reemplazar
     * @throws ListException en caso de que el indice sea menor a cero o mayor a size()
     */
    
    @Override
    public void set(T o, int i) throws ListException {
        NodoDoble<T> nodo = inicio;
        
        if (i < 0 || i > numElementos) {
            throw new ListException("Error: Indice fuera de los limites");
        }
        
        for (int j = 0; j < i; j++) {
            nodo = nodo.siguiente;
        }
        
        nodo.dato=o;
    }

    /**
     * Este metodo devuelve el indice del primer elemento que se busca
     * @param o elemento que se esta buscando
     * @return indice del elemento, -1 en caso de que no exista
     */
    @Override
    public int indexOf(T o) {
        NodoDoble<T> nodo = inicio;
        
        for (int i = 0; i < numElementos; i++) {
            if (nodo.dato.equals(o)) {
                return i;
            }
            nodo = nodo.siguiente;
        }
        return -1;
    }
    
    /**
     * Este Metodo Permite eliminar la lista
     */
    @Override
    public void clear() {
       inicio = null;
       ultimo = null;
       numElementos=0;
    }
    
    /**
     * Este metodo elimina el primer elemento que coincida con el indicado
     * 
     * @param o elemento que se busca eliminar
     * @return true en caso de que exista, false en caso contrario
     * @throws ListException en caso de que la liste se encuentre vacia
     */
    @Override
    public boolean remove(T o) throws ListException {
       NodoDoble<T> nodo = inicio;
       
        if (inicio == null) {
            throw new ListException("La lista se encuentra vacia");
        }
       
        while(nodo != null) {
            if (nodo.dato.equals(o)) {
                if (nodo.anterior != null) {
                    nodo.anterior.siguiente = nodo.siguiente;
                } else {
                    inicio = nodo.siguiente;
                }
                
                if (nodo.siguiente != null) {
                    nodo.siguiente.anterior = nodo.anterior;
                } else {
                    ultimo = nodo.anterior;
                }
                numElementos--;
                return true;
                
            }
            nodo = nodo.siguiente;
        }
        return false;
    }
    
    /**
     * La clase representa el nodo de una llista doblemente enlazada
     * @param <T> tipo de dato generico el cual se almacenara
     */
    private class NodoDoble<T> {
        private T dato;
        private NodoDoble<T> anterior;
        private NodoDoble<T> siguiente;
        
        /**
         * Inicializa el atributo de dato con el valor del parametro del constructor
         * @param dato El Dato que se almacenara
         */
        
        private NodoDoble(T dato) {
            this.dato = dato;
        }
    }// Fin nodo doble
    
    private class ListIterator<T> implements Iterator<T> {
        private NodoDoble<T> nodoActual;
        
        public ListIterator (NodoDoble<T> inicio) {
            nodoActual = inicio;
        }
        
        /**
         * Determina si el iterador tiene otro elemento por recorrer
         * @return true si tiene otro elemento que regresar, false en caso de que no
         */
        @Override
        public boolean hasNext() {
            return nodoActual != null;
        }
        
        /**
         * Da una referencia al siguiente elemento de la coleccion y avanza de posicion el iterador
         * @return Una referencia al siguiente elemento
         * @throws La excepcion NoSuchElementException si no tiene mas elementos que regresar
         */
        @Override
        public T next() {
            T dato = nodoActual.dato;
            nodoActual = nodoActual.siguiente;
            
            return dato;
        }
    }// Fin ListIterator
    
    /**
     * Inicializa los valores de la lista, el inicio, final y la cantidad de elementos
     */
    
    public DoubleLinkedList() {
        inicio = null;
        ultimo = null;
        numElementos = 0;
    }
    
    /**
     * Inserta un elemento al final de la coleccion
     * @param o elemento que se desea agregar a la coleccion
     */
    @Override
    public void append(T o) {
        NodoDoble<T> nodoNuevo = new NodoDoble<>(o);
        
        if (inicio == null) {
            //En caso de que la lista este vacia
            inicio = nodoNuevo;
        } else {
            // Agrega el nodo nuevo al final de la lista
            ultimo.siguiente = nodoNuevo;
            nodoNuevo.anterior = ultimo;
        }
        ultimo = nodoNuevo;
        numElementos++;
    }
    
    /**
     * Inserta un elemento en la posicion i dada
     * @param o elemento a insertar
     * @param i indice en el cual se insertara
     * @throws ListException Si es que i es menor a cero o mayor a size()
     */
    @Override
    public void insert(T o, int i) throws ListException {
        NodoDoble<T> nodoNuevo = new NodoDoble<>(o);
        
        if (i < 0 || i > numElementos) {
            throw new ListException("Error: Indice fuera de los limites");
        }
        //Si se inserta el elemento al inicio de la lista
        if( i == 0) {
            if (inicio == null) {
                //Si es que la lista se encuentra vacia
                ultimo = nodoNuevo;
            } else {
                //conecta el nodo nuevo a la lista
              nodoNuevo.siguiente = inicio;
              inicio.anterior = nodoNuevo;
            }
            //El nodo nuevo es el primero de la lista
             inicio = nodoNuevo;
        } else {
            // Para inserta el elemento en la posicion i de la lista
            NodoDoble<T> nodo = inicio;
            
            //Se debe recprrer hasta el nodo anterior al punto donde se insertara
            for (int j = 0; j < i-1; j++) {
                nodo = nodo.siguiente;
            } 
            //Agrega la lista en el lado derecho de donde se insertara el elemento
            nodoNuevo.siguiente = nodo.siguiente;
            
            if (nodoNuevo.siguiente != null) {
                //En caso de que el nodo insertado no sea el ultimo
                nodoNuevo.siguiente.anterior = nodoNuevo;
            } else {
                //En caso de que el nodo insertado sea el ultimo
                ultimo = nodoNuevo;
            }
            nodoNuevo.anterior = nodo;
            nodo.siguiente = nodoNuevo;
        }
        numElementos++;
    }
    
    /**
     * Regresa el elemento en el indice i
     * @param i indice que se extraera
     * @return el elemento en el indice buscado
     * @throws ListException en caso de que la lista este vacia o el indice sea menor a cero y mayor a size()
     */
    @Override
    public T get(int i) throws ListException {
        if (empty()) {
            throw new ListException("La lista se encuentra vacia");
        }
        
        if (i < 0 || i >= numElementos) {
            throw new ListException("Indice fuera de limites");
        }
        
        NodoDoble<T> nodo = inicio;
        for (int j = 0; j < i; j++) {
            nodo = nodo.siguiente;
        }
        return nodo.dato;
    }
    
    /**
     * Este metodo elimina el elemento en el indice i
     * @param i indice del elemento que se eliminara
     * @return elemento que se elimino
     * @throws ListException en caso de que la lista se encuentre vacia, o que i sea menor a cero y mayor o igual a size()
     */
    @Override
    public T remove(int i) {
        T o;
        
        if (empty()) {
            throw new ListException("La lista se encuentra vacia");
        }
        
        if (i < 0 || i >= numElementos) {
            throw new ListException("El indice esta fuera de los limites");
        }
        
        if (i == 0) {
            //El dato a eliminar es el del inicio
            o = inicio.dato;
            inicio = inicio.siguiente; //Se quita el elemento al inicio de la lista
            
            if (inicio != null) {
                //Si la lista no se encuentra vacia
                inicio.anterior = null;
            } else {
                //Si la lista se encuentra vacia
                ultimo = null;
            }
        } else {
            NodoDoble<T> nodo = inicio;
            //Se apunta al nodo anterior al cual se desea eliminar
            for (int j = 0; j < i-1; j++) {
                nodo = nodo.siguiente;
            }
            //Dato que se eliminara
            o = nodo.siguiente.dato;
            //Se quita el elemento que se borrara de la lista
            nodo.siguiente = nodo.siguiente.siguiente;
            
            if (nodo.siguiente != null) {
                //En caso de no ser el ultimo nodo de la lista, al nodo anterior all que se elimina, se asigna en el nodo
                // siguiente del que se ellimino
                nodo.siguiente.anterior = nodo;
            } else {
                ultimo = nodo;
            }
            
        }
        numElementos--;
        
        //Se regresa el elemento que se ellimino
        return o;
    }
    
    /**
     * Este metodo te indica si la lista se encuentra vacia
     * @return true en caso de que este vacia, false en caso contrario
     */
    @Override
    public boolean empty() {
        return numElementos == 0;
    }
    
    /**
     * Regresa el numero de elementos en la lista
     * @return 
     */
    @Override
    public int size() {
        return numElementos;
    }
    
    /**
     * Regresa un iterador de esta lista
     * @return un iterador de la lista
     */
    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedList.ListIterator(inicio);
    }
    
    /**
     * Este metodo regresa la lista en forma de una cadena de texto
     * @return cadena de texto de los elementos de la lista
     */
    @Override
    public String toString() {
        String o = "[";
        NodoDoble<T> nodo = inicio;
        
        while (nodo != null) {            
            o += nodo.dato;
            if (nodo.siguiente != null) {
                o += ", ";
            }
            nodo = nodo.siguiente;
        }
        o += "]";
        return o;
    }
    
}
