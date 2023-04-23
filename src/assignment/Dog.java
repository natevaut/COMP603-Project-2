package assignment;

/** @author Alvina Angelin 22152692 */
public class Dog extends Animal {

    public Dog() {
        super();
        this.species = Species.DOG;

        nutritionStats.put(foods[0] = "kibble", 0.2f);
        nutritionStats.put(foods[1] = "meat", 0.7f);
        nutritionStats.put(foods[2] = "bone", 0.1f);
    }

    public String toString() {
        return "Dog";
    }

}
