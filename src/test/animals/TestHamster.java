package test.animals;

import org.junit.jupiter.api.Test;

import animals.Hamster;

/** @author Alvina Angelin 22152692 */

class TestHamster {
	@Test
	void testHamster() {
		assert new Hamster().getSpecies().name().equalsIgnoreCase("hamster");
	}

	@Test
	void testHamsterStats() {
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