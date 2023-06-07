package GUI;

import animals.Species;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Alvina Angelin 22152692
 */
public class NewPet {
    private JFrame frame;
    private JTextField text;
    
    public void display() {
        int frameWidth = 400;
        int frameHeight = 300;
        
        frame = new JFrame("Pick and Name Your Pet");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        
        //Pet choices
        JPanel petChoices = new JPanel();
        petChoices.setBorder(BorderFactory.createTitledBorder("Select a Pet"));
        petChoices.setSize(100, 40);
        frame.add(petChoices);
        
        String[] petOptions = Species.getSpeciesList();
        JComboBox<String> box = new JComboBox<>(petOptions);
        box.setSize(100, 40);
        frame.add(box);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
