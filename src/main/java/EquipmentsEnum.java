/**
 * Enum responsible for instantiate
 * a set of equipments
 *
 * @author Lucas Gomes
 */
public enum EquipmentsEnum {
    ARMOR {
        @Override
        Integer improveDamage() {
            return 0;
        }

        @Override
        Integer reduceDamage() {
            return 6;
        }

        @Override
        Integer inventorySpace() {
            return 4;
        }
    },
    SWORD {
        @Override
        Integer improveDamage() {
            return 8;
        }

        @Override
        Integer reduceDamage() {
            return 3;
        }

        @Override
        Integer inventorySpace() {
            return 2;
        }
    },
    ARCHERY {
        @Override
        Integer improveDamage() {
            return 12;
        }

        @Override
        Integer reduceDamage() {
            return 0;
        }

        @Override
        Integer inventorySpace() {
            return 3;
        }
    };

    /**
     * Abstract method responsible for call
     * the number of improve damage in each equipment
     */
    abstract Integer improveDamage();

    /**
     * Abstract method responsible for call
     * the number of reduce damage in each equipment
     */
    abstract Integer reduceDamage();

    /**
     * Abstract method responsible for call
     * the number of inventory space
     */
    abstract Integer inventorySpace();
}
