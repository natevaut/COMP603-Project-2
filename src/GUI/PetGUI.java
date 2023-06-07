package GUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Alvina Angelin 22152692
 */

public class PetGUI {
    private JFrame frame;
    private JTextField textField;
    
    private JButton adoptButton;
    private JButton exitButton;
    
    private JLabel welcomeLabel;
    
    public PetGUI() {
        
        int width = 600;
        int height = 350;
        
        //main window
        frame = new JFrame("Pet Simulator");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        // Add background image
        // ImageIcon backgroundIcon = new ImageIcon("images/background.gif"); // Replace with your image file path
        // JLabel backgroundLabel = new JLabel(backgroundIcon);
        // backgroundLabel.setBounds(0, 0, width, height);
        // frame.add(backgroundLabel);
        
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
            } else {
                NewPet newPet = new NewPet();
                newPet.display();
            }
        });
        frame.add(adoptButton);
        
        //exit button
        exitButton = new JButton("EXIT");
        int exitwidth = 500;
        exitButton.setBounds(width/2 - exitwidth/2, 250, exitwidth, 20);
        exitButton.setHorizontalAlignment(SwingConstants.CENTER);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(exitButton);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
