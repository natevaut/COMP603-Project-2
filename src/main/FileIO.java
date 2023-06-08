package main;

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
		while (!createPetsFile());

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
	 * Loads all animals from the pets file and returns them as a hash map of names to animal data
	 */
	public static HashMap<String, Animal> loadFromFile() {
		while (!createPetsFile());

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

				Animal pet = Species.newSpeciesFromString(species);
				pet.loadAttributes(name, nutrition, hydration, love);

				if (pets.containsKey(name))
				    pets.remove(name);
				pets.put(name, pet);
			}

			br.close();

		} catch (FileNotFoundException e) {
			while (!createPetsFile());
		} catch (IOException e) {
		}

		return pets;
	}

	/**
	 * Sets up the pets file
	 */
	public static boolean createPetsFile() {
		File file = new File(FILENAME);
	    if (file.exists()) {
	    	return true;
	    } else {
	        try {
	            file.createNewFile();
	            return true;
	        } catch (IOException err) {
	            return false;
	        }
	    }
	}

	/**
	 * Removes duplicate animals from the pets file
	 */
	public static void cleanDuplicates() {
		HashMap<String, Animal> animals = loadFromFile();
		File file = new File(FILENAME);

		if (file.exists())
			file.delete();
		while (!createPetsFile());

		for (Animal animal : animals.values()) {
			saveToFile(animal);
		}

	}

}
