/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidorAcogida;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import perrera.Perro;

/**
 *
 * @author Juanma
 */
public class ServerSockets {

    private static ServerSocket miServidor;
    private static Socket socketServidor;
    private static ObjectInputStream oISServidor;
    private static ObjectOutputStream oOSServidor;
    private static ArrayList<Perro> husky = new ArrayList<Perro>();
    
    public ServerSockets() {
    }
    
    public static void recibirConexion(){
        try {
            System.out.println("Esperando conexion...");
           
            miServidor = new ServerSocket(1234);          
            socketServidor = miServidor.accept();
            oISServidor = new ObjectInputStream(socketServidor.getInputStream());
            ArrayList<Perro> perreraRecibida = (ArrayList<Perro>) oISServidor.readObject();
            for (Perro i : perreraRecibida) {
                System.out.println(i.toString());
                if("Husky".equalsIgnoreCase(i.getRaza())){
                    husky.add(i);
                    
                }
            }
            oOSServidor = new ObjectOutputStream(socketServidor.getOutputStream());
            oOSServidor.writeObject(husky);
            oISServidor.close();
            socketServidor.close();
            miServidor.close();
                      
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(ServerSockets.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
