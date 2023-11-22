package ejemplos;


public class RatonSimple implements Runnable{

    private String nombre;
    private int tiempoAlimentacion;
    private int alimentoConsumido;
    
    public RatonSimple(String nombre, int tiempoAlimentacion) {
        super();
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }
    
    public void comer() {
        try {
            System.out.printf("El raton %s ha comenzado a alimentarse%n",nombre);
            Thread.sleep(this.tiempoAlimentacion * 1000);
            this.alimentoConsumido++;
            System.out.printf("El raton %s ha terminado de alimentarse%n",nombre);
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
        RatonSimple fievel =  new RatonSimple("Fievel",2);
        
        for (int contador = 1; contador < 50; contador++) {
            new Thread(fievel).start();
        }
        
    }
}
