
package actividadresuelta52;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.math.BigInteger;
import java.nio.file.Files;

public class ValidadorCredenciales {

    private static final String ENCODING_TYPE = "UTF-8";
    
    private static void mostrarResumenHexadecimal(byte[] resumen) {
        String resumenHexadecimal = String.format("%064x",new BigInteger(1,resumen));
        System.out.println(resumenHexadecimal);
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce identificador (email): ");
        String identificador = sc.nextLine();
        System.out.print("Introduce contraseña: ");
        String password = sc.nextLine();
        
        try {
            byte[] resumen = HASHManager.getDigest(password.getBytes(ENCODING_TYPE));
            // No se controla que el fichero no exista
            byte[] resumenAlmacenado = Files.readAllBytes(new File(identificador+".credencial").toPath());
            
            if (HASHManager.compararResumenes(resumen, resumenAlmacenado)) {
                System.out.println("Autorizado");
            } else {
                System.out.println("Error de validacion");
            }
            mostrarResumenHexadecimal(resumen);
            mostrarResumenHexadecimal(resumenAlmacenado);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
    
}
