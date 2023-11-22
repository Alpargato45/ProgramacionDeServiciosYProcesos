package filosofo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesa {
     
    private boolean[] tenedores;
     
    public Mesa(int numTenedores){
        this.tenedores = new boolean[numTenedores];
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
         
        while(tenedores[tenedorIzquierda(comensal)] || tenedores[tenedorDerecha(comensal)]) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tenedores[tenedorIzquierda(comensal)] = true;
        tenedores[tenedorDerecha(comensal)] = true;
        
    }
     
    public synchronized void dejarTenedores (int comensal){
        
        tenedores[tenedorIzquierda(comensal)] = false;
        tenedores[tenedorDerecha(comensal)] = false;
        notifyAll();
        
    }

}
