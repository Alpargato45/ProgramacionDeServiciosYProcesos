package ejemplos;


public class RatonInterfaz implements Runnable{

    private String nombre;
    private int tiempoAlimentacion;
    
    public RatonInterfaz(String nombre, int tiempoAlimentacion) {
        super();
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }
    
    public void comer() {
        try {
            System.out.printf("El raton %s ha comenzado a alimentarse%n",nombre);
            Thread.sleep(this.tiempoAlimentacion * 1000);
            System.out.printf("El raton %s ha terminado de alimentarse%n",nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        this.comer();
    }
    
    
    public static void main(String[] args) {
        RatonInterfaz fievel =  new RatonInterfaz("Fievel",4);
        RatonInterfaz jerry = new RatonInterfaz("Jerry",5);
        RatonInterfaz pinky = new RatonInterfaz("Pinky",3);
        RatonInterfaz mickey = new RatonInterfaz("Mickey",6);
        
        new Thread(fievel).start();
        new Thread(jerry).start();
        new Thread(pinky).start();
        new Thread(mickey).start();
    }
}
