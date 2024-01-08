package tcpsocketserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketTCPServer {

    private ServerSocket serverSocket;

    
    private SocketTCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("(Servidor) Conexión establecida");
            new GestorProcesos(socket).start();
        }
    }
    

    public void stop() throws IOException {

        serverSocket.close();
    }
    
    
    public static void main(String[] args) {
        try {
            SocketTCPServer servidor = new SocketTCPServer(49171);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
