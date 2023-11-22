package ejemplos;


public class RatonClase extends Thread{

    private String nombre;
    private int tiempoAlimentacion;
    
    public RatonClase(String nombre, int tiempoAlimentacion) {
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
        RatonClase fievel = new RatonClase("Fievel",4);
        RatonClase jerry = new RatonClase("Jerry",5);
        RatonClase pinky = new RatonClase("Pinky",3);
        RatonClase mickey = new RatonClase("Mickey",6);
        
        fievel.start();
        jerry.start();
        pinky.start();
        mickey.start();
    }
}
