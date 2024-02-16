package com.mycompany.pruebaexamenapi;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class Personaje {
    
    String name;
    String status;
    String species;
    String image;

    public Personaje(String name, String status, String species, String image) {
        this.name = name;
        this.status = status;
        this.species = species;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getImage() {
        return image;
    }
}
