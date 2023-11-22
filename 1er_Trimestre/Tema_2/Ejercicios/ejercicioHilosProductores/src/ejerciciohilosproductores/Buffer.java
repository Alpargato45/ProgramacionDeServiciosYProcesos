package ejerciciohilosproductores;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {

    private int[] buffer;
    private int siguiente;
    private boolean estaVacia;
    private boolean estaLlena;
    private int listaProducir;
    private int listaConsumir;
    private static int numFinal;
    private static String guardarTxt;

    public Buffer(int tamaño) {
        this.buffer = new int[tamaño];
        this.siguiente = 0;
        this.estaVacia = true;
        this.estaLlena = false;
    }

    public synchronized void producir(int i) {
        while (this.estaLlena) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        buffer[siguiente] = i;
        listaProducir = siguiente;
        siguiente++;
        this.estaVacia = false;
        if (siguiente == this.buffer.length) {
            this.estaLlena = true;
        }
        notifyAll();
    }

    public synchronized int consumir() {
        while (this.estaVacia) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        listaConsumir = siguiente;
        siguiente--;
        this.estaLlena = false;
        if (siguiente == 0) {
            this.estaVacia = true;
        }
        notifyAll();

        return this.buffer[this.siguiente];
    }

    public int getListaProducir() {
        return listaProducir;
    }

    public int getListaConsumir() {
        return listaConsumir;
    }

    public static int getNumFinal() {
        return numFinal;
    }

    public static String getGuardarTxt() {
        return guardarTxt;
    }

    public static void setGuardarTxt(String guardarTxt) {
        Buffer.guardarTxt = guardarTxt;
    }

    public static void setNumFinal(int numFinal) {
        Buffer.numFinal = numFinal;
    }
}
