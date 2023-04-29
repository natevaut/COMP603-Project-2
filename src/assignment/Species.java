package assignment;

/** @author Nate Evans 21144881 */
public enum Species {
    DOG, CAT, RABBIT, HAMSTER, FROG;

    public static String[] getSpeciesList() {
        return new String[] { "Dog", "Cat", "Rabbit", "Hamster", "Frog" };
    }

    /**
     * Converts a species string into a new instance of an animal subclass
     */
    public static Animal newSpeciesFromString(String species) {
        species = species.toLowerCase();
        switch (species) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            case "rabbit":
                return new Rabbit();
            case "hamster":
                return new Hamster();
            case "frog":
                return new Frog();
        }
        return null;
    }
}
