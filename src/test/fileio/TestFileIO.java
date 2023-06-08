package test.fileio;

import org.junit.jupiter.api.Test;

import animals.Animal;
import animals.Cat;
import animals.Dog;
import animals.Species;
import fileio.FileIO;

/** @author Nate Evans 21144881 */
public class TestFileIO {

	@Test
	void testSaveToFile() {
		Animal dog = new Dog();
		dog.setName("DAVE");
		assert FileIO.saveToFile(dog);
		Animal cat = new Cat();
		cat.setName("STEVE");
		assert FileIO.saveToFile(cat);
		Animal rabbit = Species.newSpeciesFromString("rabbit");
		rabbit.setName("HARRY");
		assert FileIO.saveToFile(rabbit);
	}

	@Test
	void testLoadFromFile() {
		assert FileIO.loadFromFile().containsKey("DAVE");
		assert FileIO.loadFromFile().containsKey("STEVE");
		assert FileIO.loadFromFile().containsKey("HARRY");
	}

}
