package assignment;

/** @author Alvina Angelin 22152692 */
public class Dog extends Animal {

    public Dog() {
        super();
        this.species = Species.DOG;

        nutritionStats.put(foods[0] = "kibble", 0.2f);
        nutritionStats.put(foods[1] = "meat", 0.7f);
        nutritionStats.put(foods[2] = "bone", 0.1f);

        hydrationStats.put(liquids[0] = "water", 0.7f);
        hydrationStats.put(liquids[1] = "milk", 0.4f);
        hydrationStats.put(liquids[2] = "juice", 0.1f);

        loveStats.put(actions[0] = "walk", 0.4f);
        loveStats.put(actions[1] = "fetch", 0.2f);
        loveStats.put(actions[2] = "pat", 0.3f);
    }

    public String toString() {
        return "Dog";
    }

}
