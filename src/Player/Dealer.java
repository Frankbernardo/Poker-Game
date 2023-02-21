package Player;

import card.Card;

import deck.Deck;
import hand.Hand;

public class Dealer extends Player {
	private Deck deck;
	
	public Dealer(Deck deck) {
		this.deck = deck;
		prepareDeck();
	}
	
	public Dealer(Deck deck, Hand hand) {
		super("Dealer", "dealer", 0, hand);
		this.deck = deck;
		prepareDeck();
	}

	

	private void prepareDeck() {
		deck.createDeck();
		deck.shuffleDeck();
		
		
	}
	
	public void dealCard(Player player) {
		//Deal the card at index to the players hand
		//assignment 1.2
		Card tempCard = deck.removeCard(0);
		Hand playerHand = player.getHand();
		playerHand.addCard(tempCard);
		
	}
	
	public Card getCard(int index) {
		Card tempCard = deck.getCard(index);
		
		return tempCard;
	}
	
	public void reshuffleDeck() {
		Card[] tempDeck = deck.getCards();
		Card[] tempDiscard = deck.getDiscardPile();
		int totalCards = tempDeck.length + tempDiscard.length;
		int reshuffleCount = (int)(totalCards*.7);
		if (tempDeck.length < reshuffleCount) {
		deck.restack();
		}
		//lab 11.1 replace with logic to reshuffle
	}

	public Deck getDeck() {
		return deck;
	}
	
	
}

