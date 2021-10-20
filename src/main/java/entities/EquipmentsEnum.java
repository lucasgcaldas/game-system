package entities;

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

    abstract Integer improveDamage();
    abstract Integer reduceDamage();
    abstract Integer inventorySpace();
}
