package model;
/**
 * Excepción que se lanza cuando se intenta realizar una operación inválida
 * @author Juan José Argüello
 * @version 1.0
 */

public class OperacionInvalidaException extends Exception {
    public OperacionInvalidaException(String mensaje){
        super(mensaje); 
    }
}
