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
        connect();
    }

    /**
     * Creates the database server.
     */
    public void startServer() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "lib/derbyrun.jar", "server", "start");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
        } catch (IOException err) {
            System.err.println("Failed to start Derby server.");
            err.printStackTrace();
        }
    }

    /**
     * Connects to the database.
     */
    public void connect() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

}
