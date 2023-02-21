import Player.Dealer;
import Player.Player;
import card.Card;
import deck.Deck;
import deck.PinochleDeck;
import hand.BlackjackHand;
import hand.Hand;
import hand.PokerHand;
import helpers.PokerSolver;

public class lab_13_1 {

	public static void main(String[] args) {
		Dealer pokerDealer = new Dealer(new Deck(), new PokerHand());
		Player fastFreddy = new Player("fast freddy","1",new PokerHand());
		
		for(int i=0; i<10; i++) {
			if(i%2 == 0) {
				pokerDealer.dealCard(fastFreddy);
			}
			else {
				pokerDealer.dealCard(pokerDealer);
			}
		}
		
		PokerHand dealerHand = (PokerHand)pokerDealer.getHand();
		PokerHand freddyHand = (PokerHand)fastFreddy.getHand();
		
		int [] results = PokerSolver. evaluatePokerGame(dealerHand, freddyHand);
		
		System.out.println("Poker:\nPlayerHands:\n");
		System.out.println(pokerDealer.getName() + "\t" + dealerHand.getHandDescr());
		System.out.println(fastFreddy.getName() + "\t" + freddyHand.getHandDescr());
		
		
		if(results[0] == 1) {
			System.out.println(pokerDealer.getName()+"\t" + "Wins :");
		}
		else if(results[1] == 1) {
			System.out.println(fastFreddy.getName()+"\t" + "Wins :");
		}
		else {
			System.out.println("its a tie");
		}

		
		
		
		Dealer bobDealer = new Dealer(new Deck(),  new BlackjackHand());
		Player taco = new Player("taco", "1212", new BlackjackHand());
		
		for(int i =0; i<4; i++) {
			if(i%2 == 0) {
				bobDealer.dealCard(taco);
			}
			else {
				bobDealer.dealCard(bobDealer);
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
