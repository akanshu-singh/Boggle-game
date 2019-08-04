package view_controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HellaDice {
	private static ArrayList<ArrayList<Character>> var=new 	ArrayList<ArrayList<Character>>(16);
	private static int size=16;
	
	
	public static void create() {
		ArrayList<Character> v1=new ArrayList<Character>(Arrays.asList('L','R' ,'Y', 'T','T','E'));
		ArrayList<Character> v2=new ArrayList<Character>(Arrays.asList('V', 'T', 'H', 'R', 'W', 'E'));
		ArrayList<Character> v3=new ArrayList<Character>(Arrays.asList('E' ,'G' ,'H' ,'W' ,'N' ,'E'));
		
		ArrayList<Character> v4=new ArrayList<Character>(Arrays.asList('S', 'E', 'O', 'T', 'I', 'S'));
		ArrayList<Character> v5=new ArrayList<Character>(Arrays.asList('A', 'N', 'A', 'E', 'E', 'G'));
		ArrayList<Character> v6=new ArrayList<Character>(Arrays.asList('I', 'D', 'S', 'Y', 'T', 'T'));
		ArrayList<Character> v7=new ArrayList<Character>(Arrays.asList('O', 'A' ,'T' ,'T' ,'O' ,'W'));
		ArrayList<Character> v8=new ArrayList<Character>(Arrays.asList('M', 'T', 'O', 'I', 'C', 'U'));
		ArrayList<Character> v9=new ArrayList<Character>(Arrays.asList('A', 'F', 'P', 'K', 'F', 'S'));
		ArrayList<Character> v10=new ArrayList<Character>(Arrays.asList('X', 'L', 'D', 'E', 'R', 'I'));
		ArrayList<Character> v11=new ArrayList<Character>(Arrays.asList('H', 'C', 'P', 'O', 'A', 'S'));
		ArrayList<Character> v12=new ArrayList<Character>(Arrays.asList('E', 'N', 'S', 'I', 'E', 'U'));
		ArrayList<Character> v13=new ArrayList<Character>(Arrays.asList('Y', 'L', 'D', 'E', 'V', 'R'));
		ArrayList<Character> v14=new ArrayList<Character>(Arrays.asList('Z','N', 'R', 'N', 'H', 'L'));
		ArrayList<Character> v15=new ArrayList<Character>(Arrays.asList('N', 'M', 'I', 'H', 'U', 'Q'));
		
		ArrayList<Character> v16=new ArrayList<Character>(Arrays.asList('O', 'B', 'B', 'A', 'O', 'J'));
		
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
		var.add(15,v16);
	}
	public static char[][] shuffle(char[][] dice) {
		Random rand=new Random();
		for (int i=0;i<dice.length;i++) {
			for (int j=0;j<dice[0].length;j++) {
				for (int k=0;k<size;k++) {
					if (var.get(k).contains(dice[i][j])) {
						char ch;
						do {
							int var1=rand.nextInt(7);
							ch=var.get(k).get(var1);
						}
						while(ch==dice[i][j]);
						dice[i][j]=ch;
					}
				}
			}

		}
		return dice;
		
	}
	public static char[][] startgame() {
		// TODO Auto-generated method stub
		System.out.print("here");
		int loc=0;
		char[][] ch= new char[4][4];
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				ch[i][j]=var.get(loc).get(0);
				loc++;
			}
			
		}
		return ch;
	}
	
	}


