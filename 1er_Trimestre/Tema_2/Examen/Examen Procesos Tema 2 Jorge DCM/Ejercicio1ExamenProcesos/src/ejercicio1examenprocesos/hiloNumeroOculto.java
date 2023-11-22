package ejercicio1examenprocesos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class hiloNumeroOculto extends Thread {

    private static boolean numeroDescubierto = false;
    private static int numeroOculto;
    private final int id;

    public hiloNumeroOculto(int numeroOculto, int id) {
        this.numeroOculto = numeroOculto;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(hiloNumeroOculto.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (!numeroDescubierto) {
            int resultado = adivinarNumero();
            if (resultado == -1) {
                System.out.println("El hilo " + id + " ha parado porque el número ya ha sido descubierto, el número era " + numeroOculto);
                return;
            }
        }
    }

    public synchronized int adivinarNumero() {
        if (numeroDescubierto) {
            return -1;
        }

        int numAleatorio = (int) (Math.random() * 100) + 1;

        if (numAleatorio != numeroOculto) {
            System.out.println("Hilo " + id + " ha elegido el número " + numAleatorio + " pero no era el correcto");
            return 0;
        } else {
            System.out.println("El hilo " + id + " ha descubierto el número oculto!! El número era: " + numeroOculto);
            numeroDescubierto = true;
            return 1;
        }
    }
}
