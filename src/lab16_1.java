import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class lab16_1 extends Application{
	
	Text text = new Text("Hello There");
	CheckBox chkBold = new CheckBox("Bold");
	CheckBox chkItalic = new CheckBox("Italic");
	
	RadioButton rbRed = new RadioButton("Red");
	RadioButton rbYellow = new RadioButton("Yellow");
	RadioButton rbBlack = new RadioButton("Black");
	RadioButton rbOrange = new RadioButton("Orange");
	RadioButton rbGreen = new RadioButton("Green");
	
	ComboBox<String> cbFontFamilies = new ComboBox<String>();
	ComboBox<Integer> cbFontSize = new ComboBox<Integer>();
	
	public void start(Stage primaryStage) {
		
		// populate create font type combo box
		
		cbFontFamilies.getItems().addAll(Font.getFamilies());
		// set default
		cbFontFamilies.setValue(text.getFont().getFamily());
		
		//add label
		Label lblFF = new Label("Font Name", cbFontFamilies);
		
		lblFF.setContentDisplay(ContentDisplay.RIGHT);
		
		// populate font size
		cbFontSize.getItems().addAll(getSizes());
		cbFontSize.setValue((int)text.getFont().getSize());
		
		//labe for font size
		Label lblFS = new Label("Font Size", cbFontSize);
		lblFS.setContentDisplay(ContentDisplay.RIGHT);
		
		
		//create hbox to hold 2 drop downs
		HBox comboBoxPane = new HBox(20);
		comboBoxPane.getChildren().addAll(lblFF, lblFS);
		comboBoxPane.setPadding(new Insets(15));
		
		//create combo listeners
		cbFontFamilies.setOnAction(e -> update());
		cbFontSize.setOnAction(e -> update());
		
		//create listeners 
		
		chkBold.setOnAction(e -> update());
		chkItalic.setOnAction(e -> update());
		
		//create hbox to hold check box
		HBox checkBoxPane = new HBox(chkBold, chkItalic);
		checkBoxPane.setSpacing(30);
		checkBoxPane.setPadding(new Insets(15));
		checkBoxPane.setAlignment(Pos.CENTER);
		//create stackpane for text
		StackPane centerPane = new StackPane(text);
		BackgroundFill backgroundFill = new BackgroundFill(Color.AQUAMARINE, null, null);
		Background background = new Background(backgroundFill);
		centerPane.setBackground(background);
		update();
		// hbox for radio button
		HBox pnforrb = new HBox(20);
		pnforrb.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
		pnforrb.setAlignment(Pos.CENTER);
		pnforrb.setPadding(new Insets(10));
		
		VBox paneForButtons = new VBox(10);
		paneForButtons.getChildren().addAll(checkBoxPane, pnforrb);
		//toggle
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbBlack.setToggleGroup(group);
		rbOrange.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		
		//set default color
		rbBlack.setSelected(true);
		
		//create listeners
		radioButtonHand();
		//borderpane to hold all
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(comboBoxPane);
		borderPane.setCenter(centerPane);
		borderPane.setBottom(paneForButtons);
		borderPane.setBackground(background);

		
		
		//the usual code for showing window
		Scene scene = new Scene(borderPane, 500, 500);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("this is a window :)");
		primaryStage.show();
		
		
		
	}

	private Integer[] getSizes() {
		Integer [] size = new Integer[100];
		
		for(int i=0; i<size.length; i++) {
			size[i] = i+1;
		}
		
		return size;
	}

	private void radioButtonHand() {
		rbRed.setOnAction(e -> {
			if(rbRed.isSelected()) {
				text.setFill(Color.RED);
			}
		});
		
		rbYellow.setOnAction(e -> {
			if(rbYellow.isSelected()) {
				text.setFill(Color.YELLOW);
			}
		});
		
		rbBlack.setOnAction(e -> {
			if(rbBlack.isSelected()) {
				text.setFill(Color.BLACK);
			}
		});
		
		rbOrange.setOnAction(e -> {
			if(rbOrange.isSelected()) {
				text.setFill(Color.ORANGE);
			}
		});
		
		rbGreen.setOnAction(e -> {
			if(rbGreen.isSelected()) {
				text.setFill(Color.GREEN);
			}
		});
	}

	private void update() {
		// when something happens
		
		//determine the weight of the font
		
		FontWeight fontWeight = (chkBold.isSelected()) ? FontWeight.BOLD : FontWeight.NORMAL;
		FontPosture fontPosture = (chkItalic.isSelected()) ? FontPosture.ITALIC : FontPosture.REGULAR;
		
		// get font name for box
		String fontFamily = cbFontFamilies.getValue();
		
		//set size
		double size = cbFontSize.getValue();
		
		//update test
		text.setFont(Font.font(fontFamily, fontWeight, fontPosture, size));
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
