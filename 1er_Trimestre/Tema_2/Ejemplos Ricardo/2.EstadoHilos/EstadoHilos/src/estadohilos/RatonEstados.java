package estadohilos;

import java.util.ArrayList;



public class RatonEstados implements Runnable {

   private String nombre;
   private int tiempoAlimentacion;
   private int alimentoConsumido;
   
   public RatonEstados(String nombre, int tiempoAlimentacion) {
       this.nombre = nombre;
       this.tiempoAlimentacion = tiempoAlimentacion;
   }
   
   public void comer() {
       try {
           System.out.printf("El ratón %s ha comenzado a alimentarse%n", this.nombre);
           alimentoConsumido++;
           Thread.sleep(this.tiempoAlimentacion * 1000);
           System.out.printf("El ratón %s ha terminado de alimentarse%n", this.nombre);
           System.out.printf("Alimento consumido: %d%n", this.alimentoConsumido);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
    
    @Override
    public void run() {
        this.comer();
    }
    
    public static void main(String[] args) {
        
        RatonEstados mickey = new RatonEstados("Mickey",3);
        ArrayList<Thread.State> estadosHilo = new ArrayList();
        Thread h = new Thread(mickey);
        estadosHilo.add(h.getState());   // Añade el estado NEW
        h.start();
       
        while (h.getState() != Thread.State.TERMINATED) {
            if (!estadosHilo.contains(h.getState())) {
                estadosHilo.add(h.getState());
            }
        }
        if (!estadosHilo.contains(h.getState())) {    // Añade el estado TERMINATED
            estadosHilo.add(h.getState());
        }
        
        for(Thread.State estado: estadosHilo) {
            System.out.println(estado);
        }
    }
}