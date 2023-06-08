package run;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

import animals.Animal;

/** @author Nate Evans 21144881 */
public class GameLoop {

	public boolean running;
	public Animal pet;
	public JLabel titleLabel, infoLabel;
	public JButton[] statusButtons;

	public GameLoop(Animal pet) {
		running = true;
		this.pet = pet;
	}

	public void run() {
		while (running) {
			runOnce();
			return; // temp
		}
	}

	public void runOnce() {
		Random rand = new Random();
		int need = rand.nextInt(3);
		String petName = pet.getName();

		switch (need) {
			case 0: { // hungry
				pet.makeHungry();
				setStatusText(petName + " is " + asPercent(1 - pet.getNutrition()) + " hungry!");
				setInfoText("What will you feed " + petName + "?");
	
				String[] foods = pet.getFoods();
				setButtonsText("Feed", foods);
			}
			case 1: { // thirsty
				pet.makeHungry();
				setStatusText(petName + " is " + asPercent(1 - pet.getHydration()) + " thirsty!");
				setInfoText("What will you give " + petName + "?");
	
				String[] drinks = pet.getLiquids();
				setButtonsText("Drink", drinks);
			}
			case 2: { // lonely
				pet.makeHungry();
				setStatusText(petName + " is " + asPercent(1 - pet.getLove()) + " lonely!");
				setInfoText("What will you do to " + petName + "?");
	
				String[] actions = pet.getActions();
				setButtonsText("Do", actions);
			}
		}
	}

	private void setStatusText(String text) {
		if (titleLabel == null)
			return;

		titleLabel.setText(text);
	}

	private void setInfoText(String text) {
		if (infoLabel == null)
			return;

		infoLabel.setText(text);
	}

	private void setButtonText(int n, String text) {
		if (statusButtons[n - 1] == null)
			return;

		statusButtons[n - 1].setText(text);
	}

	private void setButtonsText(String text, String[] items) {
		setButtonText(1, text + " " + items[0]);
		setButtonText(2, text + " " + items[1]);
		setButtonText(3, text + " " + items[2]);
	}

	private static String asPercent(float amount) {
		return String.format("%.0f%%", amount * 100);
	}

}
