package animals;

import org.junit.Test;

/** @author Alvina Angelin 22152692 */
public class CatTest {

    @Test
    public void testCat() {
        assert new Cat().getSpecies().name().equalsIgnoreCase("cat");
    }

    @Test
    public void testCatStats() {
        Cat cat = new Cat();
        cat.drink("water");
        assert cat.getHydration() == 0.7f;
        cat.drink("juice");
        assert cat.getHydration() == 0.8f;
        cat.eat("tuna");
        assert cat.getNutrition() == 0.4f;
        cat.receive("pat");
        assert cat.getLove() == 0.4f;
        cat.receive("hug");
        assert cat.getLove() == 0.6f;
    }
}
