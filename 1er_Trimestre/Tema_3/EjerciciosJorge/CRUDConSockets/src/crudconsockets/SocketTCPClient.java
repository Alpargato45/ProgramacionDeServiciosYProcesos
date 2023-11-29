package crudconsockets;

import entradadatos.EntradaDatos;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//Jorge del Cid Moreno
public class SocketTCPClient {

    private String serverIP;
    private int serverPort;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private ObjectInputStream ois;

    public SocketTCPClient(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        socket = new Socket(serverIP, serverPort);
        dis = new DataInputStream(socket.getInputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }

    public void stop() throws IOException {
        dis.close();
        dos.close();
        ois.close();
        socket.close();
    }

    public String recibirMensaje() throws IOException {
        String mensaje = dis.readUTF();
        return mensaje;
    }
    
    public int recibirEntero() throws IOException {
        int mensaje = dis.read();
        return mensaje;
    }
    
    public Perro recibirPerro() throws IOException, ClassNotFoundException {
        Perro perro = (Perro) ois.readObject();
        return perro;
    }

    public void enviarMensaje(String mensaje) throws IOException {
        dos.writeUTF(mensaje);
    }
    
    public void enviarEntero(int mensaje) throws IOException {
        dos.write(mensaje);
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public static void mostrarPerro(SocketTCPClient client) throws IOException, ClassNotFoundException, InterruptedException {
        int mensaje = EntradaDatos.pedirEntero("ID del Perro: ");
        client.enviarEntero(mensaje);
        Perro perro = client.recibirPerro();
        System.out.println(perro.toString());
    }
    
    public static void main(String[] args) {
        SocketTCPClient client = new SocketTCPClient("localhost",49171);
        
        try {
            client.start();
            int menu = 0;
            
            do {
                System.out.println("\tMENU");
                System.out.println("1. Añadir Perro");
                System.out.println("2. Mostrar Perro por id");
                System.out.println("3. opcion");
                System.out.println("4. Salir");
                do {
                    try {
                        menu = new Scanner(System.in).nextInt();
                    } catch (InputMismatchException ex) {
                        System.out.println("caracter introducido no válido");
                    }
                } while (menu < 1 || menu > 4);
                
                switch (menu) {
                    case 1 -> {
                        
                    }
                    case 2 -> {
                    try {
                        client.enviarEntero(menu);
                        mostrarPerro(client);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SocketTCPClient.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SocketTCPClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    case 3 -> {
                        //caso3
                    }
                }
                
            } while (menu != 4);
            client.stop();
        } catch (IOException ex) {
            Logger.getLogger(SocketTCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}