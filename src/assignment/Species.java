package assignment;

/** @author Nate Evans 21144881 */
public enum Species {
    DOG, CAT, RABBIT, HAMSTER, FROG;

    public static String[] getSpeciesList() {
        return new String[] { "Dog", "Cat", "Rabbit", "Hamster", "Frog" };
    }
    
    public static Animal newSpeciesFromString(String species) {
        switch (species) {
            case "Dog":
                return new Dog();
            case "Cat":
                return new Cat();
            case "Rabbit":
                return new Rabbit();
            case "Hamster":
                return new Hamster();
            case "Frog":
                return new Frog();
        }
        return null;
    }
}
