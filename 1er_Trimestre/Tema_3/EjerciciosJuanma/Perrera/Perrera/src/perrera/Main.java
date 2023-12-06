/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package perrera;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Juanma
 */
public class Main {
    private static ArrayList<Perro> perrera = new ArrayList<>();

    public static void main(String[] args) {
        Perro nuevo = new Perro(0, "Paco", "Doberman", LocalDate.of(2015, 8, 14));
        Perro nuevo1 = new Perro(1, "Paco1", "Husky", LocalDate.of(2016, 6, 17));
        Perro nuevo2 = new Perro(2, "Paco2", "caniche", LocalDate.of(2017, 5, 22));
        Perro nuevo3 = new Perro(3, "Paco3", "chihuahua", LocalDate.of(2018, 3, 1));
        Perro nuevo4 = new Perro(4, "Paco4", "Husky", LocalDate.of(2019, 1, 29));

        perrera.add(nuevo);
        perrera.add(nuevo1);
        perrera.add(nuevo2);
        perrera.add(nuevo3);
        perrera.add(nuevo4);

        ConexionSockets enviarSockets = new ConexionSockets();
        enviarSockets.crearConexion(perrera);
    }
    
}
