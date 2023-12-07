package transferenciadatosudp;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class SocketUDPServer {
    
    private DatagramSocket socket;
    private byte[] bufferLectura;
    private DatagramPacket datagramaEntrada;
    private DatagramPacket datagramaSalida;
    
    public void start() throws SocketException {
        socket = new DatagramSocket(49171);
        bufferLectura = new byte[64];
    }
    
    public byte[] recibirMensaje() throws IOException {
        datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
        socket.receive(datagramaEntrada);
        return bufferLectura;
    }
    
    public void enviarMensaje(String mensaje, InetAddress address, int port) throws IOException {
        byte[] mensajeEnviado = mensaje.getBytes();
        datagramaSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length, address, port);
        socket.send(datagramaSalida);
    }

    public void cerrarSocket() {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }
}