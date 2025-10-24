package model;

import javax.swing.JOptionPane;

import controller.EscritorDepositos;
import controller.EscritorRetiros;

public class CuentaCorriente extends CuentaBancaria{
    private static double comisionFija = 1500;

    public CuentaCorriente(int numCuenta,String titular){
        super(numCuenta, titular);
    }

    @Override
    public double calcularInteres() {
        return 0;
    }


    /**
     * Retira un monto de la cuenta
     * @param retiro Monto a retirar
     * @throws SaldoInsuficienteException Si el saldo es insuficiente
     */
    @Override
    public void retirar(double retiro) throws SaldoInsuficienteException{
        if (saldo < (retiro+comisionFija)) {
            throw new SaldoInsuficienteException("Saldo insuficinte");
        }
        saldo = saldo - (retiro + comisionFija);
        JOptionPane.showMessageDialog(null, "Se han retirado $"+retiro+" + comisón fija de $1500.\nNuevo saldo: "+saldo);
        EscritorRetiros.escribirRetiros("src/persistence/retiros.csv", titular, retiro,"Cuenta Corriente");
        
    }


    /**     * Deposita un monto en la cuenta
     * @param deposito Monto a depositar
     * @throws OperacionInvalidaException Si el monto es inválido
     */
    @Override
    public void depositar(double deposito) throws OperacionInvalidaException {
        super.depositar(deposito);
        EscritorDepositos.escribirDepositos("src/persistence/depositos.csv", titular, deposito, "Cuenta Corriente");

    }

    @Override
    public int getNumCuenta() {
        return super.getNumCuenta();
    }

    

    

    

    
}
