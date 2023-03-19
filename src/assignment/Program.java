package assignment;

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

            char petChar = scanner.next().toUpperCase().charAt(0);

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
        System.out.println("Name your animal: ");
        String petName = scanner.nextLine();
        System.out.println();

        // Print chosen pet
        System.out.println("Chosen pet:");
        System.out.println(animal.toString().toUpperCase());
        System.out.println();
        System.out.println(animal.getName().toUpperCase());
        ASCII.printAnimal(animal);
        System.out.println();
        

    }

}
