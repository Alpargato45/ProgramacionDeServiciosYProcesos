package com.mycompany.practicaftpjorge;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class PracticaFTPJorge {

    public static void main(String[] args) {
        GestionFTP gestionFTP = new GestionFTP();
        String directorioLocal = "C:\\Users\\atyu2\\Desktop\\Otros\\pruebapruebapruebaprueba";
        gestionFTP.descargarContenidosCarpetaRaiz(directorioLocal);
    }
}
