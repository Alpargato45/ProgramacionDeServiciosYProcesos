package com.mycompany.practicaftpjorge;

/**
 *
 * @author Jorge del Cid Moreno
 */
import java.io.*;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFile;

public class GestionFTP {

    private FTPClient clienteFTP;
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 21;
    private static final String USUARIO = "Jorge";
    private static final String PASSWORD = "patata";

    public GestionFTP() {
        clienteFTP = new FTPClient();
    }

    private void conectar() throws SocketException, IOException {
        clienteFTP.connect(SERVIDOR, PUERTO);
        int respuesta = clienteFTP.getReplyCode();
        if (!FTPReply.isPositiveCompletion(respuesta)) {
            clienteFTP.disconnect();
            throw new IOException("Error al conectar con el servidor FTP");
        }

        boolean credencialesOK = clienteFTP.login(USUARIO, PASSWORD);

        if (!credencialesOK) {
            throw new IOException("Error al conectar con el servidor FTP. Credenciales incorrectas");
        }

        clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
    }

    private void desconectar() throws IOException {
        clienteFTP.disconnect();
    }

    private boolean subirFichero(String path) throws IOException {
        File ficheroLocal = new File(path);
        InputStream is = new FileInputStream(ficheroLocal);
        boolean enviado = clienteFTP.storeFile(ficheroLocal.getName(), is);
        is.close();
        return enviado;
    }

    private boolean descargarFichero(String ficheroRemoto, String pathLocal) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(pathLocal));
        boolean recibido = clienteFTP.retrieveFile(ficheroRemoto, os);
        os.close();
        return recibido;
    }

    public void descargarContenidosCarpetaRaiz(String directorioLocal) {
        try {
            conectar();

            FTPFile[] archivosRemotos = clienteFTP.listFiles();

            for (FTPFile archivoRemoto : archivosRemotos) {
                if (archivoRemoto.isFile()) {
                    String nombreArchivoRemoto = archivoRemoto.getName();
                    String rutaLocal = directorioLocal + File.separator + nombreArchivoRemoto;

                    boolean descargado = descargarFichero(nombreArchivoRemoto, rutaLocal);

                    if (descargado) {
                        System.out.println("Descargado: " + nombreArchivoRemoto);
                    } else {
                        System.out.println("Error al descargar: " + nombreArchivoRemoto);
                    }
                }
            }

            desconectar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}