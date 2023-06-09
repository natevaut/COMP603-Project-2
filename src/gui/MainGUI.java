package gui;

import javax.swing.SwingUtilities;

import db.DatabaseInit;
import db.PetsDatabase;
import fileio.FileIO;

/**
 * @author Alvina Angelin 22152692
 */
public class MainGUI {

	/**
	 * Starts the GUI program.
	 */
    public static void main(String[] args) {
        
        FileIO.touchPetsFile();
        DatabaseInit db = new DatabaseInit();
        PetsDatabase pdb = new PetsDatabase(db.conn);
        pdb.loadPetsFromFile();
        
        SwingUtilities.invokeLater(() -> {
            new MainMenu(pdb);
        });
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Shutdown code
            pdb.dumpToFile();
        }));
    }
}
