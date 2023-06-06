package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseInit {

    static final String dbName = "DB-Test1";
    static final String url = "jdbc:derby://localhost:1527/" + dbName + ";create=true";
    static final String username = "test1";
    static final String password = "test1";

    public Connection conn;

    public static void main(String[] args) {
        DatabaseInit db = new DatabaseInit();
        PetsDatabase pdb = new PetsDatabase(db.conn);
        pdb.setupPetsTable();
        pdb.loadPetsFromFile();
    }

    public DatabaseInit() {
        startServer();

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database.");
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    public void startServer() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "lib/derbyrun.jar", "server", "start");
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            process.waitFor();

            System.out.println("Derby server started successfully.");
        } catch (IOException | InterruptedException err) {
            System.err.println("Failed to start Derby server.");
            System.err.println(err);
        }
    }

}
