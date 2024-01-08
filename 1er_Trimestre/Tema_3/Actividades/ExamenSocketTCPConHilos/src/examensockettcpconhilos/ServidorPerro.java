package examensockettcpconhilos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorPerro extends Thread {

    public static void main(String[] args) {
        
        try {
            SocketTCPServer server = new SocketTCPServer(49171);
            while (true) {
                server.start();
                System.out.println("(Servidor) Conexión establecida");
                new GestorProcesos(server).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorPerro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
