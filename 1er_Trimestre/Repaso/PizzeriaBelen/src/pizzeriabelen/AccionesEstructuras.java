package pizzeriabelen;

import java.util.*;

public interface AccionesEstructuras<T> {

// Inserta un elemento en la estructura y devuelve true si ha sido posible y false en caso contrario
    public boolean push(T elemento);
    
// Devuelve el siguiente elemento que tiene que atender
    public T pop();
    
// Devuelve true si la cola no tiene procesos y false en caso contrario
    public boolean esVacia();
    
// Devuelve el número de procesos que hay en la estructura
    public int getNumElementos();
}
