
package barberiabuena;

import java.util.logging.Level;
import java.util.logging.Logger;


public class GestorSillas {
    
    private final int MAX_SILLAS;
    // Vector que indica cuantas sillas hay y si están libres o no
    boolean[] estaSillaLibre;
    // Indica si el cliente sentado en esa silla está atendido por un barbero o no
    boolean[] clienteEstaAtendido;

    public GestorSillas(int numSillas) {
        
        MAX_SILLAS = numSillas;
        // Construimos los vectores...
        estaSillaLibre = new boolean[MAX_SILLAS];
        clienteEstaAtendido = new boolean[MAX_SILLAS];
        // ... los inicializamos
        for (int i = 0; i < MAX_SILLAS; i++) {
            estaSillaLibre[i] = true;
            clienteEstaAtendido[i] = false;
        }
    }

    /**
     * Nos dice qué silla tiene algun cliente que no está atendido
     *
     * @return un número de silla o -1 si no hay clientes sin atender
     */
    public int getSiguienteCliente() {
    for (int i = 0; i < estaSillaLibre.length; i++) {
        if (!estaSillaLibre[i] && !clienteEstaAtendido[i]) {
            clienteEstaAtendido[i] = true;
            return i;
        }
    }
    return -1;
}
    
    /**
     * Nos dice el numero de silla que está libre
     *
     * @return Devuelve una posición o -1 si está todo ocupado
     */
    public int getPosSillaLibre() {

        for (int i = 0; i < estaSillaLibre.length; i++) {
            // Si está libre la silla ...
            if (estaSillaLibre[i]) {
                // se marca como ocupada
                estaSillaLibre[i] = false;
                //... y devolvemos i
                return i;
            }
        }
        // Si llegamos aquí es que no había nada libre
        return -1;
    }
    
    /**
     * El cliente de esa silla, se marcha, por lo que se marca esa silla como "libre"
     * y como "sin atender"
     */
    public void liberarSilla(int pos) {
    estaSillaLibre[pos] = true;
    clienteEstaAtendido[pos] = false;
    System.out.println("Se marcha el cliente de la silla: " + pos);
}
}
