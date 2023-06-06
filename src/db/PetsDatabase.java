package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.HashMap;

import animals.Animal;
import fileio.FileIO;

/** @author Nate Evans 21144881 */
public class PetsDatabase {

    private static enum Column {
        PETNAME, TYPE, NUTRITION, HYDRATION, LOVE;
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
     * Creates the 'pets' table in the database. Deletes it if already present
     * before.
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
                    "(%s varchar(30), %s varchar(10)," + "%s float, %s float, %s float)", Column.PETNAME.name(),
                    Column.TYPE.name(), Column.NUTRITION.name(), Column.HYDRATION.name(), Column.LOVE.name());
            statement.executeUpdate(sql);
        } catch (SQLException err) {
            System.err.println(err);
            err.printStackTrace();
        }

    }

    /**
     * Saves a pet to the database.
     * 
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
            System.err.println(err);
            err.printStackTrace();
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
     * @return All pets in the database.
     */
    public HashMap<String, Animal> getAllPets() {
        HashMap<String, Animal> pets = new HashMap<>();
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM pets";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String type = resultSet.getString(Column.TYPE.name());
                String name = resultSet.getString(Column.PETNAME.name());
                float nutr = resultSet.getFloat(Column.NUTRITION.name());
                float hydr = resultSet.getFloat(Column.HYDRATION.name());
                float love = resultSet.getFloat(Column.LOVE.name());

               
                Animal pet = Animal.createPet(type, name, nutr, hydr, love);
                pets.put(name, pet);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return pets;
    }

    /**
     * Saves all pets in the database to the pets file.
     */
    public void dumpToFile() {
        FileIO.saveToFile(getAllPets());
    }

}
