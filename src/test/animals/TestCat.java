package test.animals;

import org.junit.jupiter.api.Test;

import animals.Cat;

/** @author Nate Evans 21144881 */
class TestCat {
	@Test
	void testCat() {
		assert new Cat().getSpecies().name().equalsIgnoreCase("cat");
	}

	@Test
	void testCatStats() {
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