package transferenciadatosudp;

/**
 *
 * @author Jorge del Cid Moreno
 */
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketUDPClient {

    private DatagramSocket socket;
    private byte[] buffer;
    private DatagramPacket datagramaSalida;
    private DatagramPacket datagramaEntrada;
    private InetAddress hostServidor;
    private int puertoServidor;

    public SocketUDPClient(int tamaño, String hostServidor, int puertoServidor) {
        try {
            this.buffer = new byte[tamaño];
            this.hostServidor = InetAddress.getByName(hostServidor);
            this.puertoServidor = puertoServidor;
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocketUDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start() throws SocketException {
        socket = new DatagramSocket();
    }

    public void enviarMensaje(String mensaje) throws IOException {
        byte[] mensajeBytes = mensaje.getBytes();
        datagramaSalida = new DatagramPacket(mensajeBytes, mensajeBytes.length, hostServidor, puertoServidor);
        socket.send(datagramaSalida);
    }

    public byte[] recibirMensaje() throws IOException {
        datagramaEntrada = new DatagramPacket(buffer, buffer.length);
        socket.receive(datagramaEntrada);
        return buffer;
    }

    public void stop() {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }
}