package assignment;

/** @author Alvina Angelin 22152692 */
public class Frog extends Animal {

    public Frog() {
        super();
        this.species = Species.FROG;

        nutritionStats.put(foods[0] = "fly", 0.4f);
        nutritionStats.put(foods[1] = "snail", 0.6f);
        nutritionStats.put(foods[2] = "worm", 0.2f);
    }

    public String toString() {
        return "Frog";
    }
}
