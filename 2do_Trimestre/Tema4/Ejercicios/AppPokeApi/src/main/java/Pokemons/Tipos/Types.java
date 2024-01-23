package Pokemons.Tipos;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class Types {
    
    private int slot;
    private TypeInfo type;

    public Types(int slot, TypeInfo type) {
        this.slot = slot;
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public TypeInfo getType() {
        return type;
    }

    public void setType(TypeInfo type) {
        this.type = type;
    }
}
