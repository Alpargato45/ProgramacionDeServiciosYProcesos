package Pokemons.Habilidades;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class Ability {

    private AbilityDetails ability;

    public AbilityDetails getAbility() {
        return ability;
    }

    public void setAbility(AbilityDetails ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "Ability{"
                + "ability=" + ability
                + '}';
    }
}
