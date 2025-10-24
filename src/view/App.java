package view;

import javax.swing.JOptionPane;

import controller.SistemaBancario;
import model.OperacionInvalidaException;
import model.SaldoInsuficienteException;

/**
 * Clase principal que maneja la interfaz del sistema bancario
 * @author Juan José Argüello
 * @version 1.0
 */
public class App {

    private static SistemaBancario sb = new SistemaBancario();

    public static void main(String[] args) throws Exception {
        menu();
    }
    /**
     * Muestra el menú principal del sistema bancario
     */
    public static void menu() {

        JOptionPane.showMessageDialog(null, """
                ==Bienvenido al Sistema Bancario==
                """);
        String op = "";
        do {
            op = JOptionPane.showInputDialog("""
                    Eliga una opción:
                    1. Crear una Cuenta Bancaria.
                    2. Depositar.
                    3. Retirar.
                    0. Salir.
                    """);
            String menu = """
                    Ingrese el tipo de cuenta:
                    1. Cuenta Corriente.
                    2. Cuenta de Ahorros.
                    3. Cuenta Empresarial.
                    """;
            switch (op) {
                case "1": //Crear Cuenta
                    String tipoCuentaC = JOptionPane.showInputDialog("""
                            Ingrese el tipo de cuenta que desea crear:
                            1. Cuenta Corriente.
                            2. Cuenta de Ahorros.
                            3. Cuenta Empresarial.
                            """);
                    switch (tipoCuentaC) {
                        case "1": //Crear Cuenta Corriente
                            int numCuentaC = Integer
                                    .parseInt(JOptionPane.showInputDialog("Ingrese un número de cuenta"));
                            String titularC = JOptionPane.showInputDialog("Ingrese el nombre del titular");
                            sb.crearCuentaCorriente(numCuentaC, titularC);
                            break;
                        case "2": //Crear Cuenta Ahorros
                            int numCuentaA = Integer
                                    .parseInt(JOptionPane.showInputDialog("Ingrese un número de cuenta"));
                            String titularA = JOptionPane.showInputDialog("Ingrese el nombre del titular");
                            sb.crearCuentaAhorros(numCuentaA, titularA);
                            break;
                        case "3": //Crear Cuenta Empresarial
                            int numCuentaE = Integer
                                    .parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta"));
                            String titularE = JOptionPane.showInputDialog("Ingrese el nombre del titular");
                            sb.crearCuentaEmpresarial(numCuentaE, titularE);
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opción inválida");
                            break;
                    }
                    break;
                case "2": //Depositar
                    String tipoCuenta = JOptionPane.showInputDialog(menu);
                    try {
                        switch (tipoCuenta) {
                            case "1": //Deposito Cuenta Corriente
                                int numCuentaC = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta"));
                                if (sb.buscarCuentaCorriente(numCuentaC) != null) {
                                    double deposito = Double.parseDouble(
                                            JOptionPane.showInputDialog("Ingrese la cantidad a depositar: "));
                                    sb.buscarCuentaCorriente(numCuentaC).depositar(deposito);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Cuenta con numero: " + numCuentaC + " no encontrada");
                                }
                                break;
                            case "2": //Deposito Cuenta Ahorros
                                int numCuentaA = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta"));
                                if (sb.buscarCuentaAhorros(numCuentaA) != null) {
                                    double deposito = Double.parseDouble(
                                            JOptionPane.showInputDialog("Ingrese la cantidad a depositar: "));
                                    sb.buscarCuentaAhorros(numCuentaA).depositar(deposito);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Cuenta con numero: " + numCuentaA + " no encontrada");
                                }
                                break;
                            case "3": //Deposito Cuenta Empresarial
                                int numCuentaE = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta"));
                                if (sb.buscarCuentaEmpresarial(numCuentaE) != null) {
                                    double deposito = Double.parseDouble(
                                            JOptionPane.showInputDialog("Ingrese la cantidad a depositar: "));
                                    sb.buscarCuentaEmpresarial(numCuentaE).depositar(deposito);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Cuenta con numero: " + numCuentaE + " no encontrada");
                                }
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida");
                                break;
                        }
                    } catch (OperacionInvalidaException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                    break;
                case "3": //Retirar
                    try {
                        tipoCuenta = JOptionPane.showInputDialog(menu);
                        switch (tipoCuenta) {
                            case "1": //Retiro Cuenta Corriente
                                int numCuentaC = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta"));
                                if (sb.buscarCuentaCorriente(numCuentaC) != null) {
                                    double retiro = Double.parseDouble(
                                            JOptionPane.showInputDialog("Ingrese la cantidad a retirar (Recuerde incluir la comisión: $1500): "));
                                    sb.buscarCuentaCorriente(numCuentaC).retirar(retiro);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Cuenta con numero: " + numCuentaC + " no encontrada");
                                }
                                break;
                            case "2": //Retiro Cuenta Ahorros
                                int numCuentaA = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta"));
                                if (sb.buscarCuentaAhorros(numCuentaA) != null) {
                                    double retiro = Double.parseDouble(
                                            JOptionPane.showInputDialog("Ingrese la cantidad a retirar: "));
                                    sb.buscarCuentaAhorros(numCuentaA).retirar(retiro);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Cuenta con numero: " + numCuentaA + " no encontrada");
                                }
                                break;
                            case "3": //Retiro Cuenta Empresarial
                                int numCuentaE = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta"));
                                if (sb.buscarCuentaEmpresarial(numCuentaE) != null) {
                                    double retiro = Double.parseDouble(
                                            JOptionPane.showInputDialog("Ingrese la cantidad a retirar: "));
                                    sb.buscarCuentaEmpresarial(numCuentaE).retirar(retiro);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Cuenta con numero: " + numCuentaE + " no encontrada");
                                }
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida");
                                break;
                        }
                    } catch (SaldoInsuficienteException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                    break;
                case "0": //Salir
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }

        } while (!op.equals("0"));
    }
}
