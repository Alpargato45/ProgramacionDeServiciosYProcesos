package Pokemons;

import Pokemons.Habilidades.Ability;
import Pokemons.Tipos.Types;
import java.util.*;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class Pokemon {
    
    private String Name;
    private int height;
    private int weight;
    private ArrayList<Ability> abilities;
    private Sprites sprites;
    private ArrayList<Types> types;

    public Pokemon(String Name, int height, int weight, ArrayList<Ability> abilities, Sprites sprites, ArrayList<Types> types) {
        this.Name = Name;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.sprites = sprites;
        this.types = types;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public ArrayList<Types> getTypes() {
        return types;
    }
}
