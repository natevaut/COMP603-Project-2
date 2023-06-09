package gui;

import animals.Animal;
import db.PetsDatabase;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Alvina Angelin 22152692
 */
public class ViewPetsMenu implements IPetGUI {

    private JFrame frame;

    private PetsDatabase pdb;

    public ViewPetsMenu(PetsDatabase pdb) {
        this.pdb = pdb;
    }

    /**
     * Displays the "Select Your Pet" menu.
     */
    public void display() {
        int frameWidth = 400;
        int frameHeight = 300;
        int buttonWidth = 120;
        int buttonHeight = 40;
        int spacing = 20;
        int startX = frameWidth / 2 - buttonWidth / 2;
        int startY = spacing;

        frame = new JFrame("Select Your Pet");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

        // load pets from database
        HashMap<String, Animal> pets = pdb.getAllPets();

        int x = startX, y = startY;

        // put all pets into the panel
        for (Animal pet : pets.values()) {

            JButton petButton = new JButton(pet.getName());
            petButton.setBounds(x, y += buttonHeight + spacing, buttonWidth, buttonHeight);
            petButton.addActionListener(e -> {
                ViewStatsMenu viewStatsMenu = new ViewStatsMenu(pdb, pet);
                viewStatsMenu.display();
            });

            frame.add(petButton);;
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // error dialog for when there are no pets
        if (pets.size() == 0) {
            JOptionPane.showMessageDialog(frame, "You Have No Pets!", "Pets", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        }

    }
}
