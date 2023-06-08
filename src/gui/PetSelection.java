package gui;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import animals.Animal;
import db.PetsDatabase;

/**
 * @author Alvina Angelin 22152692
 */

public class PetSelection {
    private JFrame frame;
    
    private PetsDatabase pdb;
    
    public PetSelection(PetsDatabase pdb) {
    	this.pdb = pdb;
    }
    
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
        
        int startX = frameWidth / 2 - buttonWidth /2;
        int startY = spacing;
        
        // load pets from database
        HashMap<String, Animal> pets = pdb.getAllPets();
        
        int x = startX, y = startY;
        for (Animal pet : pets.values()) {
        	JButton petButton = new JButton(pet.getName());
        	petButton.setBounds(x, y += buttonHeight + spacing, buttonWidth, buttonHeight);
        	frame.add(petButton);
        }
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
