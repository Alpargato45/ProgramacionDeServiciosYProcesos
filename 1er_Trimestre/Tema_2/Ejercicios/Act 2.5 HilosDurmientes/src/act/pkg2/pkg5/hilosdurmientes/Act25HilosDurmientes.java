package act.pkg2.pkg5.hilosdurmientes;

public class Act25HilosDurmientes {

    public static void main(String[] args) {
        ClaseEjemplo ej1 = new ClaseEjemplo("Hilo 1");
        ClaseEjemplo ej2 = new ClaseEjemplo("Hilo 2");
        ClaseEjemplo ej3 = new ClaseEjemplo("Hilo 3");
        ClaseEjemplo ej4 = new ClaseEjemplo("Hilo 4");
        ClaseEjemplo ej5 = new ClaseEjemplo("Hilo 5");
        
        ej1.start();
        ej2.start();
        ej3.start();
        ej4.start();
        ej5.start();
    }
    
}
