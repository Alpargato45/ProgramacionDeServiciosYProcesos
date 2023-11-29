package udpsocketserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class SocketUDPServer {
        
    public static void main(String[] args) {
        
        DatagramSocket socket;
        
        try {
            System.out.println("(Servidor) Creando socket...");
            socket = new DatagramSocket(49171);
            
            
            System.out.println("(Servidor) Recibiendo datagrama...");
            byte[] bufferLectura = new byte[64];
            DatagramPacket datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
            socket.receive(datagramaEntrada);
            System.out.println("(Servidor) Mensaje recibido: " + new String(bufferLectura));
            
            System.out.println("(Servidor) Enviando datagrama...");
            byte[] mensajeEnviado = new String("Mensaje enviado desde el sevidor").getBytes();
            DatagramPacket datagramaSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length,
                                                    datagramaEntrada.getAddress(),
                                                    datagramaEntrada.getPort());
            socket.send(datagramaSalida);
            
            System.out.println("(Servidor) Cerrado sockets...");
            socket.close();
            System.out.println("(Servidor) Socket cerrado.");
            
            
            
            
            
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}
