package assignment;

/** @author Alvina Angelin 22152692 */
public class Hamster extends Animal {
  
    public Hamster() {
        super();
        this.species = Species.HAMSTER;

        foods = new String[] { "seeds", "carrot", "pellets" };

        nutritionStats.put(foods[0], 0.2f);
        nutritionStats.put(foods[1], 0.5f);
        nutritionStats.put(foods[2], 0.1f);
    }

    public String toString() {
        return "Hamster";
    }  
}
