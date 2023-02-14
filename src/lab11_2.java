import Player.Dealer;
import Player.Player;
import deck.Deck;
import hand.BlackjackHand;
import hand.Hand;
import helpers.PokerSolver;

public class lab11_2 {

	public static void main(String[] args) {
		Dealer dealer = new Dealer(new Deck());
		
		Player joe = new Player("joe", "1234", new Hand());
		Player fred = new Player("fred", "1235", new Hand());
		
		//deal poker hand
		for(int i=0; i<10; i++) {
			if(i%2 == 0) {
				dealer.dealCard(fred);
			}
			else {
				dealer.dealCard(joe);
			}
		}
		
		int [] handResult = PokerSolver.evaluatePokerGame(fred.getHand(), joe.getHand());
		
		
		System.out.println("Poker:\nPlayer Hands:\n");
		System.out.println(fred.getName() +"\t" + fred.getHand() + "\t" + fred.getHand().getHandDescr());
		System.out.println(joe.getName() +"\t" + joe.getHand() + "\t" + joe.getHand().getHandDescr());
		
		//If the player has a 1 in thier element, they 1.  A 0 means they lost.  A 2 means a tie.
				if (handResult [0] == 1)  {
						System. out.println(fred.getName() +" wins") ;
						}
						else if (handResult[1] == 1) {
						System.out.println(joe.getName()+" wins");
						}
						else {
						System.out.println("It's a tie") ;
						}
		
			//play blackjack
		Dealer dealer21 = new Dealer(new Deck());
		
		Player bobDealer = new Player("Dealer", "Dealer", new BlackjackHand());
		Player taco = new Player("taco", "1212", new BlackjackHand());
		
		for(int i =0; i<4; i++) {
			if(i%2 == 0) {
				dealer21.dealCard(taco);
			}
			else {
				dealer21.dealCard(bobDealer);
			}
		}
		
		System.out.println("\nBlackJack\n");
		System.out.println(taco.getHand() + "'s Hand\t");
		System.out.println(bobDealer.getHand() + "'s Hand\t");	
		Hand temptacohand = taco.getHand();
		taco.getHand().evaluateHand();
		bobDealer.getHand().evaluateHand();
		
		BlackjackHand tacohand = (BlackjackHand)(temptacohand);
		if(tacohand.isBlackjack()) {
			System.out.println(taco.getName() + " has blackjack");
		}
		else {
			System.out.println(taco.getName() + " has no blackjack");
		}
		
		//BlackjackHand bobhand = (BlackjackHand)bobDealer.getHand();
		//in one step
		if(((BlackjackHand)bobDealer.getHand()).isBlackjack()) {
			System.out.println(bobDealer.getName() + " has blackjack");
		}
		else {
			System.out.println(bobDealer.getName() + " has no blackjack");
		}
		Hand temptaco = taco.getHand();
		int tacoscore = temptaco.getHandScore();
		System.out.println("\n" + taco.getName() + " has a score of: " + tacoscore);
		System.out.println("\n" + bobDealer.getName() + " has a score of: " + bobDealer.getHand().getHandScore());
		
	}

}
