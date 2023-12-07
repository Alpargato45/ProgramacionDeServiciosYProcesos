package transferenciadatosudp;

/**
 *
 * @author Jorge del Cid Moreno
 */
import java.io.IOException;
import java.net.*;

public class SocketUDPClient {

    private DatagramSocket socket;
    private byte[] buffer;
    private DatagramPacket datagramaSalida;
    private DatagramPacket datagramaEntrada;

    public void start() throws SocketException {
        socket = new DatagramSocket();
        buffer = new byte[64];
    }

    public void enviarMensaje(String mensaje, InetAddress hostServidor, int puertoServidor) throws IOException {
        byte[] mensajeBytes = mensaje.getBytes();
        datagramaSalida = new DatagramPacket(mensajeBytes, mensajeBytes.length, hostServidor, puertoServidor);
        socket.send(datagramaSalida);
    }

    public byte[] recibirMensaje() throws IOException {
        datagramaEntrada = new DatagramPacket(buffer, buffer.length);
        socket.receive(datagramaEntrada);
        return buffer;
    }

    public void cerrarSocket() {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }
}