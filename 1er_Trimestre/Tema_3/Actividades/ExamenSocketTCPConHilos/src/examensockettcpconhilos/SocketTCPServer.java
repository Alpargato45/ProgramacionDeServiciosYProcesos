package examensockettcpconhilos;

import java.io.*;
import java.net.*;


public class SocketTCPServer {

    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String mensaje;
    
    public SocketTCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }
    
    public void start() throws IOException {
        socket = serverSocket.accept();
        ois = new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());
    }
    
    public void stop() throws IOException {
        ois.close();
        oos.close();
        socket.close();
        serverSocket.close();
    }
    
    public String recibirMensaje() throws IOException, ClassNotFoundException {
       String s = (String) ois.readObject();
       return s;
    }
    
    public int recibirPosicion() throws IOException, ClassNotFoundException {
        int i = (int) ois.readObject();
        return i;
    }
    
    public void enviarMensaje(String s) throws IOException {
        oos.writeObject(s);
    }
    
    public void enviarTamaño(int i) throws IOException {
        oos.writeObject(i);
    }
    
    public void enviarPerro(Perro p) throws IOException {
        oos.writeObject(p);
    }
   
}
