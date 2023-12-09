package votaciontiemporealudp;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
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
        socket = new DatagramSocket(49171);;
    }
    
    public byte[] recibirMensaje() throws IOException {
        datagramaEntrada = new DatagramPacket(buffer, buffer.length);
        socket.receive(datagramaEntrada);
        return buffer;
    }
    
    public void enviarMensaje(String mensaje) throws IOException {
        byte[] mensajeEnviado = mensaje.getBytes();
        datagramaSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length, hostCliente, puertoCliente);
        socket.send(datagramaSalida);
    }
    
    public void enviarEntero(int numero) throws IOException {
        byte[] numeroBytes = ByteBuffer.allocate(Integer.BYTES).putInt(numero).array();
        datagramaSalida = new DatagramPacket(numeroBytes, numeroBytes.length, hostCliente, puertoCliente);
        socket.send(datagramaSalida);
    }

    public int recibirEntero() throws IOException {
        datagramaEntrada = new DatagramPacket(buffer, buffer.length);
        socket.receive(datagramaEntrada);
        return ByteBuffer.wrap(datagramaEntrada.getData()).getInt();
    }

    public void stop() {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }
}