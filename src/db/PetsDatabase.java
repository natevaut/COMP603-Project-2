package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import animals.Animal;
import fileio.FileIO;

public class PetsDatabase {

    private Connection conn;

    public PetsDatabase(Connection conn) {
        this.conn = conn;
    }

    public void setupPetsTable() {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("DROP TABLE pets");
            statement.executeUpdate("CREATE TABLE pets (petname varchar(30), type varchar(10),"
                    + "nutrition float, hydration float, love float)");
        } catch (SQLException err) {
            System.err.println(err);
        }

    }

    public void loadPetsFromFile() {
        HashMap<String, Animal> pets = FileIO.loadFromFile();
        try {
            Statement statement = conn.createStatement();
            for (String name : pets.keySet()) {
                Animal animal = pets.get(name);
                String type = animal.getSpecies().name();
                float nutr = animal.getNutrition();
                float hydr = animal.getHydration();
                float love = animal.getLove();
                statement.executeUpdate(String.format("INSERT INTO pets VALUES ('%s', '%s', %f, %f, %f)", name, type,
                        nutr, hydr, love));
            }
            conn.close();
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

}
