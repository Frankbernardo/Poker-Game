import Player.Dealer;
import Player.Player;
import card.Card;
import deck.Deck;
import deck.PinochleDeck;
import hand.BlackjackHand;
import hand.Hand;

public class Assignment2_2 {

	public static void main(String[] args) {
		Dealer dealer = new Dealer(new PinochleDeck(), new Hand());
		System.out.println("Pinochle Deck: " + dealer.getDeck());
		Dealer dealer2 = new Dealer(new Deck(), new Hand());
		System.out.println("Standard deck: "+dealer2.getDeck());
		System.out.println("Cards in standard deck : " + Card.getCardsCreated());
		
		
		
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
