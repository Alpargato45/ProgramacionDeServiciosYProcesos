package pizzas;

import java.util.*;

public class Clasica extends Pizza {

    private char relleno;

    public Clasica(char relleno, int tiempo, double precio) {
        super(tiempo, precio);
        this.relleno = relleno;
    }

    public char getRelleno() {
        return relleno;
    }

    @Override
    public String toString() {
        return "Clasica: " + super.toString() + " relleno: " + relleno;
    }
}
