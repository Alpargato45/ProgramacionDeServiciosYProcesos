package actividadresuelta54;

import java.security.Key;
import java.security.PublicKey;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.File;

import javax.crypto.Cipher;


public class RSAReceptorManager {
        
    
    private static byte[] descifrar(byte[] mensajeCifrado, Key clave) throws Exception {
        
        Cipher descifrador = Cipher.getInstance("RSA");
        descifrador.init(Cipher.DECRYPT_MODE, clave);
        byte[] mensajeDescifrado = descifrador.doFinal(mensajeCifrado);
        
        return mensajeDescifrado;
    }


    public static void main(String[] args) {
       
        PublicKey clavePublica;
        File fichero = new File("datoscifrados.rsa");
        try {
            clavePublica = ClavesManager.getClavePublica();
            byte[] mensajeCifrado = Files.readAllBytes(fichero.toPath());
            byte[] mensajeDescifrado = descifrar(mensajeCifrado, clavePublica);
            System.out.println(new String(mensajeDescifrado, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
