package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/** @author Nate Evans 21144881 */
public class FileIO {

	public static final String FILENAME = "pets.txt";

	public static boolean saveToFile(Animal animal) {
		while (!createPetsFile());

		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(FILENAME, true));
			pw.printf("%s", animal.getName().toUpperCase());
			pw.print(":");
			pw.printf("spec=%s", animal.getSpecies());
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
				unused = scan.next(); // ignore `spec=
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

}
