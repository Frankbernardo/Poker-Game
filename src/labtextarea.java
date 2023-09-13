import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class labtextarea extends Application {

	
	public void start(Stage primaryStage) {
		TextArea textArea = new TextArea(getText());
		//default edit in word wrap
		textArea.setEditable(false);
		textArea.setWrapText(false);
		
		//create 2 checkbox
		CheckBox chkEdit = new CheckBox("Editable");
		CheckBox chkWrap = new CheckBox("Wrap");
		
		//scroll pane
		ScrollPane scrollPane = new ScrollPane(textArea);
		
		//create listener
		chkEdit.setOnAction(e -> {
			textArea.setEditable(chkEdit.isSelected());
		});
		
		chkWrap.setOnAction(e -> {
			textArea.setWrapText(chkWrap.isSelected());
		});
		
		//create a hbox pane to hold check
		
		HBox chkPane = new HBox(5);
		chkPane.setAlignment(Pos.CENTER);
		chkPane.getChildren().addAll(chkEdit, chkWrap);
		
		
		//to hold all objects
		VBox pane = new VBox(10);
		pane.getChildren().addAll(scrollPane, chkPane);
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("text area lab");
		primaryStage.show();
	}
	
	
	
	
	private String getText() {
		
		return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
	}




	public static void main(String[] args) {
		launch(args);

	}

}
