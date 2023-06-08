package animals;

import org.junit.Test;

/** @author Alvina Angelin 22152692 */
public class FrogTest {

    @Test
    public void testFrog() {
        assert new Frog().getSpecies().name().equalsIgnoreCase("frog");
    }

    @Test
    public void testFrogStats() {
        Frog frog = new Frog();
        frog.drink("water");
        assert frog.getHydration() == 0.7f;
        frog.drink("milk");
        assert frog.getHydration() == 0.9f;
        frog.eat("fly");
        assert frog.getNutrition() == 0.4f;
        frog.eat("worm");
        assert frog.getNutrition() == 0.6f;
        frog.receive("scratch");
        assert frog.getLove() == 0.3f;
    }
}
