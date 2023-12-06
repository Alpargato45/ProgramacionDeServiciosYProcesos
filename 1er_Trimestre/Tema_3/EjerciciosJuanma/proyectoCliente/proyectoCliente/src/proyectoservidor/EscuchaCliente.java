/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoservidor;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectocliente.ConexionSockets;

/**
 *
 * @author Juanma
 */
public class EscuchaCliente implements Serializable {

    private static Socket socketServidor;
    private static ServerSocket miServidor;
    private static DataInputStream dISServidor;
    private static ObjectOutputStream oOSServidor;

    public void recibirRutaFichero() {

        try {
            System.out.println("Esperando conexion");
            miServidor = new ServerSocket(9889);
            socketServidor = miServidor.accept();
            dISServidor = new DataInputStream(socketServidor.getInputStream());
            String ruta = dISServidor.readUTF();
            File diccionario = new File(ruta);

            Scanner lectorArchivo = new Scanner(diccionario);
            FileWriter escribe = new FileWriter("src\\proyectoservidor\\A.txt", true);
            System.out.println("Archivo creado con exito");
            do {
                String linea = lectorArchivo.nextLine();
                if (linea.startsWith("a") || linea.startsWith("A")) {

                    escribe.write(linea + "\n");

                }
            } while (lectorArchivo.hasNext());
            lectorArchivo.close();
            escribe.close();
            
            File palabrasConA = new File("src\\proyectoservidor\\A.txt");
            oOSServidor = new ObjectOutputStream(socketServidor.getOutputStream());
            oOSServidor.writeObject(palabrasConA);
            oOSServidor.close();
            
        } catch (IOException ex) {
            Logger.getLogger(EscuchaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
