package pizzeriabelen;

import entradadatos.EntradaDatos;
import java.util.*;
import pizzas.*;

public class PizzeriaBelen {

    public static Pizza insertarPizza() {
        int tipoPizza;
        int tiempo;
        int precio;
        boolean bool;

        do {
            tipoPizza = EntradaDatos.pedirEntero("\t Elige tu Pizza:\n 1.Clásica \n 2.Calzzone");
        } while (tipoPizza < 1 || tipoPizza > 2);

        tiempo = EntradaDatos.pedirEntero("Tiempo que tarda en cocinar: ");
        precio = EntradaDatos.pedirEntero("Valor de la pizza: ");

        if (tipoPizza == 1) {
            char relleno;
            do {
                relleno = EntradaDatos.pedirChar("¿Quieres los bordes rellenos de queso? (y/n): ");
            } while (relleno != 'y' && relleno != 'n');
            return (new Clasica(relleno, tiempo, precio));

        } else {
            return (new Calzzone(tiempo, precio));
        }
    }

    public static double cantidadQueso(Cola Horno1) {
        int queso = 0;
        double porcentaje;
        Object pizza;
        for (int i = 0; i < Horno1.getNumElementos(); i++) {
            pizza = Horno1.pop();
            if (pizza instanceof Clasica) {
                if (((Clasica) pizza).getRelleno() == 'y') {
                    queso++;
                }
            }
            Horno1.push((Pizza) pizza);
        }
        porcentaje = (100 * queso) / Horno1.getNumElementos();
        return porcentaje;
    }
    
    public static void encenderHorno(Cola Horno) {
        int numElem = Horno.getNumElementos();
        
        for (int i = 0; i < numElem; i++) {
            Pizza pizza = (Pizza) Horno.pop();
            if(pizza instanceof Calzzone) {
                System.out.println("Horno Funcionando." + pizza.toString());
                try {
                Thread.sleep(pizza.getTiempo()*1000);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }else {
                Horno.push(pizza);
            }
        }
        for (int i = 0; i <= numElem; i++) {
            Pizza pizza = (Pizza) Horno.pop();
            if(pizza != null) {
                System.out.println("Horno Funcionando." + pizza.toString());
                try {
                Thread.sleep(pizza.getTiempo()*1000);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }
    }
    }
 
    public static void main(String[] args) {

        int menu = 0;
        Cola Horno1 = new Cola();

        do {
            System.out.println("\tMENU");
            System.out.println("1. Insertar Pizza");
            System.out.println("2. Cantidad % Pizzas Rellenas");
            System.out.println("3. Encendido del Horno");
            System.out.println("4. Salir");
            do {
                try {
                    menu = new Scanner(System.in).nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("caracter introducido no válido");
                }
            } while (menu < 1 || menu > 4);

            switch (menu) {
                case 1 -> {
                    if (Horno1.push(insertarPizza()) == true) {
                        System.out.println("Pizza Insertada con éxito");
                    } else {
                        System.out.println("No se ha podido insertar la Pizza");
                    }
                }
                case 2 -> {
                    System.out.println("El porcentaje de pizzas con queso es: " + cantidadQueso(Horno1) + "%");
                }
                case 3 -> {
                    encenderHorno(Horno1);
                }
            }
        } while (menu != 4);
    }
}
