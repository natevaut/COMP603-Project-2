package fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import animals.Animal;
import animals.Species;

/** @author Nate Evans 21144881 */
public class FileIO {

	public static final String FILENAME = "pets.txt";

	/**
	 * Saves a new animal to the pets file
	 */
	public static boolean saveToFile(Animal animal) {
		touchPetsFile();

		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(FILENAME, true));
			pw.printf("%s", animal.getName().toUpperCase());
			pw.print(":");
			pw.printf("type=%s", animal.getSpecies());
			pw.print(",");
			pw.printf("nutr=%f", animal.getNutrition());
			pw.print(",");
			pw.printf("hydr=%f", animal.getHydration());
			pw.print(",");
			pw.printf("love=%f", animal.getLove());
			pw.println();
			pw.close();
			return true;
		} catch (FileNotFoundException err) {
			return false;
		}
	}

	/**
	 * Save all pets to the pets file
	 */
	public static void saveToFile(HashMap<String, Animal> pets) {
		newPetsFile();
		for (Animal animal : pets.values()) {
			saveToFile(animal);
		}
	}

	/**
	 * Loads all animals from the pets file and returns them as a hash map of names
	 * to animal data
	 */
	public static HashMap<String, Animal> loadFromFile() {
		touchPetsFile();

		HashMap<String, Animal> pets = new HashMap<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(FILENAME));

			// load the file contents
			for (String line = ""; (line = br.readLine()) != null;) {
				Scanner scan = new Scanner(line);
				scan.useDelimiter("[:,=]");

				String unused;
				String name = scan.next();
				unused = scan.next(); // ignore `type=
				String species = scan.next();
				unused = scan.next(); // ignore `nutr=
				float nutrition = scan.nextFloat();
				unused = scan.next(); // ignore `hydr=
				float hydration = scan.nextFloat();
				unused = scan.next(); // ignore `love=
				float love = scan.nextFloat();

				Animal pet = Animal.createPet(species, name, nutrition, hydration, love);
				if (pets.containsKey(name))
					pets.remove(name);
				pets.put(name, pet);
			}

			br.close();

		} catch (FileNotFoundException e) {
			newPetsFile();
		} catch (IOException e) {
		}

		return pets;
	}

	/**
	 * Creates the pets file if it does not yet exist.
	 */
	public static void touchPetsFile() {
		newPetsFile(false);
	}

	/**
	 * Sets up the pets file. Deletes file if it already exists.
	 */
	public static void newPetsFile() {
		newPetsFile(true);
	}

	/**
	 * Create the pets file. Used in the public pets file methods.
	 */
	private static void newPetsFile(boolean overwrite) {
		File file = new File(FILENAME);

		if (file.exists()) {
			if (overwrite)
				file.delete();
			else
				return;
		}

		try {
			file.createNewFile();
		} catch (IOException err) {
			err.printStackTrace();
		}
	}

}
