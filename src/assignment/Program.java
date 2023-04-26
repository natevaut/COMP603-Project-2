package assignment;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/** @author Nate Evans 21144881 */
public class Program {

    private static boolean running;

    public static void main(String[] args) {
        running = true;

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("----------------");
        System.out.println("");
        System.out.println(" PET SIMULATOR ");
        System.out.println("");
        System.out.println("----------------");
        System.out.println("");

        System.out.println("Welcome to PET SIMULATOR.");
        System.out.println("Please adopt a pet!");
        System.out.println("");

        Animal animal = null;
        boolean animalInvalid = false;
        
        // ask if user has pet already saved to disc
        char ans = '\0';
        while (true) {
            System.out.println("Do you already have a pet?");
            ans = scanner.nextLine().charAt(0);
            if (ans == 'y' || ans == 'n')
                break;
            System.out.println("Invalid answer!");
        }
        System.out.println();

        // load one from disc
        if (ans == 'y') {

            System.out.println("Loading pet from disc...");
            animal = FileIO.loadFromFile();

            if (animal == null) {
	            System.out.println("No animal saved!");
	            System.out.println("Please adopt a new pet.");
	            System.out.println();
            	animalInvalid = true;
            } else {
	            String species = animal.getSpecies().toString().toLowerCase();
	            System.out.println("Loaded your pet " + species + ": " + animal.getName());
	            System.out.println();
	        }

        }

        if (ans == 'n' || animalInvalid) {

            System.out.println("You have four animals to choose from:");
            String[] speciesList = Species.getSpeciesList();
            for (String species : speciesList) {
            	System.out.println("- " + species);
            }
            System.out.println();

            // User selects a pet
            do {
                System.out.print("Please select a pet to look after: ");
                String pet = scanner.nextLine().toLowerCase();
                animal = Species.newSpeciesFromString(pet);
                if (animal == null) { 
                    System.out.println("That is not a valid pet option.");
                }
            } while (animal == null);

            // Name the animal
            System.out.print("Name your animal: ");
            String petName = scanner.nextLine();
            animal.setName(petName);
            System.out.println();
        
        }

        // Print pet
        String petName = animal.getName();
        System.out.println("Your pet:");
        System.out.println(animal.toString().toUpperCase());
        System.out.println();
        ASCII.printAnimal(animal);
        System.out.println(petName.toUpperCase());
        System.out.println();

        // Keep the animal alive
        // main loop
        while (running) {
            int need = rand.nextInt(3);
            System.out.println();
            System.out.print(petName + " is ");
            switch (need) {
                case 0: { // hungry
                    animal.makeHungry();
                    System.out.println(asPercent(1 - animal.getNutrition()) + " hungry!");

                    String[] foods = animal.getFoods();
                    HashMap<String, Float> nutrition = animal.getNutritionData();

                    String food = null;
                    while (food == null) {
                        System.out.println("What will you feed " + petName + "?");
                        System.out.printf("%s, %s, or %s\n", foods[0], foods[1], foods[2]);

                        String inputFood = scanner.next().toLowerCase();
                        if (nutrition.containsKey(inputFood)) {
                            food = inputFood;
                        } else {
                            System.out.println("That is not a valid food!\n");
                        }
                        animal.eat(food);
                        System.out.println("Replenished " + petName + "'s hunger to " + asPercent(animal.getNutrition()));
                    }
                    break;
                }
                case 1: { // thirsty
                    animal.makeThirsty();
                    System.out.println(asPercent(1 - animal.getHydration()) + " thirsty!");

                    String[] drinks = animal.getLiquids();
                    HashMap<String, Float> hydration = animal.getHydrationData();

                    String drink = null;
                    while (drink == null) {
                        System.out.println("What will you give " + petName + "?");
                        System.out.printf("%s, %s, or %s\n", drinks[0], drinks[1], drinks[2]);

                        String inputDrink = scanner.next().toLowerCase();
                        if (hydration.containsKey(inputDrink)) {
                            drink = inputDrink;
                        } else {
                            System.out.println("That is not a valid drink!\n");
                        }
                        animal.drink(drink);
                        System.out.println("Replenished " + petName + "'s thirst to " + asPercent(animal.getHydration()));
                    }
                    break;
                }
                case 2: { // lonely
                    animal.makeLonely();
                    System.out.println(asPercent(1 - animal.getLove()) + " lonely :(");

                    String[] loving = animal.getActions();
                    HashMap<String, Float> love = animal.getLoveData();

                    String action = null;
                    while (action == null) {
                        System.out.println("What will you give " + petName + "?");
                        System.out.printf("%s, %s, or %s\n", loving[0], loving[1], loving[2]);

                        String inputAction = scanner.next().toLowerCase();
                        if (love.containsKey(inputAction)) {
                            action = inputAction;
                        } else {
                            System.out.println("That is not a valid action!\n");
                        }
                        animal.receive(action);
                        System.out.println("Replenished " + petName + "'s love meter to " + asPercent(animal.getLove()));
                    }
                    break;
                }
            }

            char input;
            System.out.println("Do you want to continue with your pet?");
            input = scanner.next().toLowerCase().charAt(0);
            // save pet to disc and exit
            if (input != 'y') {
                System.out.println("Saving pet to file...");
                FileIO.saveToFile(animal);
                System.out.println("Exiting program");
                running = false;
            }
        }
        
        scanner.close();

    }

    private static String asPercent(float amount) {
        return String.format("%.1f%%", amount * 100);
    }

}
