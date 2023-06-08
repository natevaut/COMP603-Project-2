package gui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * @author Alvina Angelin 22152692
 */
public class MainGUI {

    public static void main(String[] args) {
    	// set button look and feel
        UIManager.put("ButtonUI", "javax.swing.plaf.basic.BasicButtonUI");

        SwingUtilities.invokeLater(() -> {
            new PetGUI();
        });
    }
}
