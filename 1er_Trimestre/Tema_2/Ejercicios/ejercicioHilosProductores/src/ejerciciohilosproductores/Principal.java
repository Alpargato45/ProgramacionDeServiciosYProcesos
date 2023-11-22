package ejerciciohilosproductores;

import java.io.*;
import java.util.*;

public class Principal {

    
    public static void main(String[] args) {
        
        Buffer b = new Buffer(10);
        Productor p = new Productor(b,1);
        Productor p1 = new Productor(b,2);
        Consumidor c = new Consumidor(b);
        
        p.start();
        p1.start();
        c.start();
        
//        try (BufferedWriter in = new BufferedWriter(new FileWriter("archivo.txt"))) {
//            String texto = b.getGuardarTxt();
//            in.write(texto);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
        
    }
    
}
