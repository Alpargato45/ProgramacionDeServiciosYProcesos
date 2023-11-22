package chatconsockets;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//Jorge del Cid Moreno
public class SocketTCPClient {

    private String serverIP;
    private int serverPort;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private ChatCliente cliente;

    public SocketTCPClient(String serverIP, int serverPort, ChatCliente cliente) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.cliente = cliente;
    }

    public void run() {
        try {
            socket = new Socket(serverIP, serverPort);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String mensajeServidor = recibirMensaje();
                if (mensajeServidor != null) {
                    cliente.recibirMensajeDelServidor(mensajeServidor);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void stop() throws IOException {
        dis.close();
        dos.close();
        socket.close();
    }

    public String recibirMensaje() throws IOException {
        String mensaje = dis.readUTF();
        return mensaje;
    }

    public void enviarMensaje(String mensaje) throws IOException {
        dos.writeUTF(mensaje);
    }
}