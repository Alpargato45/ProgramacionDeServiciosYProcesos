package pruebapersonassockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public int recibirInt() throws IOException, ClassNotFoundException {
        int id = (int) ois.readObject();
        return id;
    }
    
    public void enviarPersona(Persona p) throws IOException {
        oos.writeObject(p);
    }
    
    public void enviarMensaje(String s) throws IOException {
        oos.writeObject(s);
    }

//SEPARACIÓN CLASES-----------------------------------------------------------------------------------------------    
    public static void devolverPersona(SocketTCPServer server, ArrayList<Persona> listaPersonas, int id) throws IOException {
        Persona persona = null;
        for (Persona p : listaPersonas) {
            if(p.getId() == id) {
                persona = p;
            }
        }
        if(persona != null) {
            server.enviarPersona(persona);
        }else {
            server.enviarMensaje("ID: " + id + " no encontrado.");
        }
    }

    public static void main(String[] args) throws IOException {
        SocketTCPServer server = new SocketTCPServer(49171);
        server.start();
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Persona persona = new Persona("Persona " + i, i);
            listaPersonas.add(persona);
        }
        try {
            int id = server.recibirInt();
            devolverPersona(server, listaPersonas, id);
            server.stop();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SocketTCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
