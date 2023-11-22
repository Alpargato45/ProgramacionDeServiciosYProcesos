package problemafilosofosconsemaforos;

import java.util.concurrent.Semaphore;

public class Filosofo extends Thread {

    private int id;
    private Semaphore tenedorIzquierdo;
    private Semaphore tenedorDerecho;

    public Filosofo(int id, Semaphore tenedorIzquierdo, Semaphore tenedorDerecho) {
        this.id = id;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            comer();
        }
    }

    private void pensar() {
        System.out.println("Filosofo " + id + " esta pensando");
        try {
            Thread.sleep((long) (Math.random() * 4000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void comer() {
        try {
            tenedorIzquierdo.acquire();
            tenedorDerecho.acquire();

            System.err.println("Filosofo " + id + " esta comiendo.");
            Thread.sleep((long) (Math.random() * 4000) + 1000);

            tenedorIzquierdo.release();
            tenedorDerecho.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
