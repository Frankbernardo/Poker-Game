package gameobjects;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class CardSelector extends HBox{
	private RadioButton[] optionButtons;
	private ToggleGroup group = new ToggleGroup();
	private int cardSelected = 0;
	
	
	public CardSelector(int numberOfCards) {
		this.optionButtons = new RadioButton[numberOfCards];
		
		createOptionButtons();
		
	}


	private void createOptionButtons() {
		for(int i=0; i<optionButtons.length; i++) {
			optionButtons[i] = new RadioButton();
			//add option button to toggle grouo
			optionButtons[i].setToggleGroup(group);
			
			// style
			optionButtons[i].setPadding(new Insets(0,60,20,0));
			//create listener
			final int index = i;
			optionButtons[i].setOnAction(e -> {
				cardSelected = index +1;
				System.out.println("selected cards: " + cardSelected);
			});
			
			//add it to the hbox
			this.getChildren().add(optionButtons[i]);
			
		}
		
	}


	public int getCardSelected() {
		return cardSelected;
	}
	
	public void clearOptions() {
		for(int i=0; i<optionButtons.length; i++) {
			optionButtons[i].setSelected(false);
		}
		cardSelected = 0;
	}

}
