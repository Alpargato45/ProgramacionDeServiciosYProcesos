package pruebabarbero;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaBarbero {

    public static void main(String[] args) {
        
        Barberia barberia = new Barberia();
        Barbero barbero = new Barbero(barberia, "Ricardo");
        InsertarClientes insertarClientes = new InsertarClientes(barberia);
        
        barbero.start();
        insertarClientes.start();
    }
}