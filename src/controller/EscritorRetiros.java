package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 * Clase para escribir en el archivo de retiros
 * @author Juan José Argüello
 * @version 1.0
 */

public class EscritorRetiros {
    /**
     * Escribe un retiro en el archivo especificado
     * @param filepath Ruta del archivo donde se escribirá el retiro
     * @param titular Nombre del titular de la cuenta
     * @param monto Monto del retiro
     * @param tipoCuenta Tipo de cuenta
     */
    public static void escribirRetiros(String filepath, String titular, double monto, String tipoCuenta){
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filepath, true))) {
            br.write(titular+","+monto+","+tipoCuenta+"\n");
        } catch (Exception e) {
            System.out.println("Error al escribir retiro: " + e.getMessage());
        }
    }
}
