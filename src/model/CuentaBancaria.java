package model;
import javax.swing.JOptionPane;

/**
 * Clase abstracta que representa una cuenta bancaria
 * @author Juan José Argüello
 * @version 1.0
 */
public abstract class CuentaBancaria{
    //atributos: 
    protected double saldo; 
    protected int numCuenta; 
    protected String titular;

    //constructor: 
    public CuentaBancaria(int numCuenta, String titular){
        this.saldo = 0; 
        this.numCuenta = numCuenta; 
        this.titular = titular;
    }


    //métodos: 
    /**
     * Calcula el interés de la cuenta
     * @return El interés calculado
     */
    public abstract double calcularInteres();   


    /**     * Deposita un monto en la cuenta
     * @param deposito Monto a depositar
     * @throws OperacionInvalidaException Si el monto es inválido
     */
    public void depositar(double deposito) throws OperacionInvalidaException{
        if (deposito<=0) throw new OperacionInvalidaException("Monto inválido para deposito");
        saldo += deposito;
        JOptionPane.showMessageDialog(null, "Depósito exitoso\nNuevo saldo: "+saldo);
    }


    /**
     * Retira un monto de la cuenta
     * @param retiro Monto a retirar
     * @throws SaldoInsuficienteException Si el saldo es insuficiente
     */
    public abstract void retirar(double retiro) throws SaldoInsuficienteException;



    /**
     * Obtiene el número de cuenta
     * @return Número de cuenta
     */
    public int getNumCuenta() {
        return numCuenta;
    }



    


}
