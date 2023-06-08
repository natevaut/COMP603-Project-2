package animals;

import org.junit.Test;

/** @author Alvina Angelin 22152692 */
public class HamsterTest {

    @Test
    public void testHamster() {
        assert new Hamster().getSpecies().name().equalsIgnoreCase("hamster");
    }

    @Test
    public void testHamsterStats() {
        Hamster hamster = new Hamster();
        hamster.drink("water");
        assert hamster.getHydration() == 0.7f;
        hamster.drink("juice");
        assert hamster.getHydration() == 0.8f;
        hamster.eat("seeds");
        assert hamster.getNutrition() == 0.1f;
        hamster.receive("pat");
        assert hamster.getLove() == 0.4f;
        hamster.receive("hug");
        assert hamster.getLove() == 0.6f;
    }
}
