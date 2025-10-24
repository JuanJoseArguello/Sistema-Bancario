package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.CuentaAhorros;
import model.CuentaCorriente;
import model.CuentaEmpresarial;

/**
 * Clase que maneja el sistema bancario
 * @author Juan José Argüello
 * @version 1.0
 */

public class SistemaBancario {
    private ArrayList<CuentaCorriente> cuentasCorrientes = new ArrayList<>(); 
    private ArrayList<CuentaAhorros> cuentasAhorros = new ArrayList<>(); 
    private ArrayList<CuentaEmpresarial> cuentasEmpresariales = new ArrayList<>(); 

    /**
     * Crea una cuenta corriente y la agrega a la lista de cuentas corrientes
     * @param numCuenta Número de la cuenta
     * @param titular Nombre del titular de la cuenta
     */

    public void crearCuentaCorriente(int numCuenta, String titular){
        cuentasCorrientes.add(new CuentaCorriente(numCuenta, titular));
    }

    /**
     * Crea una cuenta de ahorros y la agrega a la lista de cuentas de ahorros
     * @param numCuenta Número de la cuenta
     * @param titular Nombre del titular de la cuenta
     */
    
    public void crearCuentaAhorros(int numCuenta, String titular){
        cuentasAhorros.add(new CuentaAhorros(numCuenta, titular));
    }

    /**
     * Crea una cuenta empresarial y la agrega a la lista de cuentas empresariales
     * @param numCuenta Número de la cuenta
     * @param titular Nombre del titular de la cuenta
     */
    
    public void crearCuentaEmpresarial(int numCuenta, String titular){
        cuentasEmpresariales.add(new CuentaEmpresarial(numCuenta, titular));
    }

    /**
     * Busca una cuenta corriente por su número de cuenta
     * @param numCuenta Número de la cuenta
     * @return La cuenta corriente si se encuentra, null en caso contrario
     */

    public CuentaCorriente buscarCuentaCorriente(int numCuenta){
        for (CuentaCorriente cc : cuentasCorrientes) {
            if (cc.getNumCuenta()==numCuenta) {
                return cc;
            }
        }
        return null; 
    }

    /**
     * Busca una cuenta de ahorros por su número de cuenta
     * @param numCuenta Número de la cuenta
     * @return La cuenta de ahorros si se encuentra, null en caso contrario
     */
    public CuentaAhorros buscarCuentaAhorros(int numCuenta){
        for (CuentaAhorros ca : cuentasAhorros) {
            if (ca.getNumCuenta()==numCuenta) {
                return ca;
            }
        }
        return null; 
    }

    /**
     * Busca una cuenta empresarial por su número de cuenta
     * @param numCuenta Número de la cuenta
     * @return La cuenta empresarial si se encuentra, null en caso contrario
     */
    public CuentaEmpresarial buscarCuentaEmpresarial(int numCuenta){
        for (CuentaEmpresarial ce : cuentasEmpresariales) {
            if (ce.getNumCuenta()==numCuenta) {
                return ce;
            }
        }
        return null; 
    }
}
