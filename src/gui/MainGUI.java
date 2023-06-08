package gui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import db.DatabaseInit;
import db.PetsDatabase;
import fileio.FileIO;

/**
 * @author Alvina Angelin 22152692
 */
public class MainGUI {

    public static void main(String[] args) {
    	// set button look and feel
        UIManager.put("ButtonUI", "javax.swing.plaf.basic.BasicButtonUI");
        
        FileIO.touchPetsFile();
        DatabaseInit db = new DatabaseInit();
        PetsDatabase pdb = new PetsDatabase(db.conn);
        pdb.loadPetsFromFile();

        SwingUtilities.invokeLater(() -> {
            new PetGUI(pdb);
        });
    }
}
