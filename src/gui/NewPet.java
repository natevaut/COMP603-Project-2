package gui;

import animals.Species;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Alvina Angelin 22152692
 */
public class NewPet {
    
    private JFrame frame;
    private JComboBox<String> petComboBox;
    private JTextField nameInput;
    
    public void display() {
        int frameWidth = 400;
        int frameHeight = 250;
        
        frame = new JFrame("Select and Name New Pet");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(5,3));
        
        JLabel petLabel = new JLabel("Select a Pet: ");
        String[] petOptions = Species.getSpeciesList();
        petComboBox = new JComboBox<>(petOptions);
        
        JLabel nameLabel = new JLabel("Enter a Name: ");
        nameInput = new JTextField(15);
        
        //Confirm and Cancel Button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            frame.dispose();
        });
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            String species = (String)petComboBox.getSelectedItem();
            String name = nameInput.getText();
            PetGame petGame = new PetGame(species, name);
            petGame.display();
            //make it so if u confirm the main menu petgui closes
        });
       
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(cancelButton);
        bottomPanel.add(confirmButton);
        
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
