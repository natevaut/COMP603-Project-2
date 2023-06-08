package GUI;

import javax.swing.SwingUtilities;

/**
 * @author Alvina Angelin 22152692
 */
public class MainGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PetGUI();
        });
    }
}
