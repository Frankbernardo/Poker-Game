import Player.Dealer;
import Player.Player;
import card.Card;
import hand.Hand;
import deck.Deck;
import helpers.PokerSolver;
public class Assignment1_2 {

	public static void main(String[] args) {
		//Create a Dealer
		Dealer dealer = new Dealer(new Deck());
		
		//Create 2 players: player1 and player2
		//Use the 3-arg constructor (name, id, hand)
		//Give any name and id you wish
		//Don't forget to send a new Hand object with handSize = 5
		Player player1 = new Player("Frank", "706", new Hand(5));
		Player player2 = new Player("Bob", "707", new Hand(5));
		//Loop 10 times.  
		//If the loop counter is even, deal a card to player1.
		//If the loop counter is odd, deal a card to player2.
		//print the deck
		System.out.println("before deal: \n" + dealer.getDeck());
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				dealer.dealCard(player1);
			} else {
				dealer.dealCard(player2);
			}
		}
		// print deck again
		System.out.println("after deal: \n" + dealer.getDeck());
		//Use PokerSolver's evaluatePokerGame method to see who won
		//Remember you have to send each player's hand.
		//How do you get the player's Hand object? 
		
		int [] results = PokerSolver. evaluatePokerGame (player1.getHand(), player2.getHand());

		//Print out the player's hands
		System.out.println("Player Hands:");
		System.out.println("Player 1: " + player1.getHand() + "\t" + player1.getHand().getHandDescr());
		System.out.println("Player 2: " + player2.getHand() + "\t" + player2.getHand().getHandDescr() + "\n");

		//Say who won the game
		//Remember, evaluatePokerGame returns an integer array the size equal to the number of players sent to the method.  The order of the array matches the order the players were sent to the method.
		//If the player has a 1 in thier element, they 1.  A 0 means they lost.  A 2 means a tie.
		if (results [0] == 1)  {
				System. out.println("Player 1 wins") ;
				}
				else if (results[1] == 1) {
				System.out.println("Player 2 wins");
				}
				else {
				System.out.println("It's a tie") ;
				}
		
		// send the hands to the discard pile
		
		// 1 get the hangs
		Hand tempHand1 = player1.getHand();
		Hand tempHand2 = player2.getHand();
		//get the card array from each hand
		Card[] tempCards1 = tempHand1.getCards();
		Card[] tempCards2 = tempHand2.getCards();
		//get deck from dealer
		Deck tempDeck = dealer.getDeck();
		// call the decks addDiscard
		tempDeck.addDiscard(tempCards1);
		tempDeck.addDiscard(tempCards2);
		// print the deck
		System.out.println("after hands in discard pile: \n" + dealer.getDeck());
		//restack the deck
		dealer.getDeck().restack();
		System.out.println("after restack: \n" + dealer.getDeck());
	}


}
