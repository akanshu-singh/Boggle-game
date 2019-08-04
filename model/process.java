package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import model.DiceTray;


public class process {
	private static ArrayList<String> loc;
	private static ArrayList<String> input;
	private static ArrayList<String> notfound;
	private static ArrayList<String> found;
	private static ArrayList<String> couldhave;
	
	private static DiceTray var1;
	public static ArrayList<String> processlist(ArrayList<String> var, char[][] a){
		input=new ArrayList<String>();
		var1=new DiceTray(a);
		for (int i=0;i<var.size();i++) {
			if (var1.found(var.get(i))) {
				input.add(var.get(i).toLowerCase());
			}
		}
		return input;
	}
	public static ArrayList<String> dict(ArrayList<String> var1) {
		loc=new ArrayList<String>();
		System.out.println("we here");
		try
		  {
		    @SuppressWarnings("resource")
		    File text = new File("C:/BoggleWords.txt");
			Scanner sc=new Scanner(text);
		    while (sc.hasNext()) {
		    	String var = sc.next();
		    	System.out.println(var);
		    	loc.add(var);
		    }
		    	
			
		  }
		  catch (Exception e)
		  {System.out.println("not good");
		    e.printStackTrace();
		    return null;
		  }
		
		//System.out.println(loc+"dict");
		return loc;
		
		
		
	}
	public static int scoreOf(String next) {
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
	public static int check() {
		System.out.println(input.size());
		int sum=0;
		notfound=new ArrayList<String>();
		for (int i=0;i<input.size();i++) {
			
			if (loc.contains(input.get(i).toLowerCase())) {
				System.out.println("Here"+input.get(i));
				
				sum+=scoreOf(input.get(i));
				
			}
			else {
				notfound.add(input.get(i).toLowerCase());
			}
		}
		System.out.println(sum);
		System.out.println(notfound.toString()+"notfound");
		return sum;
	}
	public static void notfound() {
		couldhave=new ArrayList<String>();
		System.out.println(loc.size());
		for (int i=0;i<loc.size();i++) {
			if (!(input.contains(loc.get(i)))){
				if (var1.found(loc.get(i))) {
					couldhave.add(loc.get(i));
					
				}
			}
		}
		System.out.println(couldhave.toString());
		
	}
	
	}

