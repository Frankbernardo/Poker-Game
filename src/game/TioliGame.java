package game;

import Player.Dealer;
import Player.Player;
import card.Card;
import deck.StandardDeck;
import gamedata.GameData;
import gamedata.GameFile;
import gameobjects.CardSelector;
import gameobjects.GameOptions;
import gameobjects.GameTimer;
import gameobjects.PayoutTable;
import gameobjects.ScoreBoard;
import gameobjects.Wager;
import hand.Hand;
import hand.PokerHand;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TioliGame {
	//border pane to hold objects
	private BorderPane gameScreen = new BorderPane();
	
	//buttons
    private Button btnDeal = new Button("Deal");
    private Button btnTake = new Button("Take It");
    private Button btnLeave = new Button("Leave It");
    private Button btnExit = new Button("Exit");
	
	//panes to hold nodes in each section
	private HBox topSection = new HBox(10);
	private HBox bottomSection = new HBox(10);
	private VBox leftSection = new VBox(10);
	private VBox rightSection = new VBox(10);
	private VBox centerSection = new VBox(10);
	private VBox takeLeaveButtonPane = new VBox(10, btnTake, btnLeave);
	
	
	
	//our game people
	private Dealer dealer;
	private Player player;
	
	//play are
	private PlayerArea playerArea;
	private DealerArea dealerArea;
	
	//hbox for the header
	private HBox header;
	private PayoutTable payoutTable;
	private Wager wager;
	private ScoreBoard scoreBoard;
	private GameTimer timerObj = new GameTimer(30, btnLeave);
	private GameOptions gameOptions;
	private CardSelector cardSelector;
	private int maxTioliCards = 5;
	private int tioliCardsDealt = 0;
	private int gamesPlayed = 0;



	
	public TioliGame(Player player) {
		//initialize
		this.player = player;
		
		//instantion
		dealer = new Dealer(new StandardDeck(), new PokerHand());
		//instantiate our player and dealer class
		dealerArea = new DealerArea(dealer);
		playerArea = new PlayerArea(this.player);
		
		payoutTable = new PayoutTable();
		wager = new Wager(player, 25);
		scoreBoard = new ScoreBoard(player);
		gameOptions = new GameOptions(dealerArea, timerObj);
		cardSelector = new CardSelector(5);
		btnTake.setDisable(true);
		btnLeave.setDisable(true);
		createHeader();
		
		addObjectsToTopSection();
		addObjectstoBottomSection();
		addObjectsToLeftSection();
		addObjectsToRightSection();
		addObjectsToCenterSection();
		
		//add section to the gamescreen
		addObjectsToGameScreen();
		//addGameObjects();
		cardSelector.setDisable(true);
		showGame();
		
		btnTake.setOnAction(event -> takeIt());
		btnLeave.setOnAction(event -> leaveIt());
		
		//temp till button
		//startDeal();
	}
	
	/** private void addGameObjects() {
	    payoutTable = new PayoutTable();
	    wager = new Wager(player, 0, "green");
	    scoreBoard = new ScoreBoard(player);
	} **/
	
	private void createHeader() {
		Text headerText = new Text("Welcome " + player.getName() + " to The Game Take It Or Leave It");
		headerText.setFont(Font.font("Arial", 37));
		
		header = new HBox(headerText);
	}
	
	private void addObjectsToTopSection() {
		topSection.getChildren().addAll(header);
		topSection.setAlignment(Pos.BASELINE_CENTER);
		topSection.setPadding(new Insets(10,10,80,10));
	}
	
	private void addObjectstoBottomSection() {
		//add items to the bottom
	}
	
	private void addObjectsToLeftSection() {
		leftSection.getChildren().addAll(gameOptions);
		//add items to left section 
	}
	
	private void addObjectsToRightSection() {
		
		rightSection.getChildren().addAll(payoutTable, wager, scoreBoard, btnExit);
		
		btnExit.setOnAction(e -> {
			Platform.exit();
			System.exit(0);
		});

	   
		
		
	}
	
	private void addObjectsToCenterSection() {
		
		centerSection.getChildren().addAll(timerObj, dealerArea, playerArea);
		playerArea.getChildren().add(cardSelector);
		cardSelector.setPadding(new Insets(0,0,0,80));
		playerArea.getChildren().add(btnDeal);
		
		btnDeal.setOnAction(event -> startDeal());


		dealerArea.getChildren().add(takeLeaveButtonPane);
		
		
	}
	
	private void addObjectsToGameScreen() {
		gameScreen.setTop(topSection);
		gameScreen.setCenter(centerSection);
		gameScreen.setRight(rightSection);
		gameScreen.setLeft(leftSection);
		//just some extra styling
		
		BorderPane.setMargin(playerArea, new Insets(0,0,50,0));
	}
	
	private void showGame() {
		//make scene object
		Scene scene = new Scene(gameScreen, 1000, 650);
		
		// set title
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Franks Tioli");
		
		primaryStage.setScene(scene);
		// show the stage
		primaryStage.show();
	}
	
	//code for playing the game
	
	private void startDeal() {
		gamesPlayed++;
		gameOptions.setDisable(true);
		wager.setDisable(true);
		clearCards();
		playerArea.clearPlayerHand();
		dealerArea.clearDiscardHolder();
		
	    btnTake.setDisable(false);
	    btnLeave.setDisable(false);
		
		dealerPlayer();
		evaluateHand();
		playerArea.showCards();
		playerArea.showHandDescr();
		
		dealDealer();
		
		cardSelector.setDisable(false);
		
		btnDeal.setDisable(true);

	    
	    timerObj.startTimer();
	    
	    scoreBoard.resetWinAmount();
	    
	    if (gamesPlayed == 4) {
	        dealer.reshuffleDeck();;
	        gamesPlayed = 0;
	    }
	    
	    
	}

	private void dealDealer() {
		dealer.dealCard(dealer);
		
		dealerArea.showTioliCard();
		tioliCardsDealt++;
		
	}

	private void evaluateHand() {
		player.getHand().evaluateHand();
		
	}

	private void dealerPlayer() {
		for(int i=0; i<5; i++) {
			dealer.dealCard(player);
		}
		
	}
	
	private void takeIt() {
	    System.out.println("Take It button pressed.");
	    
	    
	    timerObj.stopTimer();


	    int selectedIndex = cardSelector.getCardSelected() - 1;


	    Card selectedCard = player.getHand().getCard(selectedIndex);


	    Card tioliCard = dealer.getHand().removeCard(0);

	    player.getHand().setCard(selectedIndex, tioliCard);

	 
	    dealer.getDeck().addDiscard(selectedCard);


	    dealerArea.clearTioliHolder();

	
	    dealerArea.showDiscardedCard(selectedCard);

	
	    playerArea.showCards();

	    evaluateHand();


	    playerArea.showHandDescr();

	
	    if (tioliCardsDealt == maxTioliCards) {
	        endHand();
	    } else {
	        dealDealer();
	        timerObj.startTimer();
	    }


	   
	    
	}

	private void leaveIt() {
	    System.out.println("Leave It button pressed.");
	    
	    timerObj.stopTimer();

	    
	    Card tioliCard = dealer.getHand().removeCard(0);

	
	    dealer.getDeck().addDiscard(tioliCard);

	   
	    dealerArea.clearTioliHolder();

	
	    dealerArea.showDiscardedCard(tioliCard);

	    if (tioliCardsDealt == maxTioliCards) {
	        endHand();
	    } else {
	        dealDealer();
	        timerObj.startTimer();
	    }


	   
	    
	}

	public void clearCards() {
		player.getHand().discardAll(dealer.getDeck());
		

	}
	
	public void endHand() {
	    int amountWon = getPayout();
	    displayFinalResults(amountWon);
	    player.getHand().discardAll(dealer.getDeck());
	    
	    tioliCardsDealt = 0; 
	    
	    btnDeal.setDisable(false);

	    
	    btnTake.setDisable(true);
	    btnLeave.setDisable(true);
	    
	    cardSelector.setDisable(true);
	    gameOptions.setDisable(false);
	    wager.setDisable(false);
	    
	    
	    writeDataToFile(amountWon);
	    saveDataInDatabase(amountWon);
	    
	}
	
	private void saveDataInDatabase(int amountWon) {
		// TODO Auto-generated method stub
		GameData gameData = new GameData();
		
		gameData.insertHand(player);
		gameData.updateBank(player);
		gameData.insertResults(player, amountWon);


		
		//When done with the database, close it
		gameData.close();
	}

	private int getPayout() {

	    int handRank = player.getHand().getHandRank();

	
	    int betAmount = wager.getWagerAmount();


	    int payout = payoutTable.getPayout(handRank, betAmount);

	    
	    return payout;


	}
	
	public void displayFinalResults(int amountWon) {

	    player.setBank(player.getBank() + amountWon);

	 
	    scoreBoard.setWinAmount(amountWon);
	    scoreBoard.updateBank();
	}
	
    private void writeDataToFile(int amountWon) {
        GameFile.writeData("gamedata.dat", player, amountWon);
    }

	

}
