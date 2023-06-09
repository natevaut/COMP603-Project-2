package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import db.PetsDatabase;

/**
 * @author Alvina Angelin 22152692
 */

public class MainMenu implements IPetGUI {
    public JFrame frame;
    public PetsDatabase pdb;
    
    private JButton adoptButton;
    private JButton exitButton;
    private JButton viewButton;
    
    private JLabel welcomeLabel;
    
    public MainMenu(PetsDatabase pdb) {
    	this.pdb = pdb;
        this.display();
    }
    
    /**
     * Displays the Main Menu GUI.
     */
    public void display() {
        
        int width = 600;
        int height = 400;
        
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
                PetSelectionMenu petSelection = new PetSelectionMenu(pdb);
                petSelection.display();
            } else if (choice == JOptionPane.NO_OPTION) {
                NewPetMenu newPet = new NewPetMenu(pdb);
                newPet.display();
            } 
        });
        frame.add(adoptButton);
        
        //view all pets button
        viewButton = new JButton("View all pets");
        int viewWidth = 500;
        viewButton.setBounds(width/2 - viewWidth/2, 240, viewWidth, 20);
        viewButton.setHorizontalAlignment(SwingConstants.CENTER);
        viewButton.addActionListener(e -> {
            ViewPetsMenu viewStats = new ViewPetsMenu(pdb);
            viewStats.display();
        });
        frame.add(viewButton);
        
        //exit button
        exitButton = new JButton("Exit");
        int exitwidth = 500;
        exitButton.setBounds(width/2 - exitwidth/2, 280, exitwidth, 20);
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
