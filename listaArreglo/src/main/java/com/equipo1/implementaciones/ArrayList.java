
package com.equipo1.implementaciones;

import com.equipo1.excepciones.ListException;
import interfaces.IList;
import java.util.Iterator;

/**
 * Array.java
 * Esta clase generica implementa una lista sobre un arreglo
 * 
 * 
 * @author Karla Flores
 * @param <T> Tipo de elementos que se almacenaran en la lista
 */
public class ArrayList <T> implements IList<T>, Iterable<T> {
    int nElementos;
    int tamLista;
    T lista[];
    
    
    /**
     * Este metodo pone el objeto indicado en el indice  que se desea
     * @param o objeto que se desea agregar
     * @param i indice en el que se agregara
     * @throws ListException en caso de la lista estar llena o que el indice este fuera de los limites
     */
    @Override
    public void set(T o, int i) throws ListException {
        if(i < 0 || i >=nElementos) throw new ListException("Indice fuera de los limites");
          
        lista[i] = o;
    }
    
    
    /**
     * Este metodo permite eliminar el primer elemento encontrado que sea simillar al buscado
     * @param o elemento que se desea eliminar
     * @return true si existia y se elimino, false en caso contrario
     * @throws ListException en caso de que la llista este vacia
     */
    @Override
    public boolean remove(T o) throws ListException {
         if(empty()) throw new ListException("Lista vacia");
         
         for (int i = 0; i < nElementos; i++) {
            if(lista[i].equals(o)){
                for (int j = i; j < nElementos - 1; j++) {
                    lista[j] = lista[j + 1];
                }
                lista[nElementos -1] = null;
                nElementos--;
                return true;
            }
        }
        return false;
    }

    /**
     * Este metodo te devuelve el indice del primer elemento identico encontrado en la lista
     * @param o objeto del cual se busca el indice
     * @return el indice del elemento encontrado, -1 en caso de que no exista
     */
    @Override
    public int indexOf(T o) {
        for (int i = 0; i < nElementos; i++) {
            if(lista[i].equals(o)) return i;
        }
 
        
        return -1;
    }
    
    /**
     * Este metodo elimina todos los elementos del array
     */
    @Override
    public void clear() {
        for (int i = 0; i < nElementos; i++) {
            lista[i] = null;
        }
        nElementos=0;
    }
    
    /**
     * Esta clase miembro representa un iterador para esta lista
     * @param <T> 
     */
    
    private class ListIterator<T> implements Iterator<T> {
        private int actual = 0;
        
        /**
        * Determina si el iterador tiene otro elemento que regresar
        *
        * @return true si el iterador tiene otro elemento que
        * regresar, false en caso contrario.
        */
        @Override
        public boolean hasNext() {
            return actual < nElementos;
        }
        
        /**
        * Regresa una referencia al siguiente elemento de la
        * colección y avanza el iterador a la siguiente posición.
        *
        * @return Una referencia al siguiente elemento de la
        * colección
        * @throws Una excepción del tipo NoSuchElementException si
        * ya no hay elementos que regresar
        */
        @Override
        public T next() {
            return (T)lista[actual++];
        }
    }
    
    /**
    * Constructor de la clase. Crea el arreglo sobre el que se
    * implementa la lista e inicializa nElementos a cero para
    * indicar que la lista inicialmente esta vacia.
    *
    * @param tipoDato Tipo de los elementos que se almacenaran en
    * la lista
    * @param tamLista Tamaño del arreglo sobre el que se implementa
    * la lista
    */
    public ArrayList(Class<T> tipoDato, int tamLista){
        this.tamLista = tamLista;
        nElementos=0;
        lista = (T[]) java.lang.reflect.Array.newInstance(tipoDato, tamLista);
    }
    
    /**
     * Este metodo agrega un elemento al final de la lista
     * @param o elemento a insertar en la lista
     * @throws ListException En caso de que la lista este llena
     */
    @Override
    public void append(T o) throws ListException{
        // Si la lista esta llena, lanza una excepcion
        if(nElementos >= tamLista) throw new ListException("Lista llena");
        
        //Inserta el dato en el nElementos de la lista
        lista[nElementos] = o;
        nElementos++;
        
    }
    
    /**
     *  Inserta un elemento en la posicion dada
     * @param o el objeto que se desea reemplazar
     * @param i el indice en que se agregara el objeto
     * @throws ListException en caso de que la lista este llena o el indice fuera de los limites
     */
    
    @Override
    public void insert(T o, int i) throws ListException{
        //Si la lista esta llena
        if(nElementos >= tamLista) throw new ListException("La lista esta llena");
        
        //Si el indice esta fuera de los limites de la lista
        if(i < 0 || i > nElementos) throw new ListException("Indice fuera de los limites");
        
        for(int j = nElementos; j > i; j--)  lista[j] = lista[j-1];
        lista[i] = o;
        nElementos++;
    }
    
    /**
     * Obtiene el elemento de la lista en el indice i
     * 
     * @param i el indice que desea observarse
     * @return el dato que se encuentre en ese indice
     * @throws ListException en caso de que la lista este vacia o el indice fuera de los limites
     * ya sea i mayor a size() o i menor a 0
     */
    
    @Override
    public T get(int i) throws ListException {
        // Si la lista esta vacia lanza una excepcion
        if (empty()) throw new ListException("Lista vacia");
        
        // Si el indice i esta fuera de los limites de los datos
        if(i < 0 || i >= nElementos) throw new ListException("Indice fuera de limites");
        return lista[i];
}
    
    /**
     * Determina si la lista se encuentra vacia
     * 
     * @return true si la lista esa vacia, false en caso contrario
     */
    
    @Override
    public boolean empty(){
        return nElementos ==0;
    }
    
    /**
     * Extrae el elemento de la lista en la posicion que se dio
     * @param i indice en la lista que se busca eliminar
     * @return el elemento en el indice
     * @throws ListException si la lista esta vacia o si el indice esta fuera del limite
     */
    
        @Override
        public T remove(int i) throws ListException{
            if(empty()) throw new ListException("Lista vacia");
            
            if(i<0 || i>=nElementos) throw new ListException("Indice fuera de los limites");
            T o = get(i);
            
            for(int j = i; j < nElementos - 1; j++)  lista[j] = lista[j+1];
            nElementos--;
            return o;
        }
        
        /**
         * Regresa el numero de elementos en la lista
         * 
         * @return Regresa el numero de elementos en las lista
         */
        @Override
        public int size(){
            return nElementos;
        }
        
        @Override
        public Iterator<T> iterator(){
            return new ListIterator<>();
        }
        
        @Override
        public String toString(){
            String s = "[";
            
            for (int i = 0; i < nElementos; i++) {
                s += lista[i];
                if(i < nElementos -1 ) s +=", ";
            }
            s += "]";
            return s;
        }
}
