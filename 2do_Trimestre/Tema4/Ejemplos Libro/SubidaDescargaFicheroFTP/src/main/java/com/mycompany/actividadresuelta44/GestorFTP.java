package com.mycompany.actividadresuelta44;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTP;


public class GestorFTP {
    
    private FTPClient clienteFTP;
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 21;
    private static final String USUARIO = "admin";
    private static final String PASSWORD = "12345678";    
    // Configuracion local de FileZilla Server
    
    public GestorFTP() {
        clienteFTP = new FTPClient();
    }
    
    private void conectar() throws SocketException, IOException {
        clienteFTP.connect(SERVIDOR,PUERTO);
        int respuesta = clienteFTP.getReplyCode();
        if (!FTPReply.isPositiveCompletion(respuesta)) {
            clienteFTP.disconnect();
            throw new IOException("Error al conectar con el servidor FTP");
        }
        
        boolean credencialesOK = clienteFTP.login(USUARIO,PASSWORD);
        
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
        boolean recibido = clienteFTP.retrieveFile(ficheroRemoto,os);
        os.close();
        return recibido;
    }
    
    
    public static void main(String[] args) {
        
        GestorFTP gestorFTP = new GestorFTP();
        
        try {
            gestorFTP.conectar();
            System.out.println("Conectado");
            
           boolean subido = gestorFTP.subirFichero("hola.txt");
            if (subido) {
                System.out.println("Fichero subido correctamente");
            } else {
                System.out.println("Ha ocurrido un error al intentar subir el fichero");
            }
            
            boolean descargado = gestorFTP.descargarFichero("hola.txt", "adios.txt");
            if (descargado) {
                System.out.println("Fichero descargado correctamente");
            } else {
                System.out.println("Ha ocurrido un error al intentar descargar el fichero");
            }
            
            gestorFTP.desconectar();
            System.out.println("Desconectado");
             
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}