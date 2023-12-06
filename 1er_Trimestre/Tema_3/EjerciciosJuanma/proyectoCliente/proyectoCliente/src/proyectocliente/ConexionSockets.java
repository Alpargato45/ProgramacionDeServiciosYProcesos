/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocliente;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoservidor.EscuchaCliente;

/**
 *
 * @author Juanma
 */
public class ConexionSockets{
    
    private static Socket socketCliente;
    private static DataOutputStream dOSCliente;
    private static ObjectInputStream oISCliente;

    public ConexionSockets() {

    }


    
    public void pedirFichero(){
        
        try {
            String rutaFichero = "src\\proyectoservidor\\diccionario.txt";
            socketCliente = new Socket("127.0.0.1", 9889);
            dOSCliente = new DataOutputStream(socketCliente.getOutputStream());
            dOSCliente.writeUTF(rutaFichero);
            oISCliente = new ObjectInputStream(socketCliente.getInputStream());
            File palabrasConA = (File) oISCliente.readObject();
            Scanner lectorArchivo = new Scanner(palabrasConA);
            while(lectorArchivo.hasNext()){
                String linea = lectorArchivo.nextLine();
                System.out.println(linea);
            }
            lectorArchivo.close();
            dOSCliente.close();
            socketCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(ConexionSockets.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
