package waitnotifysimple;


public class WaitNotifySimple implements Runnable {

    private volatile boolean ejecutandoMetodo1 = false;
    
    public synchronized void metodo1() {
        for (int i = 0; i <= 10; i++) {
            System.out.printf("Ejecucion %d%n", i);
            if (i == 5) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public synchronized void metodo2() {
        for (int i = 11; i <= 20; i++) {
            System.out.printf("Ejecucion %d%n", i);
        }
        this.notifyAll();
        // También valdría this.notify() ya que sólo había un hilo esperando
        
    }
    
    @Override
    public void run() {
        if (!this.ejecutandoMetodo1) {
            this.ejecutandoMetodo1 = true;
            metodo1();
        } else {
            metodo2();
        }
    }

    public static void main(String[] args) {
        WaitNotifySimple wns = new WaitNotifySimple();
        new Thread(wns).start();
        new Thread(wns).start();
    }
    
}
