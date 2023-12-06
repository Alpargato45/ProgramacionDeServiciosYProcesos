package sockettcp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorPerro {

    private static Perro[] listaPerros = {
        new Perro("Balto", 98),
        new Perro("Chonino", 40),
        new Perro("Laika", 66),
        new Perro("Stubby", 50),
        new Perro("Smoky", 51),
        new Perro("Barry", 223),
        new Perro("Old Drum", 154)
    };

    public static void main(String[] args) {
        try {
            SocketTCPServer server = new SocketTCPServer(50001);
            server.start();

            while (true) {
                String mensaje = server.recibirMensaje();
                if (mensaje.equals("Dame Perro")) {
                    server.enviarTamaño(listaPerros.length);
                    server.enviarMensaje("OK. POSICION");
                    int pos = server.recibirPosicion();
                    if(pos <= listaPerros.length) {
                        server.enviarMensaje("ENVIO PERRO");
                        Perro p = listaPerros[pos];
                        server.enviarPerro(p);
                    }else {
                        server.enviarMensaje("ERROR");
                    }
                }
            }
            //server.stop();
        } catch (IOException ex) {
            Logger.getLogger(ServidorPerro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServidorPerro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
