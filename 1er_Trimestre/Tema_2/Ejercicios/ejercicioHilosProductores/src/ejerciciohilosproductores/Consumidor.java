package ejerciciohilosproductores;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread {

    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.getNumFinal() < 100) {
            int num = this.buffer.consumir();
            String s = "Hilo consumidor: saca el valor " + num + " de la posición: " + (buffer.getListaConsumir()-1);
            buffer.setGuardarTxt(s);
            System.out.println(s);
            try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String s = "Resultado: " + buffer.getNumFinal();
        buffer.setGuardarTxt(s);
        System.out.println(s);
    }

}
