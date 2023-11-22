package ejercicio1examenprocesos;


public class Principal {

    
    public static void main(String[] args) {
        int numeroOculto = (int) ((Math.random() *100)+1);
        
        for (int i = 1; i <= 10; i++) {
            hiloNumeroOculto hilo = new hiloNumeroOculto(numeroOculto,i);
            hilo.start();
        }
    }
}
