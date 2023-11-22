package filosofoconsemaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Filosofo extends Thread {
     
    private Mesa mesa;
    private int comensal;

    public Filosofo(Mesa mesa, int comensal) {
        this.mesa = mesa;
        this.comensal = comensal;
    }
     
    @Override
    public void run(){
        while(true) {
            pensando();
            comiendo();
        }
         
    }
     
    public void pensando(){
        int numAleatorio = (int) (Math.random()*5+1);
        try {
            System.err.println("El filósofo " + comensal + " está pensando.");
            Thread.sleep(numAleatorio*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
     
    public void comiendo(){
        mesa.cogerTenedores(comensal);
        mesa.dejarTenedores(comensal);
        System.out.println("El filósofo " + comensal + " está comiendo.");
        
    }
}