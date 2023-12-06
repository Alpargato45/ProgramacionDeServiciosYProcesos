/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perrera;

import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author Juanma
 */
public class Perro implements Serializable{
    
    private int id;
    private String nombre;
    private String raza;
    private LocalDate fecha_nacimiento;

    public Perro(int id, String nombre, String raza, LocalDate fecha_nacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Perro{" + "id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", fecha_nacimiento=" + fecha_nacimiento + '}'+"\n";
    }
    
    
    
}
