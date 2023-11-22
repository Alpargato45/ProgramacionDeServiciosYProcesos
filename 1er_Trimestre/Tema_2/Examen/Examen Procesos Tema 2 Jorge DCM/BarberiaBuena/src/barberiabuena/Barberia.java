package barberiabuena;

import barberiabuena.Barbero;
import barberiabuena.Cliente;
import barberiabuena.GestorSillas;
import java.util.Random;

public class Barberia {


    public static void main(String[] args) throws InterruptedException {
        
        final Random generadorAle = new Random();
        final int MAX_BARBEROS = 2;
        final int MAX_SILLAS = 4;
        final int MAX_CLIENTES = 10;
        final int MAX_ESPERA_SEGS = 3;
        Thread[] vhBarberos = new Thread[MAX_BARBEROS];

        GestorSillas gestorSillas = new GestorSillas(MAX_SILLAS);
       
        for (int i = 0; i < MAX_BARBEROS; i++) {
            Barbero b = new Barbero(gestorSillas, "Barbero " + i);
            Thread hilo = new Thread(b);
            vhBarberos[i] = hilo;
            hilo.start();
        }

        // Generamos unos cuantos clientes a intervalos aleatorios
        for (int i = 0; i < MAX_CLIENTES; i++) {
            Cliente c = new Cliente(gestorSillas);
            Thread hiloCliente = new Thread(c);
            hiloCliente.start();

            int msegs = generadorAle.nextInt(MAX_ESPERA_SEGS) * 1000;
            try {
                Thread.sleep(msegs);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        // La jornada ha terminado, "cerramos" los barberos
    }
}
