package pruebabarbero;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertarClientes extends Thread {

    private Barberia barberia;

    public InsertarClientes(Barberia barberia) {
        this.barberia = barberia;
    }

    @Override
    public void run() {
        int id = 1;
        while (true) {
            try {
                Thread.sleep(1000);
                Cliente cliente = new Cliente(id++);
                barberia.añadirCliente(cliente);
            } catch (InterruptedException ex) {
                Logger.getLogger(InsertarClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
