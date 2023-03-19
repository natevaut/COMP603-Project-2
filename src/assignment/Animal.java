package assignment;

import java.util.HashMap;

public class Animal {

    private Species species;
    private String[] foods, liquids;
    private HashMap<String, Float> nutrition, hydration; // percentage
    private String name;

    /**
     * @author Nate Evans 21144881
     */
    public Animal(Species species) {
        this.species = species;
        nutrition = new HashMap<>();

        switch (species) {
            case DOG:
                foods = new String[]{"Kibble", "Meat", "Bone"};
                break;
            case CAT:
                foods = new String[]{"Biscuits", "Meat", "Milk"};
                break;
            case RABBIT:
                foods = new String[]{"Lettuce", "Carrot", "Grass"};
                break;
            case HAMSTER:
                foods = new String[]{"Seeds", "Carrot", "Pellets"};
                break;
        }
        nutrition.put(foods[0], 0.2f);
        nutrition.put(foods[1], 0.5f);
        nutrition.put(foods[2], 0.1f);

        liquids = new String[]{"water", "milk", "juice"};
        hydration.put(liquids[0], 0.7f);
        hydration.put(liquids[1], 0.1f);
        hydration.put(liquids[2], 0.0f);

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
        return this.nutrition;
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
        return this.hydration;
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
}
