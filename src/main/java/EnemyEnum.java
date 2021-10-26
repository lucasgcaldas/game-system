public enum EnemyEnum {

    DRAGON {
        @Override
        Integer life() {
            return 87;
        }

        @Override
        Integer attack() {
            return 20;
        }

        @Override
        Integer defense() {
            return 20;
        }

        @Override
        Integer magicPointDamage() {
            return 10;
        }

        @Override
        Integer attackPointOnForest() {
            return this.attack();
        }

        @Override
        Integer attackPointOnDesert() {
            return 0;
        }

        @Override
        Integer attackPointOnRiver() {
            return 0;
        }
    },
    GOBLIN {
        @Override
        Integer life() {
            return 83;
        }

        @Override
        Integer attack() {
            return 18;
        }

        @Override
        Integer defense() {
            return 15;
        }

        @Override
        Integer magicPointDamage() {
            return 11;
        }

        @Override
        Integer attackPointOnForest() {
            return 0;
        }

        @Override
        Integer attackPointOnDesert() {
            return 0;
        }

        @Override
        Integer attackPointOnRiver() {
            return 0;
        }
    },
    ZOMBIE {
        @Override
        Integer life() {
            return 80;
        }

        @Override
        Integer attack() {
            return 10;
        }

        @Override
        Integer defense() {
            return 10;
        }

        @Override
        Integer magicPointDamage() {
            return 12;
        }

        @Override
        Integer attackPointOnForest() {
            return 0;
        }

        @Override
        Integer attackPointOnDesert() {
            return 0;
        }

        @Override
        Integer attackPointOnRiver() {
            return 0;
        }
    };

    /**
     * Method responsible for get
     * enemy life
     *
     * @return Integer
     */
    abstract Integer life();

    /**
     * Method responsible for get
     * enemy attack
     *
     * @return Integer
     */
    abstract Integer attack();

    /**
     * Method responsible for get
     * enemy defense
     *
     * @return Integer
     */
    abstract Integer defense();

    /**
     * Method responsible for get
     * enemy magicPointDamage
     *
     * @return Integer
     */
    abstract Integer magicPointDamage();

    /**
     * Method responsible for get
     * enemy attackPointOnForest
     *
     * @return Integer
     */
    abstract Integer attackPointOnForest();

    /**
     * Method responsible for get
     * enemy attackPointOnDesert
     *
     * @return Integer
     */
    abstract Integer attackPointOnDesert();

    /**
     * Method responsible for get
     * enemy attackPointOnRiver
     *
     * @return Integer
     */
    abstract Integer attackPointOnRiver();
}
