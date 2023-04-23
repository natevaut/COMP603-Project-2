package assignment;

import java.util.HashMap;
import java.util.Random;

public class Animal {

    protected Species species;
    protected String name;
    protected String[] foods, liquids, actions;
    protected float nutrition, hydration, love;
    protected HashMap<String, Float> nutritionStats, hydrationStats, loveStats;

    /** @author Nate Evans 21144881 */
    public Animal() {
        nutritionStats = new HashMap<>();
        hydrationStats = new HashMap<>();
        loveStats = new HashMap<>();

        foods = null; // done in subclasses
        
        liquids = new String[]{"water", "milk", "juice"};
        hydrationStats.put(liquids[0], 0.7f);
        hydrationStats.put(liquids[1], 0.1f);
        hydrationStats.put(liquids[2], 0.0f);

        actions = new String[]{"pat", "hug", "kiss"};
        loveStats.put(actions[0], 0.4f);
        loveStats.put(actions[1], 0.3f);
        loveStats.put(actions[2], 0.1f);

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
        }
    }

    /** @author Alvina Angelin 22152692 */
    public void drink(String liquid) {
        if (hydrationStats.containsKey(liquid)) {
            hydration = hydrationStats.get(liquid);
        }
    }

    /** @author Alvina Angelin 22152692 */
    public void receive(String actions) {
        if (loveStats.containsKey(actions)) {
            love = loveStats.get(actions);
        }
    }

    /** @author Alvina Angelin 22152692 */
    public void makeHungry() {
        Random random = new Random();
        this.nutrition -= random.nextInt(100) / 100;

        if (this.nutrition <= 0) {
            this.nutrition = 0;
        }
    }

    /** @author Alvina Angelin 22152692 */
    public void makeThirsty() {
        Random random = new Random();
        this.hydration -= random.nextInt(100) / 100;

        if (this.hydration <= 0) {
            this.hydration = 0;
        }
    }

    /** @author Alvina Angelin 22152692 */
    public void makeLonely() {
        Random random = new Random();
        this.love -= random.nextInt(100) / 100;

        if (this.love < 0) {
            this.love = 0;
        }
    }

}
