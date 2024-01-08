package votaciontiemporealudp;

import entradadatos.EntradaDatos;
import java.io.*;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteUno {

    public static void main(String[] args) throws UnknownHostException, SocketException {

        SocketUDPClient client = new SocketUDPClient();
        
        InetAddress direccionServidor = InetAddress.getByName("localhost");
        int puertoServidor = 49171;
        try {

            String mensaje = "";
            String menu = "";
            
            client.crearDatagramaPaquete(direccionServidor, puertoServidor, "Conectar al servidor");
                client.enviarMensaje();
                //Hago que el cliente le tenga que enviar un mensaje al servidor para empezar la conexion(???)
                //Si no hago eso el servidor hace todo sin esperar al cliente, y da fallo por parte del servidor al iniciar la ip

            do {
                System.out.println("\tMENU");
                System.out.println("1. Puntuar");
                System.out.println("2. Informar Sobre Las Puntuaciones");
                System.out.println("3. Salir");
                
                
                do {
                    try {
                        menu = EntradaDatos.pedirCadena("Introduzca una opcion: ");
                    } catch (InputMismatchException ex) {
                        System.out.println("caracter introducido no válido");
                    }
                } while (!menu.equalsIgnoreCase("1") && !menu.equalsIgnoreCase("2") && !menu.equalsIgnoreCase("3"));
                client.crearDatagramaPaquete(direccionServidor, puertoServidor, menu);
                client.enviarMensaje();
                switch (menu) {
                    case "1" -> {
                        String menuCantantes = "";
                        
                            System.out.println("\tMENU");
                            System.out.println("1. Melendi");
                            System.out.println("2. Estopa");
                            System.out.println("3. Fito y Fitipaldis");
                            System.out.println("4. El Canto del Loco");
                            do {
                                try {
                                    menuCantantes = EntradaDatos.pedirCadena("Introduzca un cantante: ");
                                } catch (InputMismatchException ex) {
                                    System.out.println("caracter introducido no válido");
                                }
                            } while (!menuCantantes.equalsIgnoreCase("1") && !menuCantantes.equalsIgnoreCase("2") && !menuCantantes.equalsIgnoreCase("3") && !menuCantantes.equalsIgnoreCase("4"));
                            client.crearDatagramaPaquete(direccionServidor, puertoServidor, menuCantantes);
                            client.enviarMensaje();
                            System.out.println(client.recibirMensaje());
                    }
                    case "2" -> {
                        String informe = client.recibirMensaje();
                        System.out.println(informe);
                        Thread.sleep(100);
                    }
                }

            } while (!menu.equals("3"));
        } catch (SocketException ex) {
            Logger.getLogger(ClienteUno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClienteUno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
