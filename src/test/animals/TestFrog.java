package test.animals;

import org.junit.jupiter.api.Test;

import animals.Frog;

/** @author Nate Evans 21144881 */
class TestFrog {
    @Test
    void testFrog() {
        assert new Frog().getSpecies().name().equalsIgnoreCase("frog");
    }

    @Test
    void testFrogStats() {
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
