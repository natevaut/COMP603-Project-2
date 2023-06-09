package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import animals.Animal;
import animals.Species;
import db.PetsDatabase;
import run.GameLoop;

/**
 * @author Alvina Angelin 22152692
 */
public class PetGame implements IPetGUI {

    private JFrame frame;
    private PetsDatabase pdb;
    private Animal pet;
    
    public PetGame(PetsDatabase pdb, Animal pet) {
    	this.pdb = pdb;
        this.pet = pet;
    }

    /**
     * Displays the GUI to run the pet adoption game in.
     */
    public void display() {
        int frameWidth = 350;
        int frameHeight = 350;

        frame = new JFrame("Virtual Pet");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(new FlowLayout());

        // setup grid layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;

        // pet main text
        JLabel petLabel = new JLabel("Your pet " + pet.getSpecies().name().toLowerCase() + ": " + pet.getName());
        petLabel.setFont(new Font("Arial", Font.BOLD, 20));
        petLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // pet image
        ImageIcon image = doImage(pet.getSpecies());
        Image resizedImage = image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon finalImage = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(finalImage);

        // status label 1
        JLabel statusTitleLabel = new JLabel("Placeholder");
        statusTitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        statusTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // status label 2
        JLabel statusInfoLabel = new JLabel("Placeholder");
        statusInfoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        statusInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        //buttons
        JButton action1Button = new JButton("Placeholder");
        JButton action2Button = new JButton("Placeholder");
        JButton action3Button = new JButton("Placeholder");
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(action1Button);
        buttonPanel.add(action2Button);
        buttonPanel.add(action3Button);
        
        // put pet label
        constraints.gridy = 0;
        panel.add(petLabel, constraints);

        // put image
        constraints.gridy = 1;
        panel.add(imageLabel, constraints);

        // put name label
        constraints.gridy = 2;
        panel.add(statusTitleLabel, constraints);

        // put status title
        constraints.gridy = 3;
        panel.add(statusInfoLabel, constraints);;

        // put action buttons
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        panel.add(buttonPanel, constraints);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        // game loop
        GameLoop main = new GameLoop(pet);
        main.pdb = pdb;
        main.gameFrame = frame;
        main.titleLabel = statusTitleLabel;
        main.infoLabel = statusInfoLabel;
        main.buttons = new JButton[] { action1Button, action2Button, action3Button };
        main.run();
        
    }

    /**
     * Fetches an animal image from inside the JAR.
     * @param species The species to get the image for.
     * @return An image of the animal.
     */
    private ImageIcon doImage(Species species) {
        switch (pet.getSpecies()) {
            case DOG:
                return new ImageIcon(getClass().getResource("/dog.gif"));
            case CAT:
                return new ImageIcon(getClass().getResource("/cat.gif"));
            case RABBIT:
                return new ImageIcon(getClass().getResource("/rabbit.gif"));
            case HAMSTER:
                return new ImageIcon(getClass().getResource("/hamster.gif"));
            case FROG:
                return new ImageIcon(getClass().getResource("/frog.gif"));
        }
        return null;
    }
}
