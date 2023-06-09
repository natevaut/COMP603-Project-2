package gui;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import animals.Animal;
import db.PetsDatabase;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Alvina Angelin 22152692
 */
public class PetSelectionMenu implements IPetGUI {

    private JFrame frame;

    private PetsDatabase pdb;

    public PetSelectionMenu(PetsDatabase pdb) {
        this.pdb = pdb;
    }

    /**
     * Displays the "Select Pet" menu.
     */
    public void display() {
        int frameWidth = 400;
        int frameHeight = 300;

        frame = new JFrame("Select Your Pet");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

        int buttonWidth = 120;
        int buttonHeight = 40;
        int spacing = 20;

        int startX = frameWidth / 2 - buttonWidth / 2;
        int startY = spacing;

        // load pets from database
        HashMap<String, Animal> pets = pdb.getAllPets();

        int x = startX, y = startY;

        for (Animal pet : pets.values()) {

            JButton petButton = new JButton(pet.getName());
            petButton.setBounds(x, y += buttonHeight + spacing, buttonWidth, buttonHeight);
            petButton.addActionListener(e -> {
                PetGame petGame = new PetGame(this.pdb, pet);
                petGame.display();
                frame.dispose();
            });
            frame.add(petButton);
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        ImageIcon icon = new ImageIcon("/paw.gif");
        
        if (pets.size() == 0) {
            JOptionPane.showMessageDialog(frame, "You Have No Pets!", "Pets", JOptionPane.INFORMATION_MESSAGE, icon);
            frame.dispose();
        }
    }
}
