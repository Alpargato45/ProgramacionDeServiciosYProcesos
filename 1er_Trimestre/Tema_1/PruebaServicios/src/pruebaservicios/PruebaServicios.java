package pruebaservicios;

import java.util.*;



public class PruebaServicios {

    
    public static void main(String[] args) {
        
        ProcessBuilder pBuilder = new
            ProcessBuilder("Notepad.exe","datos.txt");
        Map<String, String> env = pBuilder.environment();
        for(String key: env.keySet()) {
            System.out.println(key + " " + env.get(key));
        }
        
    }
    
}
