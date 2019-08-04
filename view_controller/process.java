// Akanshu Singh
package view_controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import model.DiceTray;

public class process {
	// this class acts as the main processor of BoggleGUI and creates arraylist of
	// all elements required
	public static ArrayList<String> loc;
	public static ArrayList<String> input;
	public static ArrayList<String> notfound;
	public static ArrayList<String> found;
	public static ArrayList<String> couldhave;
	public static int score;
	public static String mainstr;

	private static DiceTray var1;

	public static void processlist(ArrayList<String> var, char[][] a) {
		// this function takes the input and creates a list of valid inputs that are in
		// dicetray
		input = new ArrayList<String>();
		var1 = new DiceTray(a);
		for (int i = 0; i < var.size(); i++) {
			if (var1.found(var.get(i))) {
				input.add(var.get(i).toLowerCase());
			}
		}
	}

	public static void dict() {
		// this function creates a arraylist of all elements in the dictionary in the
		// name of dict
		loc = new ArrayList<String>();
		// System.out.println("we here");
		try {
			@SuppressWarnings("resource")
			File text = new File("C:/BoggleWords.txt");
			Scanner sc = new Scanner(text);
			while (sc.hasNext()) {
				String var = sc.next();
				// System.out.println(var);
				loc.add(var);
			}

		} catch (Exception e) {
			System.out.println("not good");
			e.printStackTrace();
			return;
		}

		// System.out.println(loc+"dict");

	}

	public static int scoreOf(String next) {
		// this function calculates the score
		int sum = 0;
		if (next.length() == 3 || next.length() == 4)
			sum = 1;
		else if (next.length() == 5)
			sum = 2;
		else if (next.length() == 6)
			sum = 3;
		else if (next.length() == 7)
			sum = 5;
		else if (next.length() >= 8)
			sum = 11;
		else
			sum = 0;
		return sum;
	}

	public static void check() {
		// this function creates the arraylist of notfound strings that were inputted by
		// the user
		// it also calculates the score
		// System.out.println(input.size());
		int sum = 0;
		notfound = new ArrayList<String>();
		for (int i = 0; i < input.size(); i++) {

			if (loc.contains(input.get(i).toLowerCase())) {
				// System.out.println("Here"+input.get(i));

				sum += scoreOf(input.get(i));

			} else {
				notfound.add(input.get(i).toLowerCase());
			}
		}
		// System.out.println(sum);
		// System.out.println(notfound.toString()+"notfound");
		score = sum;
	}

	public static void notfound() {
		// this function returns a arraylist of strings that could have been guessed
		couldhave = new ArrayList<String>();
		// System.out.println(loc.size());
		for (int i = 0; i < loc.size(); i++) {
			if (!(input.contains(loc.get(i)))) {
				if (var1.found(loc.get(i))) {
					couldhave.add(loc.get(i));

				}
			}
		}

		mainstr = "Score: " + score + "\n\n";
		mainstr += "Words you found:\n";
		printinfo2(input);
		mainstr += "\n\n";
		mainstr += "Incorrect words:\n";
		printinfo(notfound);
		mainstr += "\n\n";

		mainstr += "You could have found these " + couldhave.size() + " more words: \n";
		printinfo(couldhave);

	}

	private static void printinfo2(ArrayList<String> input2) {
		// this function adds the arraylist input2 elements to mainstr in a orderly
		// fashion
		for (int i = 0; i < input2.size(); i++) {
			if (loc.contains(input2.get(i)))
				mainstr += input2.get(i) + " ";
		}

	}

	public static void printinfo(ArrayList<String> input2) {
		// this function adds elements of input2 to mainstr if they exist in dictionary
		int tic = 0;
		for (int i = 0; i < input2.size(); i++) {
			mainstr += input2.get(i) + " ";
			tic++;
			if (tic % 10 == 0)
				mainstr += "\n";

		}

	}
}
