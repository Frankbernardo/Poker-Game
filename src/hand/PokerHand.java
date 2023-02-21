package hand;

import card.Card;
import helpers.PokerSolver;

public class PokerHand extends Hand {
	private String handDescr = "";
	

	public PokerHand() {
		
	}

	public String getHandDescr() {
		return handDescr;
	}

	public void setHandDescr(String handDescr) {
		this.handDescr = handDescr;
	}

	public PokerHand(Card[] dealtCards) {
		super(dealtCards);
		
	}
	
	public void evaluateHand() {
		//Call the PokerSolver class to evaluate the hand (see PokerSolver UML)
		//Note: "this" represents the current object
		PokerSolver.evaluateHand(this);
	}
}
