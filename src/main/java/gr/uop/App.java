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


        Scene  scene = new Scene(rootPane);
		stage.setTitle("Μετατροπές Θερμοκρασίας");
        stage.setScene(scene); 
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}