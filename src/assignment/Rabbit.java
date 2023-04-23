package assignment;

/** @author Alvina Angelin 22152692 */
public class Rabbit extends Animal {
    public Rabbit() {
        super();
        this.species = Species.RABBIT;

        foods = new String[] { "lettuce", "carrot", "grass" };

        nutritionStats.put(foods[0], 0.2f);
        nutritionStats.put(foods[1], 0.5f);
        nutritionStats.put(foods[2], 0.1f);
    }

    public String toString() {
        return "Rabbit";
    }

}
