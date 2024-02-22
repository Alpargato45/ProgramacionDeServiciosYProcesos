package actividadresuelta54;

import java.security.Key;
import java.security.PrivateKey;
import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.File;

public class RSAEmisorManager {
    
    private final static String DATOS = "El codigo de acceso es 1513.";
    
    
    private static byte[] cifrar(String mensaje, Key clave) throws Exception {
        
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, clave);
        byte[] mensajeBytes = mensaje.getBytes(StandardCharsets.UTF_8);
        byte[] mensajeCifradoBytes = encryptCipher.doFinal(mensajeBytes);
        
        return mensajeCifradoBytes;
    }


    public static void main(String[] args) {
        
        PrivateKey clavePrivada;
        File fichero = new File("datoscifrados.rsa");
        try {
            clavePrivada = ClavesManager.getClavePrivada();
            byte[] mensajeCifrado = cifrar(DATOS, clavePrivada);
            Files.write(fichero.toPath(),mensajeCifrado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
