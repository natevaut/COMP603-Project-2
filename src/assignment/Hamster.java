package assignment;

/** @author Alvina Angelin 22152692 */
public class Hamster extends Animal {
  
    public Hamster() {
        super();
        this.species = Species.HAMSTER;

        nutritionStats.put(foods[0] = "seeds", 0.1f);
        nutritionStats.put(foods[1] = "carrot", 0.6f);
        nutritionStats.put(foods[2] = "pellets", 0.2f);
        
        hydrationStats.put(liquids[0] = "water", 0.7f);
        hydrationStats.put(liquids[1] = "milk", 0.2f);
        hydrationStats.put(liquids[2] = "juice", 0.1f);
        
        loveStats.put(actions[0] = "pat", 0.4f);
        loveStats.put(actions[1] = "hug", 0.2f);
        loveStats.put(actions[2] = "roller ball", 0.3f);
    }

    public String toString() {
        return "Hamster";
    }  
}
