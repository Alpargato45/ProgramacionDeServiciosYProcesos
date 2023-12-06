package pruebapersonassockets;

import java.io.Serializable;

public class Persona implements Serializable{
    private static int idContador = 1;
    private int id;
    private String Nombre;
    private int edad;

    public Persona(String Nombre, int edad) {
        this.id = idContador++;
        this.Nombre = Nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", Nombre=" + Nombre + ", edad=" + edad + '}';
    }
}
