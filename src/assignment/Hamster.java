package assignment;

/** @author Alvina Angelin 22152692 */
public class Hamster extends Animal {
  
    public Hamster() {
        super();
        this.species = Species.HAMSTER;

        nutritionStats.put(foods[0] = "seeds", 0.1f);
        nutritionStats.put(foods[1] = "carrot", 0.6f);
        nutritionStats.put(foods[2] = "pellets", 0.2f);
    }

    public String toString() {
        return "Hamster";
    }  
}
