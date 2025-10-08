
package com.equipo1.excepciones;

/** ListException.java
 *
 * @author Karla Flores
 * 
 *  Esta clase de excepcion sera implementada en las clases que implementan
 *  la interfaz IList
 * 
 *
 */
public class ListException extends RuntimeException {
    
        /**
         * Este es el constructor vacio en caso de que no se describa la excepcion que se desea lanzar
         */
     public ListException() {
            super();
        }
    
        /**
        * 
         * @param exc es la descripcion del motivo por cual se provoca la excepcion
        */
        public ListException(String exc) {
            super(exc);
        }
}
