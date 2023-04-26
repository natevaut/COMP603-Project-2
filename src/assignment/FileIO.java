package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/** @author Nate Evans 21144881 */
public class FileIO {

	public static final String FILENAME = "pet.txt";
	
	private static final char DELIM = '=';

	public static boolean saveToFile(Animal animal) {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(FILENAME));
			pw.printf("species%c%s\n", DELIM, animal.getSpecies());
			pw.printf("name%c%s\n", DELIM, animal.getName());
			pw.printf("nutrition%c%f\n", DELIM, animal.getNutrition());
			pw.printf("hydration%c%f\n", DELIM, animal.getHydration());
			pw.printf("love%c%f\n", DELIM, animal.getLove());
			pw.close();
			return true;
		} catch (FileNotFoundException err) {
			return false;
		}
	}

	public static Animal loadFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILENAME));

			String species = null, name = null;
			float nutrition = 0, hydration = 0, love = 0;

			// load the file contents
			for (String line = ""; (line = br.readLine()) != null;) {
				String[] parts = line.split(DELIM + "");
				String key = parts[0], val = parts[1];
				if (key.equals("species"))
					species = val.toLowerCase();
				else if (key.equals("name"))
					name = val;
				else if (key.equals("nutrition"))
					nutrition = Float.parseFloat(val);
				else if (key.equals("hydration"))
					hydration = Float.parseFloat(val);
				else if (key.equals("love"))
					love = Float.parseFloat(val);
			}

			// initialise the animal with the loaded data
			Animal animal = null;
			if (species.equals("dog"))
				animal = new Dog();
			else if (species.equals("cat"))
				animal = new Cat();
			else if (species.equals("rabbit"))
				animal = new Rabbit();
			else if (species.equals("hamster"))
				animal = new Hamster();
			
			animal.loadAttributes(name, nutrition, hydration, love);

			br.close();

			return animal;

		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

}
