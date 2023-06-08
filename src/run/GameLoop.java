package run;

import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import animals.Animal;

/** @author Nate Evans 21144881 */
public class GameLoop {
	
	private enum Need {
		HUNGRY, THIRSTY, LONELY;
	}

	public boolean running;
	public Animal pet;
	public JFrame gameFrame;
	public JLabel titleLabel, infoLabel;
	public JButton[] buttons;

	public GameLoop(Animal pet) {
		running = true;
		this.pet = pet;
	}
	
	public void run() {
		this.runOnce();
	}

	public void runOnce() {
		buttons[0].setText("Debug1");
		buttons[1].setText("Debug1");
		buttons[2].setText("Debug1");
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
		this.setButtonText(2, "Exit without Saving");
		this.setButtonText(3, "Exit and Save");
		
		// update action listeners
		this.clearActionListeners(this.buttons);
		this.buttons[0].addActionListener(e -> {
			// Continue button
			runOnce();
		});
		this.buttons[1].addActionListener(e -> {
			// Exit without saving button
			this.gameFrame.dispose();
			running = false;
		});
		this.buttons[2].addActionListener(e -> {
			// Exit and save button
			// TODO save pet
			this.gameFrame.dispose();
			running = false;
		});
	}

	private void setButtonText(int n, String text) {
		if (this.buttons[n - 1] == null)
			return;

		this.buttons[n - 1].setText(text);
	}

	private void setButtonsText(String text, String[] items) {
		this.setButtonText(1, text + " " + items[0]);
		this.setButtonText(2, text + " " + items[1]);
		this.setButtonText(3, text + " " + items[2]);
	}
	
	private void clearActionListeners(JButton[] buttons) {
		for (JButton button : buttons) {
			for (ActionListener al : button.getActionListeners()) {
				button.removeActionListener(al);
			}
		}
	}

	private static String asPercent(float amount) {
		return String.format("%.0f%%", amount * 100);
	}

}
