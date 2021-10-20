package entities;

public class Equipment {

    private EquipmentsEnum name;
    private int improveDamage;
    private int reduceDamage;
    private int inventorySpace;

    public Equipment(EquipmentsEnum name) {
        this.name = name;
        this.improveDamage = name.improveDamage();
        this.reduceDamage = name.reduceDamage();
        this.inventorySpace = name.inventorySpace();
    }

    public EquipmentsEnum getName() {
        return name;
    }

    public int getImproveDamage() {
        return improveDamage;
    }

    public int getReduceDamage() {
        return reduceDamage;
    }

    public int getInventorySpace() {
        return inventorySpace;
    }
}
