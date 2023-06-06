package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** @author Nate Evans 21144881 */
public class DatabaseInit {

    static final String dbName = "DB-Pets";
    static final String url = "jdbc:derby://localhost:1527/" + dbName + ";create=true";
    static final String username = "petsdb";
    static final String password = "petsdb";

    public Connection conn;

    /**
     * Sets up the database.
     */
    public DatabaseInit() {
        startServer();

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

    /**
     * Creates the database server.
     */
    public void startServer() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "lib/derbyrun.jar", "server", "start");
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException err) {
            System.err.println("Failed to start Derby server.");
            err.printStackTrace();
        }
    }

}
