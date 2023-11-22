/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barberos;

/**
 *
 * @author Juanma
 */
public class Barbero implements Runnable{
 @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Barbero: Esperando cliente...");
                Main.semaforoCliente.acquire();
                Main.semaforoSillasAccesibles.acquire();
                Main.sillasLibres++;
                System.out.println("Barbero: Silla disponible. Sillas libres: " + Main.sillasLibres);
                Main.semaforoBarbero.release();
                Main.semaforoSillasAccesibles.release();
                Thread.sleep(1000); // Pausa para simular el corte de pelo
                System.out.println("Barbero: Pelo cortado. Esperando siguiente cliente...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
