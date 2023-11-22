package servidorejemplolibro;

import java.io.*;
import java.util.*;

public class ServidorEjemploLibro {

    public static void main(String[] args) {

        try {
            SocketTCPServer servidor = new SocketTCPServer(49171);
            servidor.start();
            System.out.println("Mensaje del cliente:  " + servidor.leerMensaje());
            servidor.enviarMensaje("200");
            servidor.stop();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
