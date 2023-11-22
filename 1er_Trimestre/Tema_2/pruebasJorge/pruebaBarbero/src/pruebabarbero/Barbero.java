package pruebabarbero;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Barbero extends Thread {

    private String nombre;
    private Barberia barberia;

    public Barbero(Barberia barberia, String nombre) {
        this.nombre = nombre;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            descansando();
            cortando();
        }
    }

    public void descansando() {
        int numAleatorio = (int) (Math.random() * 5 + 1);
        try {
            System.err.println("El Barbero " + nombre + " está descansando.");
            Thread.sleep(numAleatorio * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cortando() {
        int clienteActual = barberia.getIdPrimerCliente();
        if (clienteActual != -1) {
            System.out.println("El Barbero " + nombre + " Le está cortando el pelo al cliente: " + clienteActual);
            barberia.cortarPelo();
        } else {
            System.out.println("El Barbero " + nombre + " no tiene clientes para cortar el pelo.");
        }
    }
}
