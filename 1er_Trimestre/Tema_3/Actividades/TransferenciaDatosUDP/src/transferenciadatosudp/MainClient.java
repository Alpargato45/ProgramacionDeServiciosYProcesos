package transferenciadatosudp;

import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MainClient {
    
    public static void main(String[] args) {
        SocketUDPClient client = new SocketUDPClient(128,"localhost",49171);
        try {
            client.start();
            for (int i = 0; i < 10000; i++) {
                client.enviarMensaje("Mensaje: " + i);
                Thread.sleep(1);
            }
            client.enviarMensaje("FIN");
            client.stop();
        } catch (SocketException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}