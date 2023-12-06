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
    
    public String leerMensaje() throws IOException, ClassNotFoundException {
        mensaje = (String) ois.readObject();
        return mensaje;
    }
    
    public int recibirEntero() throws IOException, ClassNotFoundException {
        int mensaje = (int) ois.readObject();
        return mensaje;
    }
    
    public Perro recibirPerro() throws IOException, ClassNotFoundException {
        Perro p = (Perro) ois.readObject();
        return p;
    }
    
    public void enviarMensaje(String mensaje) throws IOException {
        oos.writeObject(mensaje);
    }
    
    public void enviarPerro(Perro perro) throws IOException {
        oos.writeObject(perro);
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public static void añadirPerro(SocketTCPServer server,ArrayList<Perro> listaPerros) throws IOException, ClassNotFoundException {
        Perro p = server.recibirPerro();
        p.setId();
        if(listaPerros.add(p)){
            server.enviarMensaje("Perro añadido Correctamente");
        }else {
            server.enviarMensaje("Perro no se ha podido añadir");
        }
    }
    
    public static void enviarPerro(SocketTCPServer server,ArrayList<Perro> listaPerros) throws IOException, ClassNotFoundException {
        int idPerro = server.recibirEntero();
        Perro perroEncontrado = null;

        //Codigo para comprobaciones
        for (Perro p : listaPerros) {
//            System.out.println("ID del perro en la lista: " + p.getId());
            if (p.getId() == idPerro) {
                perroEncontrado = p;
                break; // Salir del bucle cuando se encuentra el perro
            }
        }

        if (perroEncontrado != null) {
            server.enviarPerro(perroEncontrado);
        } else {
            server.enviarMensaje("Perro no encontrado");
        }
    }
    
    public static void main(String[] args) {
        try {
            SocketTCPServer server = new SocketTCPServer(49171);
            server.start();
            
            ArrayList<Perro> listaPerros = new ArrayList<Perro>();
            for (int i = 1; i <= 10; i++) {
                Perro perro = new Perro("pepe"+i);
                listaPerros.add(perro);
            }
            int menu = 0;
            
            do {
                menu = server.recibirEntero();
                switch (menu) {
                    case 1 -> {
                        añadirPerro(server,listaPerros);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SocketTCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}