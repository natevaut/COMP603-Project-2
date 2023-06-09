package run;

import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import animals.Animal;
import db.PetsDatabase;

/** @author Nate Evans 21144881 */
public class GameLoop {
	
	private enum Need {
		HUNGRY, THIRSTY, LONELY;
	}

	public boolean running;
	public PetsDatabase pdb;
	public Animal pet;
	public JFrame gameFrame;
	public JLabel titleLabel, infoLabel;
	public JButton[] buttons;

	public GameLoop(Animal pet) {
		running = true;
		this.pet = pet;
	}
	
	/**
	 * Run the Game Loop.
	 */
	public void run() {
		this.runOnce();
	}

	/**
	 * Run an instance of the Game Loop.
	 */
	public void runOnce() {
		buttons[0].setText("Placeholder");
		buttons[1].setText("Placeholder");
		buttons[2].setText("Placeholder");

		Random rand = new Random();
		int needIndex = rand.nextInt(3);
		Need need = Need.values()[needIndex];
		String petName = pet.getName();

		switch (need) {
			case HUNGRY: {
				this.pet.makeHungry();
				this.titleLabel.setText(petName + " is " + asPercent(1 - pet.getNutrition()) + " hungry!");
				this.infoLabel.setText("What will you feed " + petName + "?");
	
				String[] foods = pet.getFoods();
				this.setButtonsText("Feed", foods);
				this.setActionListeners(need, foods);
				break;
			}
			case THIRSTY: {
				this.pet.makeThirsty();
				this.titleLabel.setText(petName + " is " + asPercent(1 - pet.getHydration()) + " thirsty!");
				this.infoLabel.setText("What will you give " + petName + "?");
	
				String[] drinks = pet.getLiquids();
				this.setButtonsText("Drink", drinks);
				this.setActionListeners(need, drinks);
				break;
			}
			case LONELY: {
				this.pet.makeLonely();
				this.titleLabel.setText(petName + " is " + asPercent(1 - pet.getLove()) + " lonely!");
				this.infoLabel.setText("What will you do to " + petName + "?");
	
				String[] actions = pet.getActions();
				this.setButtonsText("Do", actions);
				this.setActionListeners(need, actions);
				break;
			}
		}
	}
	
	/**
	 * Set all the buttons' action listeners to perform the given action.
	 * @param need The action being performed.
	 * @param items The options to put in the buttons.
	 */
	private void setActionListeners(Need need, String[] items) {
		this.clearActionListeners(this.buttons);
		this.buttons[0].addActionListener(e -> {
			doThing(need, items[0]);
		});
		this.buttons[1].addActionListener(e -> {
			doThing(need, items[1]);
		});
		this.buttons[2].addActionListener(e -> {
			doThing(need, items[2]);
		});
	}
	
	/**
	 * Perform an action.
	 * @param need The action to perform.
	 * @param item The chosen option.
	 */
	private void doThing(Need need, String item) {
		String newTitleText = null;
		// do thing
		switch (need) {
			case HUNGRY: {
				this.pet.eat(item);
				newTitleText = "Replenished " + pet.getName() + "'s hunger to " + asPercent(pet.getNutrition());
				
				break;
			}
			case THIRSTY: {
				this.pet.drink(item);
				newTitleText = "Replenished " + pet.getName() + "'s thirst to " + asPercent(pet.getHydration());
				
				break;
			}
			case LONELY: {
				this.pet.receive(item);
				newTitleText = "Replenished " + pet.getName() + "'s love meter to " + asPercent(pet.getLove());
				
				break;
			}
		}
		
		// update gui text
		this.titleLabel.setText(newTitleText);
		this.infoLabel.setText("What would you like to do now?");
		
		// change buttons
		this.setButtonText(1, "Continue");
		this.setButtonText(2, "Save & Exit");
		this.setButtonText(3, "Quit");
		
		// update action listeners
		this.clearActionListeners(this.buttons);
		this.buttons[0].addActionListener(e -> {
			// Continue button
			runOnce();
		});
		this.buttons[1].addActionListener(e -> {
			// Save and exit button
			pdb.savePet(this.pet);
			pdb.dumpToFile();
			this.gameFrame.dispose();
			running = false;
		});
		this.buttons[2].addActionListener(e -> {
			// Exit without saving button
			this.gameFrame.dispose();
			running = false;
		});
	}

	/**
	 * Set the text of one of the buttons.
	 * @param n The number of the button to change the text of (1-indexed).
	 * @param text The text to put in the button.
	 */
	private void setButtonText(int n, String text) {
		if (this.buttons[n - 1] == null)
			return;

		this.buttons[n - 1].setText(text);
	}

	/**
	 * Set the text in all the buttons.
	 * @param text The label to apply to the buttons.
	 * @param items The text to put in each of the three buttons.
	 */
	private void setButtonsText(String text, String[] items) {
		this.setButtonText(1, text + " " + items[0]);
		this.setButtonText(2, text + " " + items[1]);
		this.setButtonText(3, text + " " + items[2]);
	}
	
	/**
	 * Reset the action listeners of the buttons.
	 * @param buttons The buttons.
	 */
	private void clearActionListeners(JButton[] buttons) {
		for (JButton button : buttons) {
			for (ActionListener al : button.getActionListeners()) {
				button.removeActionListener(al);
			}
		}
	}

	/**
	 * Convert a number to a string percentage.
	 * @param amount The number to convert.
	 * @return The number formatted as a percentage.
	 */
	private static String asPercent(float amount) {
		return String.format("%.0f%%", amount * 100);
	}

}
