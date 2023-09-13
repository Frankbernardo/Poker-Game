import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class lab16_5 extends Application{
	
	private Text text = new Text("wow colors!!!");
	private Slider slRed = new Slider();
	private Slider slGreen = new Slider();
	private Slider slBlue = new Slider();
	private ScrollBar sb = new ScrollBar();
	
	public void start(Stage primaryStage) {
		text.setFont(Font.font("Arial", FontWeight.BOLD, 28));
		StackPane paneText = new StackPane(text);
		paneText.setPadding(new Insets(20,10,5,10));
		
		//set sliders
		slRed.setMin(0.0);
		slRed.setMax(1.0);
		slGreen.setMin(0.0);
		slGreen.setMax(1.0);
		slBlue.setMin(0.0);
		slBlue.setMax(1.0);
		
		//create listeners
		slRed.valueProperty().addListener(ov -> setColor());
		slGreen.valueProperty().addListener(ov -> setColor());
		slBlue.valueProperty().addListener(ov -> setColor());
		
		// set prob for scroll
		sb.setOrientation(Orientation.HORIZONTAL);
		sb.setMin(0.0);
		sb.setMax(1.0);
		
		// create listener
		sb.valueProperty().addListener(ov -> setColor());
		sb.setValue(1.0);
		
		//creat grid pane to hold sliders
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(5);
		pane.setHgap(5);
		pane.add(new Label("Red"), 0, 0);
		pane.add(slRed, 1, 0);
		pane.add(new Label("Green"), 0, 1);
		pane.add(slGreen, 1, 1);
		pane.add(new Label("Blue"), 0, 2);
		pane.add(slBlue, 1, 2);
		pane.add(new Label("Opacity"), 0, 3);
		pane.add(sb, 1, 3);
		
		//place in border pane
		BorderPane bPane = new BorderPane();
		bPane.setTop(paneText);
		bPane.setCenter(pane);
		
		Scene scene = new Scene(bPane, 250, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("sliders and stuff");
		primaryStage.show();
		
	}

	private void setColor() {
		text.setFill(new Color(slRed.getValue(), slGreen.getValue(), slBlue.getValue(), sb.getValue()));
	}

	public static void main(String[] args) {
		launch(args);

	}

}
