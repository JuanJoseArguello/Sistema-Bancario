package model;

import javax.swing.JOptionPane;

import controller.EscritorDepositos;
import controller.EscritorRetiros;

/**
 * Clase que representa una cuenta de ahorros
 * @author Juan José Argüello
 * @version 1.0
 */

public class CuentaAhorros extends CuentaBancaria{

    public double intereses =0.1;
    public CuentaAhorros(int numCuenta,String titular){
        super(numCuenta, titular);
    }

    @Override
    public double calcularInteres() {
        saldo = saldo*intereses; 
        return 0;
    }

    
    @Override
    public void retirar(double retiro) throws SaldoInsuficienteException {
        if (saldo < retiro) {
            throw new SaldoInsuficienteException("Saldo insuficinte");
        }
        saldo -= retiro; 
        JOptionPane.showMessageDialog(null, "Se han retirado $"+retiro+"\nNuevo saldo: "+saldo);
        EscritorRetiros.escribirRetiros("src/persistence/retiros.csv", titular, retiro,"Cuenta Ahorros");
    }

    @Override
    public void depositar(double deposito) throws OperacionInvalidaException {
        super.depositar(deposito);
        EscritorDepositos.escribirDepositos("src/persistence/depositos.csv", titular, deposito, "Cuenta de Ahorros");
    }

    @Override
    public int getNumCuenta() {
        return super.getNumCuenta();
    }

    

    
}