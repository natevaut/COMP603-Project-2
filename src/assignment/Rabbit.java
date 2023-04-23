package assignment;

/** @author Alvina Angelin 22152692 */
public class Rabbit extends Animal {
    public Rabbit() {
        super();
        this.species = Species.RABBIT;

        nutritionStats.put(foods[0] = "lettuce", 0.2f);
        nutritionStats.put(foods[1] = "carrots", 0.6f);
        nutritionStats.put(foods[2] = "grass", 0.1f);
    }

    public String toString() {
        return "Rabbit";
    }

}
