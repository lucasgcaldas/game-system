import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    private Equipment armor, sword, archery;

    @BeforeEach
    public void start() {
        this.armor = new Equipment(EquipmentsEnum.ARMOR);
        this.sword = new Equipment(EquipmentsEnum.SWORD);
        this.archery = new Equipment(EquipmentsEnum.ARCHERY);
    }

    @Test
    public void shouldImproveDamage() {
        Assertions.assertAll(() -> assertEquals(0, armor.getImproveDamage()),
                             () -> assertEquals(8, sword.getImproveDamage()),
                             () -> assertEquals(12, archery.getImproveDamage()));
    }

    @Test
    public void shouldReduceDamage() {
        Assertions.assertAll(() -> assertEquals(6, armor.getReduceDamage()),
                             () -> assertEquals(3, sword.getReduceDamage()),
                             () -> assertEquals(0, archery.getReduceDamage()));
    }

    @Test
    public void shouldShowInventorySpace() {
        Assertions.assertAll(() -> assertEquals(4, armor.getInventorySpace()),
                             () -> assertEquals(2, sword.getInventorySpace()),
                             () -> assertEquals(3, archery.getInventorySpace()));
    }
}