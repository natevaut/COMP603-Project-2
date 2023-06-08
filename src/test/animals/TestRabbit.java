package test.animals;

import org.junit.jupiter.api.Test;

import animals.Rabbit;

/** @author Alvina Angelin 22152692 */

class TestRabbit {
	@Test
	void testRabbit() {
		assert new Rabbit().getSpecies().name().equalsIgnoreCase("rabbit");
	}

	@Test
	void testRabbitStats() {
		Rabbit rabbit = new Rabbit();
		rabbit.drink("water");
		assert rabbit.getHydration() == 0.7f;
		rabbit.drink("juice");
		assert rabbit.getHydration() == 0.8f;
		rabbit.eat("carrot");
		assert rabbit.getNutrition() == 0.6f;
		rabbit.receive("pat");
		assert rabbit.getLove() == 0.4f;
		rabbit.receive("cuddle");
		assert rabbit.getLove() == 0.7f;
	}
}