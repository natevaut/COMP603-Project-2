package test.animals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import animals.Species;

/** @author Nate Evans 21144881 */
class TestSpecies {

    @Test
    void testNewSpeciesFromString() {
        // Ensure species is associated correctly
        assert Species.newSpeciesFromString("Dog").getSpecies().name().equalsIgnoreCase("dog");
        assert Species.newSpeciesFromString("cat").getSpecies().name().equalsIgnoreCase("cat");
        assert Species.newSpeciesFromString("RABBIT").getSpecies().name().equalsIgnoreCase("rabbit");
        assert Species.newSpeciesFromString("kangaroo") == null;

        // Ensure animal is initialised with null values
        assert Species.newSpeciesFromString("RABBIT").getName() == null;
        assert Species.newSpeciesFromString("hamster").getNutrition() == 0;
    }

    @Test
    void testSpeciesList() {
        ArrayList<String> specieses = new ArrayList<>();
        for (String species : Species.getSpeciesList())
            specieses.add(species.toLowerCase());
        
        assert specieses.contains("dog");
        assert specieses.contains("cat");
        assert specieses.contains("rabbit");
    }

}
