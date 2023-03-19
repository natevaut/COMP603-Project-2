package assignment;

import java.util.HashMap;

/**
 * @author Nate Evans 21144881
 */
public class Animal {

    private Species species;
    private String[] foods;
    private HashMap<String, Float> nutrition;

    public Animal(Species species) {
        this.species = species;
        nutrition = new HashMap<>();

        switch (species) {
            case DOG:
                foods = new String[]{"Kibble", "Meat", "Bone"};
                nutrition.put("Kibble", 0.20f);
                nutrition.put("Meat", 0.50f);
                nutrition.put("Bone", 0.05f);
                break;
            case CAT:
                foods = new String[]{"Biscuits", "Meat", "Milk"};
                nutrition.put("Biscuits", 0.20f);
                nutrition.put("Meat", 0.50f);
                nutrition.put("Milk", 0.10f);
                break;
            case RABBIT:
                foods = new String[]{"Lettuce", "Carrot", "Grass"};
                nutrition.put("Lettuce", 0.20f);
                nutrition.put("Carrot", 0.40f);
                nutrition.put("Grass", 0.10f);
                break;
            case HAMSTER:
                foods = new String[]{"Seeds", "Carrot", "Pellets"};
                nutrition.put("Seeds", 0.10f);
                nutrition.put("Carrot", 0.40f);
                nutrition.put("Pellets", 0.10f);
                break;
        }
    }
    
    public String[] getFoods() {
        return this.foods;
    }
    
    public HashMap<String,Float> getNutritionData() {
        return this.nutrition;
    }
    
    public Species getSpecies() {
        return this.species;
    }
    
    /**
     * @author Alvina Angelin 22152692
     */
    public String toString() {
        switch (species) {
            case DOG:
                return "Dog";
            case CAT:
                return "Cat";
            case HAMSTER:
                return "Hamster";
            case RABBIT:
                return "Rabbit";
            default:
                return "";
        }
    }
    
    public String name;
    
    public void setName() {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
