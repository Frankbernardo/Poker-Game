import Player.Dealer;
import Player.Player;
import hand.Hand;

public class Assignment1_2 {

	public static void main(String[] args) {
		//Create a Dealer
		Dealer dealer = new Dealer(null);
		
		//Create 2 players: player1 and player2
		//Use the 3-arg constructor (name, id, hand)
		//Give any name and id you wish
		//Don't forget to send a new Hand object with handSize = 5
		Player player1 = new Player("Frank", "706", 5);
		Player player2 = new Player("Bob", "707", 5);
		//Loop 10 times.  
		//If the loop counter is even, deal a card to player1.
		//If the loop counter is odd, deal a card to player2.

		//Use PokerSolver's evaluatePokerGame method to see who won
		//Remember you have to send each player's hand.
		//How do you get the player's Hand object? 

		//Print out the player's hands
		System.out.println("Player Hands:");
		System.out.println("Player 1: " + player1.getHand() + "\t" + player1.getHand().getHandDescr());
		System.out.println("Player 2: " + player2.getHand() + "\t" + player2.getHand().getHandDescr() + "\n");

		//Say who won the game
		//Remember, evaluatePokerGame returns an integer array the size equal to the number of players sent to the method.  The order of the array matches the order the players were sent to the method.
		//If the player has a 1 in thier element, they 1.  A 0 means they lost.  A 2 means a tie.
		
	}

}
