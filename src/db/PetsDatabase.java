package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.HashMap;

import animals.Animal;
import animals.Species;
import fileio.FileIO;

/** @author Nate Evans 21144881 */
public class PetsDatabase {

    // Pets table name: `pets` (hardcoded)

    private static enum Column {
        NAME, SPECIES, NUTRITION, HYDRATION, LOVE;
    }

    private Connection conn;

    /**
     * Sets up the pets database
     * 
     * @param conn The connection created from the database_init class.
     */
    public PetsDatabase(Connection conn) {
        this.conn = conn;
        setupPetsTable();
    }

    /**
     * Creates the 'pets' table in the database. Deletes it if already present.
     */
    public void setupPetsTable() {
        try {
            Statement statement = conn.createStatement();
            try {
                statement.executeUpdate("DROP TABLE pets");
            } catch (SQLSyntaxErrorException err) {
                // don't care if table doesn't exist; good
            }
            String sql = "CREATE TABLE pets" + String.format(
                    "(%s varchar(50), %s varchar(15), %s float, %s float, %s float)",
                    Column.NAME, Column.SPECIES, Column.NUTRITION, Column.HYDRATION, Column.LOVE);
            statement.executeUpdate(sql);
        } catch (SQLException err) {
            err.printStackTrace();
        }

    }

    /**
     * Saves a pet to the database.
     * @param animal The pet to save.
     */
    public void savePet(Animal animal) {
        try {
            Statement statement = conn.createStatement();
            String name = animal.getName();
            String type = animal.getSpecies().name();
            float nutr = animal.getNutrition();
            float hydr = animal.getHydration();
            float love = animal.getLove();
            String sql = "INSERT INTO pets VALUES"
                    + String.format("('%s', '%s', %f, %f, %f)", name, type, nutr, hydr, love);
            statement.executeUpdate(sql);
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

    /**
     * Save several pets into the database.
     * @param pets The pets to save.
     */
    public void savePets(HashMap<String, Animal> pets) {
        for (Animal pet : pets.values()) {
            savePet(pet);
        }
    }

    /**
     * Delete a pet from the database.
     * @param name The name of the pet.
     * @return Whether the pet was successfully deleted.
     */
    public boolean deletePet(String name) {
        try {
            Statement statement = conn.createStatement();
            String sql = String.format("DELETE FROM pets WHERE %s = '%s'", Column.NAME, name);
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
            return false;
        }
    }

    /**
     * Renames a pet in the database.
     * @param oldName
     * @param newName
     * @return Whether the pet was successfully renamed.
     */
    public boolean renamePet(String oldName, String newName) {
        try {
            Statement statement = conn.createStatement();
            String sql_f = "UPDATE pets SET %s = '%s' WHERE %s = '%s'";
            String sql = String.format(sql_f, Column.NAME, newName, Column.NAME, oldName);
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
            return false;
        }
    }

    /**
     * Load all pets from the file to the database.
     */
    public void loadPetsFromFile() {
        HashMap<String, Animal> pets = FileIO.loadFromFile();
        for (Animal animal : pets.values()) {
            savePet(animal);
        }
    }

    /**
     * Retrieve all pets in the database.
     * @return A map of names to pets.
     */
    public HashMap<String, Animal> getAllPets() {
        String sql = "SELECT * FROM pets";
        return this.getPetsFromQuery(sql);
    }

    /**
     * Retrieves all pets of the given species.
     * @param species The species to search for
     * @return A map of names to pets.
     */
    public HashMap<String, Animal> getPetsBySpecies(Species species) {
        String sql = String.format("SELECT * FROM pets WHERE %s = '%s'", Column.SPECIES, species.name());
        return this.getPetsFromQuery(sql);
    }

    /**
     * Retrieve a pet by its name.
     * @param name The name to search for
     * @return The pet if found else `null`.
     */
    public Animal getPetByName(String name) {
        String sql = String.format("SELECT * FROM pets WHERE %s = '%s'", Column.NAME, name);
        HashMap<String, Animal> pets = this.getPetsFromQuery(sql);
        // return first one
        return pets.values().iterator().next();
    }

    /**
     * Retrieves all pets with low stats.
     * @return A map of names to pets.
     */
    public HashMap<String, Animal> getNeglectedPets() {
        String sql_f = "SELECT * FROM pets WHERE %s < 0.2 AND %s < 0.2 AND %s < 0.2";
        String sql = String.format(sql_f, Column.NUTRITION, Column.HYDRATION, Column.LOVE);
        return this.getPetsFromQuery(sql);
    }

    /**
     * Saves all pets in the database to the pets file.
     */
    public void dumpToFile() {
        FileIO.saveToFile(getAllPets());
    }

    /**
     * Run an SQL query and return all pets retrieved.
     * @param sql The query to run.
     * @return A map of names to animals.
     */
    private HashMap<String, Animal> getPetsFromQuery(String sql) {
        HashMap<String, Animal> pets = new HashMap<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Animal pet = this.createAnimalFromData(resultSet);
                pets.put(pet.getName(), pet);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return pets;
    }

    /**
     * Create an Animal instance using a result set from an SQL query.
     * @param resultSet The result of the SQL query.
     * @return A new Animal instance.
     */
    private Animal createAnimalFromData(ResultSet resultSet) {
        Animal pet = null;
        try {
            String type = resultSet.getString(Column.SPECIES.name());
            String name = resultSet.getString(Column.NAME.name());
            float nutr = resultSet.getFloat(Column.NUTRITION.name());
            float hydr = resultSet.getFloat(Column.HYDRATION.name());
            float love = resultSet.getFloat(Column.LOVE.name());

            pet = Animal.createPet(type, name, nutr, hydr, love);
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return pet;
    }

}
