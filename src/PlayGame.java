import Player.Player;
import game.TioliGame;
import gamedata.GameData;
import hand.PokerHand;
import javafx.application.Application;
import javafx.stage.Stage;

public class PlayGame extends Application {
	
	public void start(Stage primaryStage) {
		// Create a GameData object called databaseObj
		GameData databaseObj = new GameData();

		// Get a random Player object using the databaseObj object
		Player player = databaseObj.getRandomPlayer();
		
		new TioliGame(player);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}