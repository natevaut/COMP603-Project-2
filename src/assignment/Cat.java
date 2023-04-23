package assignment;

/** @author Alvina Angelin 22152692 */
public class Cat extends Animal {
    
    public Cat() {
        super();
        this.species = Species.CAT;
        
        nutritionStats.put(foods[0] = "biscuits", 0.2f);
        nutritionStats.put(foods[1] = "meat", 0.7f);
        nutritionStats.put(foods[2] = "tuna", 0.4f);
    }
    
    public String toString() {
        return "Cat";
    }
}
