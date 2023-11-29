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
            String ruta = server.leerMensaje();
            String mensaje = "";
            System.out.println("Ruta enviada por el cliente: " + ruta);
            File archivo = new File(ruta);
            try (BufferedReader out = new BufferedReader(new FileReader(archivo))) {
                if (archivo.exists()) {
                    String linea = out.readLine();
                    while (linea != null) {
                        mensaje += linea + "\n";
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
