package Pokemons.Habilidades;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class AbilityDetails {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbilityDetails{" +
                "name='" + name + '\'' +
                '}';
    }
}