package ejerciciohilosproductores;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread {

    private Buffer buffer;
    private int numProductor;

    public Productor(Buffer buffer, int numProductor) {
        this.buffer = buffer;
        this.numProductor = numProductor;
    }

    @Override
    public void run() {
        while (buffer.getNumFinal() < 100) {
            int num = (int) (Math.random() * 10 + 1);
            buffer.setNumFinal(buffer.getNumFinal() + num);
            buffer.producir(num);
            String s = "Hilo Productor " + numProductor + " : introduce el valor " + num + " en la posición: " + buffer.getListaProducir();
            buffer.setGuardarTxt(s);
            System.out.println(s);

            try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
