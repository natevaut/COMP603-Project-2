package gui;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import animals.Animal;
import db.PetsDatabase;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Alvina Angelin 22152692
 */
public class PetSelectionMenu {

    private JFrame frame;

    private PetsDatabase pdb;

    private JLabel noLabel;
    private JButton returnButton;

    public PetSelectionMenu(PetsDatabase pdb) {
        this.pdb = pdb;
    }

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
            if (pets.size() == 0) {
                noLabel = new JLabel("You have no pets");
                noLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                noLabel.setHorizontalAlignment(SwingConstants.CENTER);
                noLabel.setBounds(frameWidth / 2 - 200 / 2, 250, 200, 20);
                returnButton = new JButton("Main Menu");
                returnButton.setHorizontalAlignment(SwingConstants.CENTER);
                returnButton.setBounds(frameWidth / 2 - 200 / 2, 250, 200, 20);
                returnButton.addActionListener(e -> {
                    MainMenu mainMenu = new MainMenu(this.pdb);
                    mainMenu.display();
                    frame.dispose();
                });
                frame.add(noLabel);
                frame.add(returnButton);
            } else {
                JButton petButton = new JButton(pet.getName());
                petButton.setBounds(x, y += buttonHeight + spacing, buttonWidth, buttonHeight);
                petButton.addActionListener(e -> {
                    PetGame petGame = new PetGame(this.pdb, pet);
                    petGame.display();
                    frame.dispose();
                });
                frame.add(petButton);
            }
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
