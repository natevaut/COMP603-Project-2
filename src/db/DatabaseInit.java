package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.HashMap;

import animals.Animal;
import fileio.FileIO;

public class DatabaseInit {

    static final String dbName = "DB-Test1";
    static final String url = "jdbc:derby://localhost:1527/" + dbName + ";create=true";
    static final String username = "test1";
    static final String password = "test1";

    private static Connection conn;

    public static void main(String[] args) {
        DatabaseInit db = new DatabaseInit();
        db.setupDB();
        db.setupPetsTable();
        db.loadPetsFromFile();
    }

    public void setupDB() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database.");
        } catch (SQLException err) {
            System.err.println(err);
            System.err.println("Try running startdbserver.bat first.");
        }
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
