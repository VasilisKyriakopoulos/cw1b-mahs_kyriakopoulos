package gr.uop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
		root.setPadding(new Insets(10,10,10,10));
		root.setHgap(5);
		root.setVgap(5);
		
		Button btn1 = new Button();
		btn1.setText("Καθαρισμός");
        Button btn2 = new Button();
		btn2.setText("->");
        Button btn3 = new Button();
		btn3.setText("<-");
		GridPane.setConstraints(btn1,0,4);
		Text textCelsius = new Text("Κελσίου");
        Text textFahrenheit = new Text("Φαρενάιτ");
        TextField textFieldCelsius = new TextField(); 
        TextField textFieldFahrenheit = new TextField(); 

        VBox textCelsiusPane = new VBox();
        textCelsiusPane.getChildren().add(textCelsius);
        VBox textFahrenheitPane = new VBox();
        textFahrenheitPane.getChildren().add(textFahrenheit);
        textCelsiusPane.setPadding(new Insets(4,10,0,10));
        textFahrenheitPane.setPadding(new Insets(4,10,0,10));
        HBox mainPane = new HBox();
        VBox buttonsPane = new VBox();
        buttonsPane.getChildren().addAll(btn2,btn3);
        mainPane.getChildren().addAll(textCelsiusPane,textFieldCelsius,buttonsPane,textFieldFahrenheit,textFahrenheitPane);
        buttonsPane.setPadding(new Insets(-10,10,10,10));
        mainPane.setPadding(new Insets(20,10,10,10));
        mainPane.setAlignment(Pos.TOP_CENTER);
        Text textError = new Text();
        textError.setFill(Color.RED);
        VBox errorPane = new VBox();
        errorPane.getChildren().add(textError);
        GridPane rootPane = new GridPane();
        rootPane.add(mainPane, 0, 0);
        rootPane.add(errorPane, 0, 1); 
        rootPane.setAlignment(Pos.TOP_CENTER);
        rootPane.add(btn1, 0, 2);
        btn1.setPadding(new Insets(0,1,0,0));

        HBox button1Pane = new HBox();
		button1Pane.getChildren().add(btn1);
		rootPane.add(button1Pane, 0, 1);
		button1Pane.setAlignment(Pos.BASELINE_CENTER);
		textFieldCelsius.setOnKeyPressed(event->{
			
			if (event.getCode()==KeyCode.ENTER){
				if (textFieldCelsius.getText()!=""){
					try{
						int toNum = Integer.parseInt(textFieldCelsius.getText());			
							int fahrResult = (int)(toNum)*9/5 + 32;
							textFieldFahrenheit.setText(String.valueOf(fahrResult));
							textError.setText("");
						}
						catch (Exception e){
							textError.setText("You need to give an Integer.");
							
						}
				}
				else {
					textError.setText("You need to give an Integer.");
				}
			}
		});
		
		textFieldFahrenheit.setOnKeyPressed(event->{
			
			if (event.getCode()==KeyCode.ENTER){
				if (textFieldFahrenheit.getText()!=""){
					try{
						int toNum = Integer.parseInt(textFieldFahrenheit.getText());			
							int celcResult = (int)(toNum - 32)*5/9 ;
							textFieldCelsius.setText(String.valueOf(celcResult));
							textError.setText("");
						}
						catch (Exception e){
							textError.setText("You need to give an Integer.");
						}
				}
				else {
					textError.setText("You need to give an Integer.");
				}
			}
		});
		btn1.setOnAction(event->{
			textFieldFahrenheit.setText(String.valueOf(""));
			textFieldCelsius.setText(String.valueOf(""));
		});
		btn2.setOnAction(event->{
			try{
			int toNum = Integer.parseInt(textFieldCelsius.getText());			
				int fahrResult = (int)(toNum)*9/5 + 32;
				textFieldFahrenheit.setText(String.valueOf(fahrResult));
				textError.setText("");
			}
			catch (Exception e){
				textError.setText("You need to give an Integer.");
				
			}
		});
		btn3.setOnAction(event->{
			try{
			int toNum = Integer.parseInt(textFieldFahrenheit.getText());			
				int celcResult = (int)(toNum - 32)*5/9 ;
				textFieldCelsius.setText(String.valueOf(celcResult));
				textError.setText("");
			}
			catch (Exception e){
				textError.setText("You need to give an Integer.");
			}
		});


        Scene  scene = new Scene(rootPane);
		stage.setTitle("Μετατροπές Θερμοκρασίας");
        stage.setScene(scene); 
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}