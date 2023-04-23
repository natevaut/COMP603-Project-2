package assignment;

/** @author Alvina Angelin 22152692 */
public class Dog extends Animal {

    public Dog() {
        super();
        this.species = Species.DOG;

        foods = new String[] { "kibble", "meat", "bone" };

        nutritionStats.put(foods[0], 0.2f);
        nutritionStats.put(foods[1], 0.5f);
        nutritionStats.put(foods[2], 0.1f);
    }

    public String toString() {
        return "Dog";
    }

}
