package animals;

import org.junit.Test;

/** @author Alvina Angelin 22152692 */
public class DogTest {

    @Test
    public void testDog() {
        assert new Dog().getSpecies().name().equalsIgnoreCase("dog");
    }

    @Test
    public void testDogStats() {
        Dog dog = new Dog();
        dog.drink("water");
        assert dog.getHydration() == 0.7f;
        dog.drink("water");
        assert dog.getHydration() == 1.0f;
        dog.eat("meat");
        assert dog.getNutrition() == 0.7f;
        dog.receive("pat");
        assert dog.getLove() == 0.3f;
        dog.receive("walk");
        assert dog.getLove() - 0.7f < 0.0001f;
    }
}
