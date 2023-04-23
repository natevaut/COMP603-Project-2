package assignment;

/** @author Alvina Angelin 22152692 */
public class Cat extends Animal {
    
    public Cat() {
        super();
        this.species = Species.CAT;
        
        foods = new String[] { "biscuits", "meat", "tuna" };

        nutritionStats.put(foods[0], 0.2f);
        nutritionStats.put(foods[1], 0.5f);
        nutritionStats.put(foods[2], 0.1f);
    }
    
    public String toString() {
        return "Cat";
    }
}
