
package actividadresuelta53;

import java.io.PrintWriter;
import java.security.Key;

public class CifradorAESSimple {

    
    public static void main(String[] args) {
        
        final int LONGITUD_BLOQUE = 16; // Expresado en bytes
        final String NOMBRE_FICHERO = "mensaje_cifrado.txt";
        final String PASSWORD = "MeLlamoSpiderman";
        final String TEXTO_EN_CLARO = "La clave secreta de la caja fuerte es 12345678";
        
        try {
            Key clave = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD_BLOQUE);
            String textoEnClaro = TEXTO_EN_CLARO;
            String textoCifrado = AESSimpleManager.cifrar(textoEnClaro, clave);
            
            PrintWriter pw = new PrintWriter(NOMBRE_FICHERO);
            pw.write(textoCifrado);
            pw.close();
            System.out.println("El mensaje se ha cifrado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
