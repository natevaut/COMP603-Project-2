package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import animals.Animal;
import animals.Species;
import db.PetsDatabase;

/**
 * @author Alvina Angelin 22152692
 */

public class NewPetMenu implements IPetGUI {
    
    private JFrame frame;
    private JComboBox<String> petComboBox;
    private JTextField nameInput;

    private PetsDatabase pdb;

    public NewPetMenu(PetsDatabase pdb) {
        this.pdb = pdb;
    }

    /**
     * Displays the "New Pet" menu GUI
     */
    public void display() {
        int frameWidth = 400;
        int frameHeight = 250;

        frame = new JFrame("Select and Name New Pet");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 3));

        JLabel petLabel = new JLabel("Select a Pet: ");
        String[] petOptions = Species.getSpeciesList();
        petComboBox = new JComboBox<>(petOptions);

        JLabel nameLabel = new JLabel("Enter a Name: ");
        nameInput = new JTextField(15);

        //Cancel Button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            frame.dispose();
        });
        //Confirm Button
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            String species = (String) petComboBox.getSelectedItem();
            String name = nameInput.getText();

            if (name == null || name.length() == 0) {
                JOptionPane.showMessageDialog(frame, "Please Enter A Name", "New Pet", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            Animal pet = Species.newSpeciesFromString(species);
            pet.setName(name);

            PetGame petGame = new PetGame(pdb, pet);
            petGame.display();
            frame.dispose();
        }
        );

        // add buttons to container
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(cancelButton);
        bottomPanel.add(confirmButton);

        // add all labels and boxes
        panel.add(petLabel);
        panel.add(petComboBox);
        panel.add(nameLabel);
        panel.add(nameInput);
        panel.add(bottomPanel);

        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
