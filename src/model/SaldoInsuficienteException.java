package model;
/**
 * Excepción que se lanza cuando el saldo es insuficiente para realizar una operación
 * @author Juan José Argüello
 * @version 1.0
 */

public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException(String mensaje){
        super(mensaje);
    }
}
