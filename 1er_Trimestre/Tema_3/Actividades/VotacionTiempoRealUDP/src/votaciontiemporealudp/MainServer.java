package votaciontiemporealudp;

import java.io.IOException;
import java.net.InetAddress;
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
    
    public static String mensajePuntuacion(int posPuntuaje) {
        String mensaje = "PUNTUACIONES\n";
        switch (posPuntuaje) {
            case 1 -> {
                puntuacionMelendi++;
            }
            case 2 -> {
                puntuacionEstopa++;
            }
            case 3 -> {
                puntuacionFito++;
            }
            case 4 -> {
                puntuacionCanto++;
            }
            default -> {
                
            }
        }
        mensaje += "Melendi: " + puntuacionMelendi + " puntos\n";
        mensaje += "Estopa: " + puntuacionEstopa + " puntos\n";
        mensaje += "Fito y Fitipaldis: " + puntuacionFito + " puntos\n";
        mensaje += "El Canto del Loco: " + puntuacionCanto + " puntos\n";
        return mensaje.trim();
    }
    
    public static void main(String[] args) throws IOException {
        
        SocketUDPServer server = new SocketUDPServer(49171);
        
        System.out.println(server.recibirMensaje().trim());
        
        int puertoCliente = server.obtenerPuerto();
        InetAddress direccionCliente = server.obtenerIp();
        
        String menu = "";
        try {
            while (!menu.equals("3")) {
                Thread.sleep(100);
                menu = server.recibirMensaje().trim();
                
                if (menu.equalsIgnoreCase("1")) {
                    String num = server.recibirMensaje().trim();
                    int numEntero = Integer.parseInt(num);
                    mensajePuntuacion(numEntero);
                    server.crearDatagramaPaquete(direccionCliente, puertoCliente, "Punto añadido Correctamente");
                    server.enviarMensaje();
                } else if (menu.equalsIgnoreCase("2")) {
                    String mensaje = mensajePuntuacion(0);
                    server.crearDatagramaPaquete(direccionCliente, puertoCliente, mensaje);
                    server.enviarMensaje();
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
