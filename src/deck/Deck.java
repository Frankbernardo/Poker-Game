package deck;

import java.util.ArrayList;

import card.Card;

public abstract class Deck {
	protected ArrayList<Card> cards;
	private ArrayList<Card> discardPile;
	
	
	//Attributes go here
	
	public Deck() {
		//Create the attribute arrays with a size of 52
		cards = new ArrayList<Card>();
		discardPile = new ArrayList<Card>();
	}
	
	//This method populates the deck object with cards
	public abstract void createDeck();

	public void shuffleDeck() {
		Card tempCard;
		for(int i=0; i<cards.size(); i++) {
			int randomCard =(int) (Math.random()* cards.size());
			tempCard = cards.get(randomCard);
			cards.set(randomCard, cards.get(i));
			cards.set(i, tempCard);
			
		}
		
		//Create a routine to mix up the deck
	}

	public void addDiscard(Card card) {
		discardPile.add(card);
		
		//Lab 11.1
	}

	public void addDiscard(Card[] discards) {
		//Lab 11.1
		for (int i = 0; i< discards.length; i++) {
			discardPile.add(discards[i]);
			
		}
	}

	public void restack() {
		//Lab 11.1
		//remove card from discardpile
		//add to cards array
		while(discardPile.size() > 0) {
			cards.add(discardPile.remove(0));
		}
		// now shuffle
		shuffleDeck();
	}
	
	

	//To return a single Card object and leave in the Deck
	public Card getCard(int index) {
		
		return cards.get(index);
	}
	
	//To return a Card object and remove from the Deck
	public Card removeCard(int index) {
		//We will take of this later in the project
		
		
		return cards.remove(index);
	}

	public Card[] getCards() {
		//convert array list to an array
		Card[] tempCards = new Card[cards.size()];
		cards.toArray(tempCards);
		return tempCards;
	}

	public Card[] getDiscardPile() {
		Card[] tempCards = new Card[discardPile.size()];
		discardPile.toArray(tempCards);
		return tempCards;
	}
	
	@Override
	public String toString() {
		String deckString = "Deck\n";
		for(int i = 0; i<cards.size(); i++) {
			if(i !=0 && i % 13==0) {
				deckString += "\n";
			}
			deckString += cards.get(i) + " "; 
		}
		deckString +="\nDiscard pile:";
		for (int i=0; i<discardPile.size(); i++) {
			if(i !=0 && i % 13==0) {
				deckString += "\n";
			}
			deckString += discardPile.get(i) + " ";
		}
			
		return deckString;
	}

	
	//To return the entire deck
	
	
	//To return the discardPile
	

	//We need a toString()
	
}
