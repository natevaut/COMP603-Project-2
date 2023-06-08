package gui;

import animals.Animal;
import animals.Species;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * @author Alvina Angelin 22152692
 */
public class PetGame {

    private JFrame frame;
    private Animal pet;

    private JLabel petLabel;
    private JLabel nameLabel;

    public PetGame(String species, String name) {
        this.pet = Species.newSpeciesFromString(species);
        pet.setName(name);
    }

    public void display() {
        int frameWidth = 400;
        int frameHeight = 300;

        frame = new JFrame("Virtual Pet");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new FlowLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;

        petLabel = new JLabel("Your Pet " + pet.getSpecies());
        petLabel.setFont(new Font("Arial", Font.BOLD, 20));
        petLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        //image
        ImageIcon image = doImage(pet.getSpecies());
        Image resizedImage = image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon finalImage = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(finalImage);

        //display pet name
        nameLabel = new JLabel("Name: " + pet.getName());
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel title = new JLabel("Your pet is hungry!");
        title.setFont(new Font("Arial", Font.PLAIN, 14));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        //buttons
        JButton flyButton = new JButton("Feed Fly");
        JButton snailButton = new JButton("Feed Snail");
        JButton wormButton = new JButton("Feed Worm");
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(flyButton);
        buttonPanel.add(snailButton);
        buttonPanel.add(wormButton);
        
        //pet label
        constraints.gridy = 0;
        panel.add(petLabel, constraints);

        //image
        constraints.gridy = 1;
        panel.add(imageLabel, constraints);

        constraints.gridy = 2;
        panel.add(nameLabel, constraints);

        constraints.gridy = 3;
        panel.add(title, constraints);;

        constraints.gridy = 4;
        constraints.gridwidth = 2;
        panel.add(buttonPanel, constraints);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private ImageIcon doImage(Species species) {
        switch (pet.getSpecies()) {
            case DOG:
                return new ImageIcon("images/dog.gif");
            case CAT:
                return new ImageIcon("images/cat.gif");
            case RABBIT:
                return new ImageIcon("images/rabbit.gif");
            case HAMSTER:
                return new ImageIcon("images/hamster.gif");
            case FROG:
                return new ImageIcon("images/frog.gif");
        }
        return null;
    }
}
