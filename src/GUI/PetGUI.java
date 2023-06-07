package GUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Alvina Angelin 22152692
 */
import java.awt.Font;
import javax.swing.JOptionPane;
public class PetGUI {
    private JFrame frame;
    private JTextField textField;
    
    private JButton adoptButton;
    
    private JLabel welcomeLabel;
    
    public PetGUI() {
        
        int width = 600;
        int height = 350;
        
        //main window
        frame = new JFrame("Pet Simulator");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        //welcome label
        welcomeLabel = new JLabel("Welcome to Pet Simulator");
        int welcwidth = 500;
        welcomeLabel.setBounds(width/2 - welcwidth/2, 100, welcwidth, 20);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(welcomeLabel);
        
        //adopt button
        adoptButton = new JButton("Adopt a pet!");
        int adoptwidth = 500;
        adoptButton.setBounds(width/2 - adoptwidth/2 , 200, adoptwidth, 20);
        adoptButton.setHorizontalAlignment(SwingConstants.CENTER);
        adoptButton.addActionListener(e -> {
            int choice = JOptionPane.showOptionDialog(frame, "Do you already have a pet?", "Pet Adoption",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (choice == JOptionPane.YES_OPTION) {
                PetSelection petSelection = new PetSelection();
                petSelection.display();
            }
        });
        frame.add(adoptButton);
        
        frame.setVisible(true);
    }
}
