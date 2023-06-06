package test;

import org.junit.jupiter.api.Test;

import animals.Species;

/** @author Nate Evans 21144881 */
class TestSpecies {

    @Test
    void testNewSpeciesFromString() {
        // Ensure species is associated correctly
        assert Species.newSpeciesFromString("Dog").getSpecies().name().toLowerCase().equals("dog");
        assert Species.newSpeciesFromString("cat").getSpecies().name().toLowerCase().equals("cat");
        assert Species.newSpeciesFromString("RABBIT").getSpecies().name().toLowerCase().equals("rabbit");

        // Ensure animal is initialised with null values
        assert Species.newSpeciesFromString("RABBIT").getName() == null;
        assert Species.newSpeciesFromString("RABBIT").getNutrition() == 0;
    }

}
