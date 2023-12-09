package votaciontiemporealudp;

import java.io.*;
import java.net.SocketException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteUno {

    public static void main(String[] args) {

        SocketUDPClient client = new SocketUDPClient(1024, "localhost", 49171);
        try {
            client.start();

            String mensaje = "";
            int menu = 0;

            do {
                System.out.println("\tMENU");
                System.out.println("1. Puntuar");
                System.out.println("2. Informar Sobre Las Puntuaciones");
                System.out.println("3. Salir");
                do {
                    try {
                        menu = new Scanner(System.in).nextInt();
                    } catch (InputMismatchException ex) {
                        System.out.println("caracter introducido no válido");
                    }
                } while (menu < 1 || menu > 3);

                client.enviarEntero(menu);
                switch (menu) {
                    case 1 -> {
                        
                    }
                    case 2 -> {
                        byte[] buffer = client.recibirMensaje();
                        String informe = new String(buffer, 0, buffer.length).trim();
                        System.out.println(informe);
                        Thread.sleep(100);
                    }
                }

            } while (menu != 3);
            client.stop();
        } catch (SocketException ex) {
            Logger.getLogger(ClienteUno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClienteUno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
