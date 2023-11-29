package crudconsockets;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//Jorge del Cid Moreno

public class SocketTCPServer {

    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private ObjectOutputStream oos;
    private String mensaje;

    public SocketTCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

        public void start() throws IOException {
        socket = serverSocket.accept();
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());
    }

    public void stop() throws IOException {
        dis.close();
        dos.close();
        oos.close();
        socket.close();
        serverSocket.close();
    }
    
    public String leerMensaje() throws IOException {
        mensaje = dis.readUTF();
        return mensaje;
    }
    
    public int recibirEntero() throws IOException {
        int mensaje = dis.read();
        return mensaje;
    }
    
    public void enviarMensaje(String mensaje) throws IOException {
        dos.writeUTF(mensaje);
    }
    
    public void enviarPerro(Perro perro) throws IOException {
        oos.writeObject(perro);
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public static void enviarPerro(SocketTCPServer server,ArrayList<Perro> listaPerros) throws IOException {
        int idPerro = server.recibirEntero();
        for(Perro p : listaPerros) {
            if(p.getId() == idPerro) {
                server.enviarPerro(p);
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            SocketTCPServer server = new SocketTCPServer(49171);
            server.start();
            
            ArrayList<Perro> listaPerros = new ArrayList<Perro>();
            for (int i = 0; i < 10; i++) {
                Perro perro = new Perro("pepe"+i);
                listaPerros.add(perro);
            }
            int menu = 0;
            
            do {
                menu = server.recibirEntero();
                switch (menu) {
                    case 1 -> {
                        //caso1
                    }
                    case 2 -> {
                        enviarPerro(server,listaPerros);
                    }
                    case 3 -> {
                        //caso3
                    }
                }
                
            } while (menu != 4);
            server.stop();
        } catch (IOException ex) {
            Logger.getLogger(SocketTCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}