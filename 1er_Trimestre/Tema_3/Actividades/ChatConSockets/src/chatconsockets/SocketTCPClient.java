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

    public SocketTCPClient(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        socket = new Socket(serverIP, serverPort);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
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