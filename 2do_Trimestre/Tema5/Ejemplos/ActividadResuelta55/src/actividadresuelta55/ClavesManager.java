package actividadresuelta55;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class ClavesManager {

    private static final String FICHERO_CLAVE_PUBLICA = "clave_publica.key";
    private static final String FICHERO_CLAVE_PRIVADA = "clave_privada.key";

    
    public static KeyPair generarClaves() throws NoSuchAlgorithmException {

        KeyPairGenerator generador = KeyPairGenerator.getInstance("DSA");
        generador.initialize(512);   // Admite 512, 768 ó 1024
        KeyPair claves = generador.generateKeyPair();

        return claves;
    }

    public static void guardarClaves(KeyPair claves) throws Exception {
        
        FileOutputStream fos = new FileOutputStream(FICHERO_CLAVE_PUBLICA);
        fos.write(claves.getPublic().getEncoded());
        fos.close();
        fos = new FileOutputStream(FICHERO_CLAVE_PRIVADA);
        fos.write(claves.getPrivate().getEncoded());
        fos.close();
    }

    
    public static PublicKey getClavePublica() throws Exception {

        File ficheroClavePublica = new File(FICHERO_CLAVE_PUBLICA);
        byte[] bytesClavePublica = Files.readAllBytes(ficheroClavePublica.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytesClavePublica);
        PublicKey clavePublica = keyFactory.generatePublic(publicKeySpec);

        return clavePublica;
    }

    
    public static PrivateKey getClavePrivada() throws Exception {

        File ficheroClavePrivada = new File(FICHERO_CLAVE_PRIVADA);
        byte[] bytesClavePrivada = Files.readAllBytes(ficheroClavePrivada.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytesClavePrivada);
        PrivateKey clavePrivada = keyFactory.generatePrivate(privateKeySpec);

        return clavePrivada;
    }

    public static void main(String[] args) {
        
        try {
            KeyPair claves = generarClaves();
            guardarClaves(claves);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
