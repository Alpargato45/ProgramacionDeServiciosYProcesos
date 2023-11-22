package pruebabarbero;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Barberia extends Thread {

    private ArrayList<Cliente> listaClientes;
    private int numSillas;

    public Barberia() {
        this.listaClientes = new ArrayList<Cliente>();
        this.numSillas = 5;
    }

    public synchronized void añadirCliente(Cliente cliente) {
        if (listaClientes.size() < numSillas) {
            listaClientes.add(cliente);
            System.out.println("Cliente " + cliente.getNombre() + " Ha entrado.");
            notifyAll();
        } else {
            System.out.println("Cliente " + cliente.getNombre() + " ha intentado entrar pero no ha podido");
        }
    }

    public synchronized void cortarPelo() {
        while (listaClientes.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        listaClientes.remove(0);
    }

    public synchronized int getIdPrimerCliente() {
        if (!listaClientes.isEmpty()) {
            return listaClientes.get(0).getNombre();
        } else {
            return -1;
        }
    }
}
