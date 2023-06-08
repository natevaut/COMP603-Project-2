package test.animals;

import org.junit.jupiter.api.Test;

import animals.Dog;

/** @author Nate Evans 21144881 */
class TestDog {
	@Test
	void testDog() {
		assert new Dog().getSpecies().name().equalsIgnoreCase("dog");
	}

	@Test
	void testDogStats() {
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
		assert dog.getLove() == 0.7f;
	}
}