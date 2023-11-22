package chatconsockets;

import java.io.*;
import java.net.*;

//Jorge del Cid Moreno

public class SocketTCPServer {

    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String mensaje;

    public SocketTCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException {
        socket = serverSocket.accept();
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }

    public void stop() throws IOException {
        dis.close();
        dos.close();
        socket.close();
        serverSocket.close();
    }
    
    public String leerMensaje() throws IOException {
        mensaje = dis.readUTF();
        return mensaje;
    }
    
    public void enviarMensaje(String mensaje) throws IOException {
        dos.writeUTF(mensaje);
    }
}
