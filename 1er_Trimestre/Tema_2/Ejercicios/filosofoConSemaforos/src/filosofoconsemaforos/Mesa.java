package filosofoconsemaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesa {
     
    private Semaphore[] tenedores;
     
    public Mesa(int numTenedores){
        this.tenedores = new Semaphore[numTenedores];
        for (int i = 0; i < numTenedores; i++) {
            tenedores[i] = new Semaphore(1);
        }
    }
     
    public int tenedorIzquierda(int i){
        
        return(i-1);
    }
     
    public int tenedorDerecha(int i){
        
        if(i==5) {
            return 0;
        }else {
            return (i);
        }
    }
     
    public synchronized void cogerTenedores(int comensal){
         
            try {
                tenedores[tenedorIzquierda(comensal)].acquire();
                tenedores[tenedorDerecha(comensal)].acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
     
    public synchronized void dejarTenedores (int comensal){
        
        tenedores[tenedorIzquierda(comensal)].release();
        tenedores[tenedorDerecha(comensal)].release();
        
    }

}