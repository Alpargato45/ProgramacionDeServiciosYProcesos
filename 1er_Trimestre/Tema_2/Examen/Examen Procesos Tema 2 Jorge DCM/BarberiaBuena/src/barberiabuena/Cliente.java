package barberiabuena;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable {

    private GestorSillas gestorSillas;

    public Cliente(GestorSillas gestorSillas) {
        this.gestorSillas = gestorSillas;
    }

    @Override
    public void run() {
        // Los clientes no esperan que haya sillas libres, no hay bucle infinito.
        // Si no hay sillas libres se van...
        entrarEnBarberia();
    }

    public void entrarEnBarberia() {
        int posSillaLibre = gestorSillas.getPosSillaLibre();
        if (posSillaLibre == -1) {
            System.out.println("Nuevo cliente - No habia sillas libres, me marcho");
        } else {
            System.out.println("Nuevo cliente se sienta en la silla: " + posSillaLibre);
        }
    }
}
