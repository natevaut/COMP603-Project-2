package assignment;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Nate Evans 21144881
 */
public class Program {

    public static void main(String[] args) {

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
        System.out.println("You have four animals to choose from:");
        System.out.println("[D] Dog");
        System.out.println("[C] Cat");
        System.out.println("[R] Rabbit");
        System.out.println("[H] Hamster");

        // User selects a pet
        Animal animal = null;
        do {
            System.out.print("Please select a pet to look after: ");

            char petChar = scanner.nextLine().toUpperCase().charAt(0);

            switch (petChar) {
                case 'D':
                    animal = new Animal(Species.DOG);
                    break;
                case 'C':
                    animal = new Animal(Species.CAT);
                    break;
                case 'R':
                    animal = new Animal(Species.RABBIT);
                    break;
                case 'H':
                    animal = new Animal(Species.HAMSTER);
                    break;
                default:
                    System.out.println("That is not a valid pet option.");
            }
        } while (animal == null);

        // Name the animal
        System.out.print("Name your animal: ");
        String petName = scanner.nextLine();
        animal.setName(petName);
        System.out.println();

        // Print chosen pet
        System.out.println("Chosen pet:");
        System.out.println(animal.toString().toUpperCase());
        System.out.println();
        ASCII.printAnimal(animal);
        System.out.println(petName.toUpperCase());
        System.out.println();

        // Keep the animal alive
        HashMap<String, Float> hydration = animal.getHydrationData();
        while (true) {
            int need = rand.nextInt(4);
            System.out.print(petName + " is ");
            switch (need) {
                case 1: {
                    System.out.println(asPercent(1 - animal.getNutrition()) + "% hungry!");

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
                            System.out.println("That is not a valid food!");
                        }
                        animal.eat(food);
                        System.out.println("Replenished " + petName + "'s hunger to " + asPercent(animal.getNutrition()));
                    }
                    break;
                }
                case 2: {
                    System.out.println("thirsty!");
                    break;
                }
                case 3: {
                    System.out.println("lonely :(");
                    break;
                }
            }
        }

    }

    private String asPercent(float amount) {
        return String.format("%.1f%%", amount * 100);
    }

}
