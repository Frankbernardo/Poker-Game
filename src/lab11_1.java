

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		import Player.Dealer;
		import Player.Player;
		import hand.Hand;
		import deck.Deck;
		import helpers.PokerSolver;
		

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
				
				for (int i = 0; i < 10; i++) {
					if (i % 2 == 0) {
						dealer.dealCard(player1);
					} else {
						dealer.dealCard(player2);
					}
				}

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
			}

	}


