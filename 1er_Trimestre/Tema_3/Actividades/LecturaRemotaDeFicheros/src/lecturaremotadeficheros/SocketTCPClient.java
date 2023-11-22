package lecturaremotadeficheros;

import entradadatos.EntradaDatos;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//Jorge del Cid Moreno
public class SocketTCPClient {

    private String serverIP;
    private int serverPort;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    public SocketTCPClient(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        System.out.println("(Cliente) Estableciendo conexión...");
        socket = new Socket(serverIP, serverPort);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());

        System.out.println("(Cliente) Conexión establecida");
    }

    public void stop() throws IOException {
        System.out.println("(Cliente) Cerrando conexiones...");
        dis.close();
        dos.close();
        socket.close();
        System.out.println("(Cliente) Conexiones cerradas.");
    }

    public String recibirMensaje() throws IOException {
        System.out.println("(Cliente) Leyendo mensaje...");
        String mensaje = dis.readUTF();
        return mensaje;
    }

    public void enviarMensaje(String mensaje) throws IOException {
        System.out.println("(Cliente) Enviado ruta...");
        dos.writeUTF(mensaje);
        System.out.println("(Cliente) Mensaje enviado correctamente.");
    }

    public static void main(String[] args) {
        SocketTCPClient cliente = new SocketTCPClient("localhost", 49171);
        try {
            cliente.start();
            cliente.enviarMensaje(EntradaDatos.pedirCadena("Ruta del archivo a leer:"));
            cliente.stop();
        } catch (IOException ex) {
            Logger.getLogger(SocketTCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}