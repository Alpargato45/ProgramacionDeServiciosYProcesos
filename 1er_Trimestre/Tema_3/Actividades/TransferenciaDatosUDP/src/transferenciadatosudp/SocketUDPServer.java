package transferenciadatosudp;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class SocketUDPServer {
    
    private DatagramSocket socket;
    private byte[] buffer;
    private DatagramPacket datagramaEntrada;
    private DatagramPacket datagramaSalida;
    private InetAddress hostCliente;
    private int puertoCliente;

    public SocketUDPServer(int tamaño, String hostCliente, int puertoCliente) {
        try {
            this.buffer = new byte[tamaño];
            this.hostCliente = InetAddress.getByName(hostCliente);
            this.puertoCliente = puertoCliente;
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocketUDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void start() throws SocketException {
        socket = new DatagramSocket(49171);
        buffer = new byte[64];
    }
    
    public byte[] recibirMensaje() throws IOException {
        datagramaEntrada = new DatagramPacket(buffer, buffer.length);
        socket.receive(datagramaEntrada);
        return buffer;
    }
    
    public void enviarMensaje(String mensaje, InetAddress address, int port) throws IOException {
        byte[] mensajeEnviado = mensaje.getBytes();
        datagramaSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length, address, port);
        socket.send(datagramaSalida);
    }

    public void stop() {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }
}