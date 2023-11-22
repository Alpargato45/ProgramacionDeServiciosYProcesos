/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package barberos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Juanma
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    static Semaphore semaforoCliente = new Semaphore(0);
    static Semaphore semaforoBarbero = new Semaphore(0);
    static Semaphore semaforoSillasAccesibles = new Semaphore(1);
    static int sillasLibres = 5;
    
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Barbero barbero = new Barbero();
        Cliente cliente = new Cliente();

        Thread hiloBarbero = new Thread(barbero);
        Thread hiloCliente = new Thread(cliente);

        hiloBarbero.start();
        hiloCliente.start();
    }
    
    
}
