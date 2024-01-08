package examensockettcpconhilos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientePerro {

    public static void main(String[] artgs) {
        SocketTCPClient client = new SocketTCPClient("localhost",49171);
        try {
            client.start();
            String mensaje = "";
            do {
                mensaje = EntradaDatos.pedirCadena("Manda tu mensaje");
                
            }while(!mensaje.equals("Dame Perro"));
            client.enviarMensaje(mensaje);
            int pos = client.recibirPosicion();
            System.out.println(pos);
            System.out.println(client.recibirMensaje());
            int numAleatorio = (int)(Math.random()*(pos+2));
            client.enviarTamaño(numAleatorio);
            String mensajePos = client.recibirMensaje();
            if(mensaje.equals("ERROR")) {
                System.out.println("Ha solicitado una posición incorrecta en la lista");
            }else if(mensaje.equals("ENVIO PERRO")){
                System.out.println("Se va a recibir un perro");
                Perro p = client.recibirPerro();
                System.out.println(p.toString());
            }
            client.stop();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientePerro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}