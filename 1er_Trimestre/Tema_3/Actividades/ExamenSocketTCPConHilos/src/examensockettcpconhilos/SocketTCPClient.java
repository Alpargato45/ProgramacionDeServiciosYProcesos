package examensockettcpconhilos;

import java.io.*;
import java.net.*;

public class SocketTCPClient {

    private String serverIP;
    private int serverPort;
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    
    public SocketTCPClient(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }
    
    public void start() throws IOException {
        socket = new Socket(serverIP, serverPort);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }
    
    public void stop() throws IOException {
        oos.close();
        ois.close();
        socket.close();
    }
    
    public String recibirMensaje() throws IOException, ClassNotFoundException {
        String s = (String) ois.readObject();
        return s;
    }
    
    public int recibirPosicion() throws IOException, ClassNotFoundException {
        int i = (int) ois.readObject();
        return i;
    }
    
    public Perro recibirPerro() throws IOException, ClassNotFoundException {
        Perro p = (Perro) ois.readObject();
        return p;
    }
    
    public void enviarTamaño(int i) throws IOException {
        oos.writeObject(i);
    }
    
    public void enviarMensaje(String s) throws IOException {
        oos.writeObject(s);
    }
    
    
    
}
