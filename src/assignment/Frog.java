package assignment;

/** @author Alvina Angelin 22152692 */
public class Frog extends Animal {

    public Frog() {
        super();
        this.species = Species.FROG;

        nutritionStats.put(foods[0] = "fly", 0.4f);
        nutritionStats.put(foods[1] = "snail", 0.6f);
        nutritionStats.put(foods[2] = "worm", 0.2f);
        
        hydrationStats.put(liquids[0] = "water", 0.7f);
        hydrationStats.put(liquids[1] = "milk", 0.2f);
        hydrationStats.put(liquids[2] = "juice", 0.1f);
        
        loveStats.put(actions[0] = "pat", 0.4f);
        loveStats.put(actions[1] = "hug", 0.2f);
        loveStats.put(actions[2] = "scratch", 0.3f);
    }

    public String toString() {
        return "Frog";
    }
}
