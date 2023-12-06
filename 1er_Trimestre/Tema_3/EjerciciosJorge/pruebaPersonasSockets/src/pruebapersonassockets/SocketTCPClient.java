package pruebapersonassockets;

import entradadatos.EntradaDatos;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void enviarInt(int id) throws IOException {
        oos.writeObject(id);
    }
    
    public Persona recibirPersona() throws IOException, ClassNotFoundException {
        Persona persona = (Persona) ois.readObject();
        return persona;
    }
    
    public Object recibirObjeto() throws IOException, ClassNotFoundException {
        Object o = ois.readObject();
        return o;
    }
    
//SEPARACIÓN DE CLASES-------------------------------------------------------------------------------------------
    
    public static void main(String[] args) {
        SocketTCPClient client = new SocketTCPClient("localhost",49171);
        try {
            client.start();
            client.enviarInt(EntradaDatos.pedirEntero("ID de la persona a buscar: "));
            Object objeto = client.recibirObjeto();
        if(objeto instanceof Persona) {
            Persona persona = (Persona) objeto;
            System.out.println(persona.toString());
        }else {
            System.out.println(objeto);
        }
            client.stop();
        } catch (IOException ex) {
            Logger.getLogger(SocketTCPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SocketTCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
