package transferenciadatosudp;

import java.io.*;
import java.net.SocketException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainServer {

    public static void main(String[] args) {
        SocketUDPServer server = new SocketUDPServer(128, "localhost", 49171);
        try {
            server.start();

            File archivo = new File("datos.txt");
            String cadena = "";
            byte[] buffer;

            while (!cadena.equals("FIN")) {
                try (BufferedWriter in = new BufferedWriter(new FileWriter("datos.txt",true))) {
                    buffer = server.recibirMensaje();
                    cadena = new String(buffer, 0, buffer.length).trim();
                    if (!cadena.equals("FIN")) {
                        in.write(cadena);
                        in.newLine();
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
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
