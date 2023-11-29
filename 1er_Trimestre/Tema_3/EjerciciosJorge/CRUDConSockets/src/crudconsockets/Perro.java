package crudconsockets;

import java.io.*;


public class Perro implements Serializable{
    private static int contadorID = 0;
    private int id;
    private String Nombre;

    public Perro(String Nombre) {
        this.id = contadorID++;
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Perro " + " ID: " + id + "Nombre: " + Nombre;
    }
    
    
    
}
