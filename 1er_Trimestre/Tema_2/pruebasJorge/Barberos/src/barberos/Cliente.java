/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barberos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Juanma
 */
public class Cliente implements Runnable{
    
     @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Cliente: Entrando a la barbería...");
                Main.semaforoSillasAccesibles.acquire();
                if (Main.sillasLibres > 0) {
                    Main.sillasLibres--;
                    System.out.println("Cliente: Sentándose en la silla. Sillas libres: " + Main.sillasLibres);
                    Main.semaforoCliente.release();
                    Main.semaforoSillasAccesibles.release();
                    Main.semaforoBarbero.acquire();
                    System.out.println("Cliente: Pelo cortado. Saliendo de la barbería.");
                } else {
                    Main.semaforoSillasAccesibles.release();
                    System.out.println("Cliente: No hay sillas disponibles. Saliendo de la barbería.");
                }
                Thread.sleep(5000); // Pausa para simular el tiempo entre clientes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
}
