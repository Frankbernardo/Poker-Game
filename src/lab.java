import deck.Deck;
import Player.Dealer;
import card.Card;
public class lab {
	public static void main(String[] args) {
		Dealer fred = new Dealer(new Deck());
		System.out.println(fred.getDeck() +"\n");
		
		Card[] hand = new Card[5];
		
		for(int i=0; i<hand.length; i++) {
			hand[i] = fred.getCard(i);
		}
		
		for(int i=0; i<hand.length; i++) {
			System.out.println(hand[i] + " ");
		}
		
		System.out.println("\nNumber of Cards created: " + Card.getCardsCreated());
		
		// Print the color of the first in the deck
		
		for(int i=0; i<5; i++) {
			//get the deck from the dealer
			Deck tempDeck = fred.getDeck();
			//get the card from the deack
			Card tempCard = tempDeck.getCard(i);
			//get the color
			String tempColor = tempCard.getColor();
			
			
			System.out.println("Card " + (i+1) + " Color: " + tempColor);
			
			
		}
		
	}

}
