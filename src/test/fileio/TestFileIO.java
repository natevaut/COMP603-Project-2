package test.fileio;

import org.junit.jupiter.api.Test;

import animals.Cat;
import animals.Dog;
import animals.Species;
import fileio.FileIO;

public class TestFileIO {

	@Test
	void testSaveToFile() {
		Dog dog = new Dog();
		dog.setName("DAVE");
		assert FileIO.saveToFile(dog);
		Cat cat = new Cat();
		cat.setName("STEVE");
		assert FileIO.saveToFile(cat);
		assert FileIO.saveToFile(Species.newSpeciesFromString("rabbit"));
	}

	@Test
	void testLoadFromFile() {
		assert FileIO.loadFromFile().containsKey("DAVE");
		assert FileIO.loadFromFile().containsKey("STEVE");
	}

}
