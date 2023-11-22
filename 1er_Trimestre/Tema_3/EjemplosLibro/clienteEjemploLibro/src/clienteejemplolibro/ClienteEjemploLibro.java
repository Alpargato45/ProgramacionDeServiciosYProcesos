package clienteejemplolibro;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteEjemploLibro {

    
    public static void main(String[] args) {
        SocketTCPClient cliente = new SocketTCPClient("localhost", 49171);
        try {
            cliente.start();
            cliente.enviarMensaje("100");
            System.out.println("Mensaje del servidor:" + cliente.recibirMensaje());
            cliente.stop();
        } catch (IOException ex) {
            Logger.getLogger(ClienteEjemploLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
