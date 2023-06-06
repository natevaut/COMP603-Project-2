package animals;

import java.util.HashMap;
import java.util.Random;

public class Animal {

    protected Species species;
    protected String name;
    protected String[] foods, liquids, actions;
    protected float nutrition, hydration, love;
    protected HashMap<String, Float> nutritionStats, hydrationStats, loveStats;

    /**@author Nate Evans 21144881 */
    public Animal() {
        nutritionStats = new HashMap<>();
        hydrationStats = new HashMap<>();
        loveStats = new HashMap<>();

        foods = new String[3];
        // stats done in subclasses

        liquids = new String[3];
        // stats done in subclasses

        actions = new String[3];
        // stats done in subclasses

    }

    /**
     * Creates a new pet loaded with given attributes set
     * @author Nate Evans 21144881
     */
    public static Animal createPet(String species, String name, float nutr, float hydr, float love) {
        Animal pet = Species.newSpeciesFromString(species);
        pet.loadAttributes(name, nutr, hydr, love);
        return pet;
    }

    /**
     * Loads attributes and saves them into the current pet's stats
     * @author Nate Evans 21144881
     */
    public void loadAttributes(String name, float n, float h, float l) {
        this.name = name;
        nutrition = n;
        hydration = h;
        love = l;
    }

    /** @author Nate Evans 21144881 */
    public String[] getFoods() {
        return this.foods;
    }

    /** @author Nate Evans 21144881 */
    public HashMap<String, Float> getNutritionData() {
        return this.nutritionStats;
    }

    /** @author Nate Evans 21144881 */
    public String[] getLiquids() {
        return this.liquids;
    }

    /** @author Nate Evans 21144881 */
    public HashMap<String, Float> getHydrationData() {
        return this.hydrationStats;
    }

    /** @author Nate Evans 21144881 */
    public Species getSpecies() {
        return this.species;
    }

    /** @author Alvina Angelin 22152692 */
    public String[] getActions() {
        return this.actions;
    }

    /** @author Alvina Angelin 22152692 */
    public HashMap<String, Float> getLoveData() {
        return this.loveStats;
    }

    /** @author Alvina Angelin 22152692 */
    public void setName(String name) {
        this.name = name;
    }

    /** @author Alvina Angelin 22152692 */
    public String getName() {
        return this.name;
    }

    /** @author Alvina Angelin 22152692 */
    public void setHydration(float hydration) {
        this.hydration = hydration;
    }

    /** @author Alvina Angelin 22152692 */
    public float getHydration() {
        return this.hydration;
    }

    /** @author Alvina Angelin 22152692 */
    public void setNutrition(float nutrition) {
        this.nutrition = nutrition;
    }

    /** @author Alvina Angelin 22152692 */
    public float getNutrition() {
        return this.nutrition;
    }

    /** @author Alvina Angelin 22152692 */
    public void setLove(float love) {
        this.love = love;
    }

    /** @author Alvina Angelin 22152692 */
    public float getLove() {
        return this.love;
    }

    /** @author Alvina Angelin 22152692 */
    public void eat(String food) {
        if (nutritionStats.containsKey(food)) {
            nutrition += nutritionStats.get(food);
            if (nutrition > 1) {
                nutrition = 1;
            }
        }
    }

    /** @author Alvina Angelin 22152692 */
    public void drink(String liquid) {
        if (hydrationStats.containsKey(liquid)) {
            hydration += hydrationStats.get(liquid);
            if (hydration > 1) {
                hydration = 1;
            }
        }
    }

    /** @author Alvina Angelin 22152692 */
    public void receive(String action) {
        if (loveStats.containsKey(action)) {
            love += loveStats.get(action);
            if (love > 1) {
                love = 1;
            }
        }
    }

    /** @author Alvina Angelin 22152692 */
    public void makeHungry() {
        Random random = new Random();
        makeHungry(random.nextInt(50) / 100.0f);
    }
    
    /** @author Alvina Angelin 22152692 */
    private void makeHungry(float amount) {
        this.nutrition -= amount;

        if (this.nutrition <= 0) {
            this.nutrition = 0;
        }
    }

    /** @author Alvina Angelin 22152692 */
    public void makeThirsty() {
        Random random = new Random();
        makeThirsty(random.nextInt(50) / 100.0f);
    }
    
    /** @author Alvina Angelin 22152692 */
    private void makeThirsty(float amount) {
        this.hydration -= amount;

        if (this.hydration <= 0) {
            this.hydration = 0;
        }
    }

    /** @author Alvina Angelin 22152692 */
    public void makeLonely() {
        Random random = new Random();
        makeLonely(random.nextInt(50) / 100.0f);
    }
    
    /** @author Alvina Angelin 22152692 */
    private void makeLonely(float amount) {
        this.love -= amount;

        if (this.love < 0) {
            this.love = 0;
        }
    }

}
