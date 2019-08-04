//Akanshu Singh
package view_controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Boggle;
import model.DiceTray;

public class BoggleGUI extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private static DiceTray securedice;
	private static char[][] dice;
	private Boggle game;
	private TextArea dicetray = new TextArea();
	private static TextArea input = new TextArea();

	private Button newgame = new Button("New Game");
	private Button quitgame = new Button("End Game");
	private GridPane mainpane = new GridPane();
	private static ArrayList<ArrayList<Character>> var = new ArrayList<ArrayList<Character>>(16);
	private static int size = 16;

	public void start(Stage stage) {
		// Set up window
		input.setWrapText(true);
		addcomponents();
		addhandlers();
		create();
		dice = startgame();
		securedice = new DiceTray(dice);
		dicetray.setFont(new Font("Courier", 30));
		dicetray.setText(securedice.toString());
		Scene scene = new Scene(mainpane, 300, 700);
		stage.setScene(scene);
		stage.show();
	}

	private void addhandlers() {
		// this function adds handler for the buttons
		EventHandler<ActionEvent> texthandler = new ButtonHandler();
		quitgame.setOnAction(texthandler);
		newgame.setOnAction(new ButtonHandler1());
	}

	private class ButtonHandler1 implements EventHandler<ActionEvent> {
		// this class acts as a handler for new game button
		@Override
		public void handle(ActionEvent event) {
			input.setText("");

			// HellaDice.create();
			shuffle();
			dicetray.setText(securedice.toString());

		}

	}

	private class ButtonHandler implements EventHandler<ActionEvent> {
		// this class acts as a handler for quit game button
		@Override
		public void handle(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Results");
			alert.setHeaderText("Here is your score");
			Scanner sc = new Scanner(input.getText());
			ArrayList<String> var = new ArrayList<String>();
			while (sc.hasNext()) {
				String loc = sc.next();
				if (!(var.contains(loc))) {
					var.add(loc);
				}

				else {
					break;
				}

			}
			Collections.sort(var);
			process.processlist(var, securedice.board);
			process.dict();
			process.check();
			process.notfound();

			alert.setContentText(process.mainstr); // message is a big string with all required reults
			alert.showAndWait();

		}

	}

	private void addcomponents() {
		// this function adds some of the components to the panel
		GridPane center = new GridPane();
		mainpane.setStyle("-fx-border-color: white; -fx-border-width :10 ");
		center.setHgap(25);
		center.setVgap(2);
		center.add(newgame, 1, 15);
		center.add(quitgame, 2, 15);
		Label prompt = new Label("Enter your attempts below");
		center.add(prompt, 1, 28);
		mainpane.add(center, 0, 1);
		dicetray.setMaxSize(300, 300);
		input.setMaxSize(300, 300);
		mainpane.add(dicetray, 0, 0);
		mainpane.add(input, 0, 2);
		dicetray.setEditable(false);

	}

	public static void create() {
		// this function creates all the dices
		ArrayList<Character> v1 = new ArrayList<Character>(Arrays.asList('L', 'R', 'Y', 'T', 'T', 'E'));
		ArrayList<Character> v2 = new ArrayList<Character>(Arrays.asList('V', 'T', 'H', 'R', 'W', 'E'));
		ArrayList<Character> v3 = new ArrayList<Character>(Arrays.asList('E', 'G', 'H', 'W', 'N', 'E'));

		ArrayList<Character> v4 = new ArrayList<Character>(Arrays.asList('S', 'E', 'O', 'T', 'I', 'S'));
		ArrayList<Character> v5 = new ArrayList<Character>(Arrays.asList('A', 'N', 'A', 'E', 'E', 'G'));
		ArrayList<Character> v6 = new ArrayList<Character>(Arrays.asList('I', 'D', 'S', 'Y', 'T', 'T'));
		ArrayList<Character> v7 = new ArrayList<Character>(Arrays.asList('O', 'A', 'T', 'T', 'O', 'W'));
		ArrayList<Character> v8 = new ArrayList<Character>(Arrays.asList('M', 'T', 'O', 'I', 'C', 'U'));
		ArrayList<Character> v9 = new ArrayList<Character>(Arrays.asList('A', 'F', 'P', 'K', 'F', 'S'));
		ArrayList<Character> v10 = new ArrayList<Character>(Arrays.asList('X', 'L', 'D', 'E', 'R', 'I'));
		ArrayList<Character> v11 = new ArrayList<Character>(Arrays.asList('H', 'C', 'P', 'O', 'A', 'S'));
		ArrayList<Character> v12 = new ArrayList<Character>(Arrays.asList('E', 'N', 'S', 'I', 'E', 'U'));
		ArrayList<Character> v13 = new ArrayList<Character>(Arrays.asList('Y', 'L', 'D', 'E', 'V', 'R'));
		ArrayList<Character> v14 = new ArrayList<Character>(Arrays.asList('Z', 'N', 'R', 'N', 'H', 'L'));
		ArrayList<Character> v15 = new ArrayList<Character>(Arrays.asList('N', 'M', 'I', 'H', 'U', 'Q'));

		ArrayList<Character> v16 = new ArrayList<Character>(Arrays.asList('O', 'B', 'B', 'A', 'O', 'J'));

		var.add(0, v1);
		var.add(1, v2);
		var.add(2, v3);
		var.add(3, v4);
		var.add(4, v5);
		var.add(5, v6);
		var.add(6, v7);
		var.add(7, v8);
		var.add(8, v9);
		var.add(9, v10);
		var.add(10, v11);
		var.add(11, v12);
		var.add(12, v13);
		var.add(13, v14);
		var.add(14, v15);
		var.add(15, v16);
	}

	public static char[][] startgame() {
		// this function creates the first the first dice tray
		Random rand = new Random();
		int loc = 0;
		char[][] ch = new char[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				ch[i][j] = var.get(loc).get(rand.nextInt(6));
				loc++;
			}

		}
		return ch;
	}

	public static void shuffle() {
		// this function shuffles all the dices currently being uses and makes sure that
		// they are not same as before
		char[][] loc = new char[dice.length][dice[0].length];
		Random rand = new Random();
		int count = 0;
		char ch;
		for (int i = 0; i < dice.length; i++) {

			for (int j = 0; j < dice[0].length; j++) {
				while (true) {
					int var1 = rand.nextInt(6);
					ch = var.get(count).get(var1);
					if (ch != securedice.board[i][j])
						break;

				}

				loc[i][j] = ch;
				count++;

			}
		}
		securedice.board = loc;

	}

}
