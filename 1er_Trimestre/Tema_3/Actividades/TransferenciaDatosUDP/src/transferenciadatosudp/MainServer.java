package transferenciadatosudp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MainServer {
    
    public static void main(String[] args) {
        SocketUDPServer server = new SocketUDPServer(64,"localhost",49171);
        try {
            server.start();
            
            String cadena = "";
            while (!cadena.equals("FIN")) {
                byte[] buffer = server.recibirMensaje();
                cadena = new String(buffer, 0, buffer.length).trim();
                if (!cadena.equals("FIN")) {
                    try (BufferedWriter in = new BufferedWriter(new FileWriter("datos.txt", true))) {
                        in.write(cadena);
                        in.newLine();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            
            server.stop();
        } catch (SocketException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
