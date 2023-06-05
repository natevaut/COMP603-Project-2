package animals;

/** @author Alvina Angelin 22152692 */
public class Cat extends Animal {

    public Cat() {
        super();
        this.species = Species.CAT;

        nutritionStats.put(foods[0] = "biscuits", 0.2f);
        nutritionStats.put(foods[1] = "meat", 0.7f);
        nutritionStats.put(foods[2] = "tuna", 0.4f);

        hydrationStats.put(liquids[0] = "water", 0.7f);
        hydrationStats.put(liquids[1] = "milk", 0.4f);
        hydrationStats.put(liquids[2] = "juice", 0.1f);

        loveStats.put(actions[0] = "pat", 0.4f);
        loveStats.put(actions[1] = "hug", 0.2f);
        loveStats.put(actions[2] = "scratch", 0.3f);
    }

    public String toString() {
        return "Cat";
    }
}
