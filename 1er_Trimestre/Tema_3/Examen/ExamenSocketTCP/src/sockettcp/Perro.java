package sockettcp;

import java.io.Serializable;

public class Perro implements Serializable{
    
    private String nombre;
    private int edad;

    public Perro(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "Nombre: " + nombre + " - Edad: " + edad;
    } 
}
