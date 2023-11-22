package servidorejemplolibro;

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
        System.out.println("(Servidor) Esperando conexiones...");
        socket = serverSocket.accept();
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("(Servidor) Conexión establecida.");
    }

    public void stop() throws IOException {
        System.out.println("(Servidor) Cerrando conexiones...");
        dis.close();
        dos.close();
        socket.close();
        serverSocket.close();
        System.out.println("(Servidor) Conexiones cerradas.");
    }
    
    public String leerMensaje() throws IOException {
        System.out.println("(Servidor) Leyendo mensaje...");
        mensaje = dis.readUTF();
        System.out.println("(Servidor) Mensaje leido.");
        return mensaje;
    }
    
    public void enviarMensaje(String mensaje) throws IOException {
        System.out.println("(Servidor) Enviado mensaje...");
        dos.writeUTF(mensaje);
        System.out.println("(Servidor) Mensaje enviado.");
    }
}
