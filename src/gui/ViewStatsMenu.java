package gui;

import animals.Animal;
import db.PetsDatabase;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Alvina Angelin 22152692
 */
public class ViewStatsMenu implements IPetGUI {

    private JFrame frame;

    private PetsDatabase pdb;
    private Animal pet;

    public ViewStatsMenu(PetsDatabase pdb, Animal pet) {
        this.pdb = pdb;
        this.pet = pet;
    }

    public void display() {
        int frameWidth = 400;
        int frameHeight = 150;

        frame = new JFrame("Pet Stats");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String title = "Your Pet Stats";
        String[] texts = {pet.getName() + " THE " + pet.getSpecies(), "", "Hunger: %.1f%%",
            "Thirst: %.1f%%", "Loneliness: %.1f%%"};
        String text = "<html>" + String.join("<br/>", texts) + "</html>";
        text = String.format(text, (1 - pet.getNutrition()) * 100, (1 - pet.getHydration()) * 100, (1 - pet.getLove()) * 100);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel textLabel = new JLabel(text);

        JButton renameButton = new JButton("rename");
        renameButton.addActionListener(f -> {
            String newName = JOptionPane.showInputDialog(frame, "Enter new name for ");
            if (newName != null) {
                // set new name
            }
        });

        //delete pet button
        JButton deleteButton = new JButton("delete");
        deleteButton.addActionListener(g -> {
            int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this pet?", null, JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                //delete animal
            }
        });
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(renameButton);
        bottomPanel.add(deleteButton);


        constraints.gridy = 1;
        mainPanel.add(textLabel, constraints);
        
        constraints.gridy = 2;
        mainPanel.add(bottomPanel, constraints);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
