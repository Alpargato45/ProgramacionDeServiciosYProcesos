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
        String mensaje = (String) ois.readObject();
        return mensaje;
    }

    public int recibirEntero() throws IOException, ClassNotFoundException {
        int mensaje = (int) ois.readObject();
        return mensaje;
    }

    public Object recibirObjeto() throws IOException, ClassNotFoundException {
        Object objeto = ois.readObject();
        return objeto;
    }

    public void enviarMensaje(String mensaje) throws IOException {
        oos.writeObject(mensaje);
    }

    public void enviarPerro(Perro p) throws IOException {
        oos.writeObject(p);
    }

    public void enviarEntero(int mensaje) throws IOException {
        oos.writeObject(mensaje);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void añadirPerro(SocketTCPClient client) throws IOException, ClassNotFoundException {
        String nombre = EntradaDatos.pedirCadena("Nombre del Perro: ");
        Perro perro = new Perro(nombre);
        client.enviarPerro(perro);
        System.out.println(client.recibirMensaje());
    }

    public static void mostrarPerro(SocketTCPClient client) throws IOException, ClassNotFoundException, InterruptedException {
        int mensaje = EntradaDatos.pedirEntero("ID del Perro: ");
        client.enviarEntero(mensaje);
        Object objeto = client.recibirObjeto();
        if(objeto instanceof Perro) {
            Perro perro = (Perro) objeto;
            System.out.println(perro.toString());
        }else {
            System.out.println(objeto);
        }
    }

    public static void main(String[] args) {
        SocketTCPClient client = new SocketTCPClient("localhost", 49171);

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
                        client.enviarEntero(menu);
                        try {
                            añadirPerro(client);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(SocketTCPClient.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
