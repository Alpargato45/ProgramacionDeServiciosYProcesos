package lecturaremotadeficheros;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LecturaRemotaDeFicheros {

    public static void main(String[] args) {
        try {
            SocketTCPServer server = new SocketTCPServer(49171);
            server.start();
            System.out.println("Ruta enviada por el cliente: " + server.leerMensaje());
            try (BufferedReader out = new BufferedReader(new FileReader(server.leerMensaje()))) {
                File archivo = new File(server.leerMensaje());
                if (archivo.exists()) {
                    String mensaje = "";
                    String linea = out.readLine();
                    while (linea != null) {
                        mensaje += linea;
                        linea = out.readLine();
                    }
                    server.enviarMensaje(mensaje);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            server.stop();
        } catch (IOException ex) {
            Logger.getLogger(LecturaRemotaDeFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
