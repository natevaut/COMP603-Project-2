package assignment;

import java.util.HashMap;
import java.util.Random;

public class Animal {

    private Species species;
    private String[] foods, liquids, actions;
    private String name;
    private float nutrition, hydration, love;
    private HashMap<String, Float> nutritionStats, hydrationStats, loveStats;

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

        actions = new String[]{"pat", "hug", "kiss"};
        loveStats.put(actions[0], 0.4f);
        loveStats.put(actions[1], 0.3f);
        loveStats.put(actions[2], 0.1f);

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
    public HashMap<String, Float> getLoveData() {
        return this.loveStats;
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
    public void setHydration(float hydration) {
        this.hydration = hydration;
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public float getHydration() {
        return this.hydration;
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public void setNutrition(float nutrition) {
        this.nutrition = nutrition;
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public float getNutrition() {
        return this.nutrition;
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public void setLove(float love) {
        this.love = love;
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public float getLove() {
        return this.love;
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public void eat(String food) {
        if (nutritionStats.containsKey(food)) {
            nutrition += nutritionStats.get(food);
        } else {
            System.out.println("Invalid input");
        }
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public void drink(String liquid) {
        if (hydrationStats.containsKey(liquid)) {
            hydration = hydrationStats.get(liquid);
        } else {
            System.out.println("Invalid input");
        }
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public void receive(String actions) {
        if (loveStats.containsKey(actions)) {
            love = loveStats.get(actions);
        } else {
            System.out.println("Invalid input");
        }
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public float decreaseStats(float value, float percentage) {
        float amount = (float) Math.round(value * (percentage / 100.0));
        return Math.max(value - amount, 0);
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public void makeHungry() {
        Random random = new Random();
        float decrease = random.nextFloat(0.4f) + 0.1f;
        this.nutrition = decreaseStats(this.nutrition, decrease);
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public void makeThirsty() {
        Random random = new Random();
        float decrease = random.nextFloat(0.4f) + 0.1f;
        this.hydration = decreaseStats(this.hydration, decrease);
    }

    /**
     * @author Alvina Angelin 22152692
     */
    public void makeLonely() {
        Random random = new Random();
        float decrease = random.nextFloat(0.4f) + 0.1f;
        this.love = decreaseStats(this.love, decrease);
    }

}
