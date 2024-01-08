package votaciontiemporealudp;

/**
 *
 * @author Jorge del Cid Moreno
 */
import java.io.IOException;
import java.net.*;

public class SocketUDPClient {

    DatagramSocket socketUDP;
    byte[] buffer;
    DatagramPacket salida;
    DatagramPacket entrada;
    
    public SocketUDPClient() throws SocketException {
        socketUDP = new DatagramSocket();
    }

    public String recibirMensaje() throws IOException {
         buffer = new byte[1024];
        entrada = new DatagramPacket(buffer, buffer.length);
        socketUDP.receive(entrada);
        String mensaje = new String(entrada.getData());
        return mensaje;
    }
       
    public void crearDatagramaPaquete(InetAddress direccion, int puertoCliente,String mensajeAux){
        buffer = mensajeAux.getBytes();
        salida = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
    }

    public void enviarMensaje() throws IOException{      
        socketUDP.send(salida);
    }
    
    public void close(){
        socketUDP.close();
    }
}