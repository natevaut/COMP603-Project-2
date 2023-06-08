package test.animals;

import org.junit.jupiter.api.Test;

import animals.Animal;

public class TestAnimal {

	@Test
	void testNewAnimals() {
		Animal animal = new Animal() {
		};

		assert animal.getName() == null;
		assert animal.getNutrition() == 0.0f;
		assert animal.getHydration() == 0.0f;
		assert animal.getLove() == 0.0f;
	}

	@Test
	void testLoadAttributes() {
		Animal animal = new Animal() {
		};
		animal.loadAttributes("Pete", 0.5f, 0.4f, 0.6f);

		assert animal.getName().equalsIgnoreCase("Pete");
		assert animal.getNutrition() == 0.5f;
		assert animal.getHydration() == 0.4f;
		assert animal.getLove() == 0.6f;
	}

	@Test
	void testReduceStats() {
		Animal animal = new Animal() {
		};
		animal.loadAttributes("Ana", 1, 1, 1);
		animal.makeHungry();
		assert animal.getNutrition() < 1;
		animal.makeThirsty();
		assert animal.getHydration() < 1;
		animal.makeLonely();
		assert animal.getLove() < 1;
	}

}
