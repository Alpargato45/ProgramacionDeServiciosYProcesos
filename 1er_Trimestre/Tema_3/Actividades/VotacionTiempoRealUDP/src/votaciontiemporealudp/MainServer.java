package votaciontiemporealudp;

import java.io.IOException;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainServer {
    
    private static int puntuacionMelendi = 0;
    private static int puntuacionEstopa = 0;
    private static int puntuacionFito = 0;
    private static int puntuacionCanto = 0;
    
    public static String mensajePuntuacion(SocketUDPServer server, int posPuntuaje) {
        String mensaje = "PUNTUACIONES\n";
        switch (posPuntuaje) {
            case 1-> {
                puntuacionMelendi++;
            }
            case 2-> {
                puntuacionEstopa++;
            }
            case 3-> {
                puntuacionFito++;
            }
            case 4-> {
                puntuacionCanto++;
            }
            default-> {
                
            }
        }
        mensaje += "Melendi: " + puntuacionMelendi + " puntos\n";
        mensaje += "Estopa: " + puntuacionEstopa + " puntos\n";
        mensaje += "Fito y Fitipaldis: " + puntuacionFito+ " puntos\n";
        mensaje += "El Canto del Loco: " + puntuacionCanto + " puntos\n";
        return mensaje.trim();
    }

     public static void main(String[] args) {

        SocketUDPServer server = new SocketUDPServer(1024, "localhost", 49171);
        try {
            server.start();
            System.out.println("Prueba 0");
            while (true) {
                int menu = server.recibirEntero();
                System.out.println("Prueba 1");
                System.out.println(menu);
                switch (menu) {
                    case 1 -> {
                        System.out.println("Prueba 2.2.2.2");
                    }
                    case 2 -> {
                        System.out.println("Prueba 2");
                        server.enviarMensaje(mensajePuntuacion(server,0));
                        System.out.println("Prueba 3");
                        System.out.println(mensajePuntuacion(server,0));
                    }
                    case 3 -> {
                        //caso3
                    }
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
