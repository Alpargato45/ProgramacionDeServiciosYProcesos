package pizzas;

import java.util.*;

public abstract class Pizza {

    private int id;
    private static int idPosible = 0;
    private int tiempo;
    private double precio;

    public Pizza(int tiempo, double precio) {
        this.tiempo = tiempo;
        this.precio = precio;
        id = idPosible++;
    }

    public int getTiempo() {
        return tiempo;
    }

    @Override
    public String toString() {
        return "Pizza nº " + id + " tiempo de espera: " + tiempo + "s precio: " + precio;
    }
}
