package model;

import javax.swing.JOptionPane;

import controller.EscritorDepositos;
import controller.EscritorRetiros;

/**
 * Clase que representa una cuenta empresarial
 * @author Juan José Argüello
 * @version 1.0
 */

public class CuentaEmpresarial extends CuentaBancaria{
    private static double limiteRetiro=500000; 

    public CuentaEmpresarial(int numCuenta,String titular){
        super(numCuenta, titular);
    }

    @Override
    public double calcularInteres() {
        return 0;
    }


    /**     * Retira un monto de la cuenta
     * @param retiro Monto a retirar
     * @throws SaldoInsuficienteException Si el saldo es insuficiente
     */
    @Override
    public void retirar(double retiro) throws SaldoInsuficienteException {
        if (retiro>saldo) {
            throw new SaldoInsuficienteException("Saldo Insuficiente"); 
        }
        if (retiro>limiteRetiro) {
            JOptionPane.showMessageDialog(null,"No puede exceder el límite de retiro ($500000)");
        }else{
            saldo -=retiro; 
            JOptionPane.showMessageDialog(null, "Retiro exitoso\nNuevo saldo: "+saldo);
        }
        EscritorRetiros.escribirRetiros("src/persistence/retiros.csv", titular, retiro,"Cuenta Empresarial");
        
    }


    /**
     * Deposita un monto en la cuenta
     * @param deposito Monto a depositar
     * @throws OperacionInvalidaException Si el monto es inválido
     */
    @Override
    public void depositar(double deposito) throws OperacionInvalidaException {
        super.depositar(deposito);
        EscritorDepositos.escribirDepositos("src/persistence/depositos.csv", titular, deposito,"Cuenta Empresarial");
    }

    @Override
    public int getNumCuenta() {
        return super.getNumCuenta();
    }

    
    
    
}
