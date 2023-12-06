/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perrera;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanma
 */
public class ConexionSockets {

    public static Socket miSocket;
    public static ObjectOutputStream oOS;
    public static ObjectInputStream oIS;
    

    public ConexionSockets() {
    }
    
    public static void crearConexion(ArrayList<Perro> perrera){
        try {
            miSocket = new Socket("127.0.0.1", 1234);
            oOS = new ObjectOutputStream(miSocket.getOutputStream());           
            oOS.writeObject(perrera);
            oIS = new ObjectInputStream(miSocket.getInputStream());
            ArrayList<Perro> huskys = (ArrayList<Perro>)oIS.readObject();
            System.out.println(huskys);
            oOS.close();
            miSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ConexionSockets.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
