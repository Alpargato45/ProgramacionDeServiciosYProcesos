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
    private ChatServidor servidor;

    public SocketTCPServer(int puerto, ChatServidor servidor) throws IOException {
        serverSocket = new ServerSocket(puerto);
        this.servidor = servidor;
    }

    public void run() {
        try {
            socket = serverSocket.accept();
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String mensajeCliente = leerMensaje();
                if (mensajeCliente != null) {
                    servidor.recibirMensajeDelCliente(mensajeCliente);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public String leerMensaje() throws IOException {
        mensaje = dis.readUTF();
        return mensaje;
    }
    
    public void enviarMensaje(String mensaje) throws IOException {
        dos.writeUTF(mensaje);
    }
}
