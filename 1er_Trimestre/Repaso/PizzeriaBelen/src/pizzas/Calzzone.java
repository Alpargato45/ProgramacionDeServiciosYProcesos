package pizzas;

import java.util.*;

public class Calzzone extends Pizza {

    public Calzzone(int tiempo, double precio) {
        super(tiempo, precio * 1.05);
    }

    @Override
    public String toString() {
        return "Calzzone: " + super.toString();
    }
}
