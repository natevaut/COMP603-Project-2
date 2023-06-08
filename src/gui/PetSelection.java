package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Alvina Angelin 22152692
 */

public class PetSelection {
    private JFrame frame;
    
    public void display() {
        int frameWidth = 400;
        int frameHeight = 300;
        
        frame = new JFrame("Pet Selection");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        
        int buttonWidth = 120;
        int buttonHeight = 40;
        int spacing = 20;
        
        int x = frameWidth / 2 - buttonWidth /2;
        int y = frameHeight / 2 - (2 * buttonHeight + spacing) / 2;
        
        JButton button1 = new JButton("Pet 1");
        button1.setBounds(x, y, buttonWidth, buttonHeight);
        frame.add(button1);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
