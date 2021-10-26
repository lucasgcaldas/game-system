/**
 * Class responsible for instantiate
 * an Equipment
 *
 * @author Lucas Gomes
 */
public class Equipment {

    private EquipmentsEnum name;
    private int improveDamage;
    private int reduceDamage;
    private int inventorySpace;

    /**
     * Equipment Construct
     *
     * @param name
     */
    public Equipment(EquipmentsEnum name) {
        this.name = name;
        this.improveDamage = name.improveDamage();
        this.reduceDamage = name.reduceDamage();
        this.inventorySpace = name.inventorySpace();
    }

    /**
     * Get name
     *
     * @return EquipmentsEnum
     */
    public EquipmentsEnum getName() {
        return name;
    }

    /**
     * Get improveDamage
     *
     * @return int
     */
    public int getImproveDamage() {
        return improveDamage;
    }

    /**
     * Get reduceDamage
     *
     * @return int
     */
    public int getReduceDamage() {
        return reduceDamage;
    }

    /**
     * Get inventorySpace
     *
     * @return int
     */
    public int getInventorySpace() {
        return inventorySpace;
    }
}
