package Player;

import card.Card;
import deck.Deck;
import hand.Hand;

public class Dealer {
	private Deck deck;
	
	public Dealer(Deck deck) {
		this.deck = deck;
		
		prepareDeck();
	}

	private void prepareDeck() {
		deck.createDeck();
		deck.shuffleDeck();
		
		
	}
	
	public void dealCard(Player player, int index) {
		//Deal the card at index to the players hand
		//assignment 1.2
		Card tempCard = deck.getCard(index);
		Hand playerHand = player.getHand();
		playerHand.addCard(tempCard);
		
	}
	
	public Card getCard(int index) {
		Card tempCard = deck.getCard(index);
		
		return tempCard;
	}
	
	public void reshuffleDeck() {
		deck.shuffleDeck();
		
		//lab 11.1 replace with logic to reshuffle
	}

	public Deck getDeck() {
		return deck;
	}
	
	
}

