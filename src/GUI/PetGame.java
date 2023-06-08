package GUI;

import animals.Animal;
import animals.Species;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
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

        JPanel panel = new JPanel(new GridLayout(2, 2));

        petLabel = new JLabel("Your Pet " + pet.getSpecies());
        petLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(petLabel);
         
        //image
        ImageIcon image = doImage(pet.getSpecies());
        Image resizedImage = image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon finalImage = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(finalImage);
        frame.add(imageLabel);

        //display pet name
        nameLabel = new JLabel("Name: " + pet.getName());
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(nameLabel);
        
        

        frame.getContentPane().add(panel);
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
