package votaciontiemporealudp;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class SocketUDPServer {
    
    DatagramSocket socketUDP;
    byte[] buffer;
    private DatagramPacket entrada;
    private DatagramPacket salida;
    
    //He cambiado esta clase entera con ayuda de Javi para separarla más en vez de como yo la tenía
    //Para tener más control de las cosas que hago y para que pille bien el puerto y la ip de cada uno
    //Creo que se enviaba a si mismo el mensaje pq estaba cogiendo su propia ip y puerto y se lo enviaba a el mismo
        
    public SocketUDPServer(int puerto) throws IOException {
        socketUDP = new DatagramSocket(puerto);
    }
    
     public String recibirMensaje() throws IOException {
         buffer = new byte[1024];
        entrada = new DatagramPacket(buffer, buffer.length);
        socketUDP.receive(entrada);
        String mensaje = new String(entrada.getData());
        return mensaje;
    }
    
    public int obtenerPuerto(){
        int puertoCliente = entrada.getPort();
        return puertoCliente;
    }
    
    public InetAddress obtenerIp(){
        InetAddress direccion = entrada.getAddress();
        return direccion;
    }
       
    public void crearDatagramaPaquete(InetAddress direccion, int puertoCliente,String mensajeAux){
        buffer = mensajeAux.getBytes();
        salida = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
    }

    public void enviarMensaje() throws IOException{      
        socketUDP.send(salida);
    }
}