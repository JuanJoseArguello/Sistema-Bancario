package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Clase para escribir en el archivo de depósitos
 * @author Juan José Argüello
 * @version 1.0
 */

public class EscritorDepositos {

    /**
     * Escribe un depósito en el archivo especificado
     * @param filePath Ruta del archivo donde se escribirá el depósito
     * @param titular Nombre del titular de la cuenta
     * @param monto Monto del depósito
     * @param tipoCuenta Tipo de cuenta
     */
    public static void escribirDepositos(String filePath, String titular, double monto, String tipoCuenta) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath, true))) {
            br.write(titular + "," + monto + "," + tipoCuenta + "\n");
        } catch (Exception e) {
            System.out.println("error en EscribirDepositos: " + e.getMessage());
        }
    }

}
