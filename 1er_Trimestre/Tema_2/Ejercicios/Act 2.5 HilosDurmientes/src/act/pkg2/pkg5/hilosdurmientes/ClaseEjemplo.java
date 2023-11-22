package act.pkg2.pkg5.hilosdurmientes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClaseEjemplo extends Thread{
    private String nombre;

    public ClaseEjemplo(String nombre) {
        this.nombre = nombre;
    }

    
    @Override
    public void run() {
        
        
        while (true) {            
            System.out.println("Soy el hilo " + nombre + " estoy trabajando" );
            try {
                int tiempoAleatorio = (int) (Math.random()*10+1);   
                sleep(tiempoAleatorio*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClaseEjemplo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
