package pizzeriabelen;

import java.util.*;
import pizzas.Pizza;

public class Cola<T> implements AccionesEstructuras<T> {

    private T[] colaHorno;

    public Cola() {
        this.colaHorno = (T[]) new Object[10];
    }

    @Override
    public boolean push(Object elemento) {
        for (int i = 0; i < colaHorno.length; i++) {
            if (colaHorno[i] == null) {
                colaHorno[i] = (T) elemento;
                return true;
            }
        }
        return false;
    }

    @Override
    public T pop() {
        T o1 = (T) colaHorno[0];
        int numElementos = getNumElementos();
        for (int i = 0; i < numElementos; i++) {
            colaHorno[i] = colaHorno[i + 1];
            colaHorno[i + 1] = null;
        }
        return o1;
    }

    @Override
    public boolean esVacia() {
        if (colaHorno[0] == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getNumElementos() {
        int num = colaHorno.length;
        for (int i = 0; i < colaHorno.length; i++) {
            if (colaHorno[i] == null) {
                num = i;
                return num;
            }
        }
        return num;
    }

}
