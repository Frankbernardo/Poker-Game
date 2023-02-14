package hand;

import java.util.ArrayList;

import card.Card;
import deck.Deck;
import helpers.PokerSolver;

public class Hand {
	//Create the attributes
	private ArrayList<Card> cards;
	private String handDescr;
	private int handScore;
	private int handRank;
	private int highCard;
	
	
	//Attributes used use by the PokerSolver
	
	//Use this to prevent adding too many items to the cards array
	//private int cardCounter = 0;

	public Hand() {
		//Only need to establish an empty cards array here
		
		cards = new ArrayList<Card>();
		handDescr = " ";
		handScore = 0;
		handRank = 0;
		highCard = 0;
		
	}
	
	public Hand(Card[]dealtCards) {
		//Create the empty array
		cards = new ArrayList<Card>();
		//Loop through the dealtCards array and add each card object to the cards array
		//cards = new Card[dealtCards.length];
		for (int i = 0; i < dealtCards.length; i++) {
			  cards.add(dealtCards[i]);
			}
	}
	
	public void addCard(Card dealtCard) {
		//We are sent 1 card
		//If the array is not full, then add the card
		//Otherwise, just ignore it
		//Keep track of the number of cards added to the cards array
		cards.add(dealtCard);
		
		
		
		/**if (cardCounter < cards.length) {
			  cards[cardCounter] = dealtCard;
			  cardCounter++;
			}**/
	}
	
	public void addCard(Card[] dealtCards) {
		//We are sent multiple cards
		//Loop through the array and try to add each card to the cards array
		//If the array is not full, then add the card
		//Otherwise, just ignore it
		//Keep track of the number of cards added to the cards array
		  for (int i = 0; i < dealtCards.length; i++) {
			    cards.add(dealtCards[i]);
			  
			  
			  /**if (cardCounter< cards.length) {
			      cards[cardCounter] = dealtCards[i];
			      cardCounter++;
			      } **/
			   }
		  
	}
	
	//Put a card into a specific element within the Hand
    public void setCard(int index, Card dealtCard){
    	cards.set(index, dealtCard);
    }
	
	//Get a specific Card object at a specific index
	public Card getCard(int index) {
		return cards.get(index);
	}
	
	//Get a specific Card object at a specific index and remove from Hand
	public Card removeCard(int index) {
		//Assignment 2.1
		Card removeCard = cards.get(index);
		cards.remove(index);
		return removeCard ;
	}
	
	public void evaluateHand() {
		//Call the PokerSolver class to evaluate the hand (see PokerSolver UML)
		//Note: "this" represents the current object
		PokerSolver.evaluateHand(this);
	}
	
	public void discard(Deck deck, int index) {
		Card discardCard = removeCard(index);
		deck.addDiscard(discardCard);
		
		//Assignment 2.1
	}
	
	public void discardAll(Deck deck) {
		while (cards.size() > 0) {
			Card discardCard = cards.get(0);
			deck.addDiscard(discardCard);
			cards.remove(0);
		}
		//Assignment 2.1
	}
	
	@Override
	public String toString() {
		//Return a string with the card objects in the hand
		String returnHand = " ";
		for (int i = 0; i < cards.size(); i++) {
			returnHand = returnHand + cards.get(i) + " ";		
		
		}
		return returnHand;
	//Add the typical getters/setters

	}

	public Card [] getCards() {
		Card[] tempCards = new Card[cards.size()];
		cards.toArray(tempCards);
		return tempCards;
		
	}

	public String getHandDescr() {
		return handDescr;
	}

	public void setHandDescr(String handDescr) {
		this.handDescr = handDescr;
	}

	public int getHandScore() {
		return handScore;
	}

	public void setHandScore(int handScore) {
		this.handScore = handScore;
	}

	public int getHandRank() {
		return handRank;
	}

	public void setHandRank(int handRank) {
		this.handRank = handRank;
	}

	public int getHighCard() {
		return highCard;
	}

	public void setHighCard(int highCard) {
		this.highCard = highCard;
	}


	
}
