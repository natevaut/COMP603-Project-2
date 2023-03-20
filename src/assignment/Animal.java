package assignment;

import java.util.HashMap;

public class Animal {

    private Species species;
    private String[] foods, liquids;
    private String name;
    private double nutrition;
    private double hydration;
    //percentages
    private HashMap<String, Float> nutritionStats, hydrationStats;

    /**
     * @author Nate Evans 21144881
     */
    public Animal(Species species) {
        this.species = species;

        switch (species) {
            case DOG:
                foods = new String[]{"kibble", "meat", "bone"};
                break;
            case CAT:
                foods = new String[]{"biscuits", "meat", "tuna"};
                break;
            case RABBIT:
                foods = new String[]{"lettuce", "carrot", "grass"};
                break;
            case HAMSTER:
                foods = new String[]{"seeds", "carrot", "pellets"};
                break;
        }
        nutritionStats = new HashMap<>();
        nutritionStats.put(foods[0], 0.2f);
        nutritionStats.put(foods[1], 0.5f);
        nutritionStats.put(foods[2], 0.1f);

        liquids = new String[]{"water", "milk", "juice"};
        hydrationStats = new HashMap<>();
        hydrationStats.put(liquids[0], 0.7f);
        hydrationStats.put(liquids[1], 0.1f);
        hydrationStats.put(liquids[2], 0.0f);

    }

    /**
     * @author Nate Evans 21144881
     */
    public String[] getFoods() {
        return this.foods;
    }

    /**
     * @author Nate Evans 21144881
     */
    public HashMap<String, Float> getNutritionData() {
        return this.nutritionStats;
    }

    /**
     * @author Nate Evans 21144881
     */
    public String[] getLiquids() {
        return this.liquids;
    }

    /**
     * @author Nate Evans 21144881
     */
    public HashMap<String, Float> getHydrationData() {
        return this.hydrationStats;
    }

    /**
     * @author Nate Evans 21144881
     */
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

    /**
     * @author Alvina Angelin 22152692
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * @author Alvina Angelin 22152692
     */
    public void setHydration(double hydration) {
        this.hydration = hydration;
    }
    
     /**
     * @author Alvina Angelin 22152692
     */
    public double hydration() {
        return this.hydration;
    }
    
    /**
     * @author Alvina Angelin 22152692
     */
    public void setNutrition(double nutrition) {
        this.nutrition = nutrition;
    }
    
    /**
     * @author Alvina Angelin 22152692
     */
    public double getNutrition() {
        return this.nutrition;
    }
    
    /**
     * @author Alvina Angelin 22152692
     */
    public void eat(String food) {
        if(nutritionStats.containsKey(food)) {
            float nutritionValue = nutritionStats.get(food);
            nutrition += nutritionValue;
        }
        else {
            System.out.println("Invalid input");
        }
    }
    
    /**
     * @author Alvina Angelin 22152692
     */
    public void drink (String liquid) {
        if (hydrationStats.containsKey(liquid)) {
            float hydrationValue = hydrationStats.get(liquid);
            hydration += hydrationValue;
        }
        else {
            System.out.println("Invalid input");
        }
    }
}
