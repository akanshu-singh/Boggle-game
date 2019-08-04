
//
package view_controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import model.DiceTray;
import model.Boggle;
public class BoggleConsole {
	public static ArrayList<String> dict= new ArrayList<String>();
	public static ArrayList<String> input= new ArrayList<String>();
	public static ArrayList<String> missed= new ArrayList<String>();
	public static ArrayList<String> incorrect= new ArrayList<String>();
	public static int score=0;
    
	
 
public static void main(String[] args) {
	// Use this for testing
    char[][] a = {   
        { 'A', 'B', 'S', 'E' },       
        { 'I', 'M', 'T', 'N' },       
        { 'N', 'D', 'E', 'D' },       
        { 'S', 'S', 'E', 'N' }, };
    
    DiceTray tray = new DiceTray(a);
    
    // TODO: Complete a console game
    System.out.println("Play one game of Boggle:");
    System.out.println("");
    for (int i=0;i<a.length;i++){
    	System.out.print(" ");
    	
    	for (int j=0;j<a[0].length;j++) {
    		System.out.print(a[i][j]+" ");
    		
    		
    	}
    	System.out.println(" ");
    	
    }
    System.out.println("Enter words or ZZ to quit:");
    ArrayList<String> var=new ArrayList<String>();
 	Scanner sc=new Scanner(System.in);
    while (sc.hasNext()) {
    	String loc=sc.next();
    	if (!(loc.equalsIgnoreCase("ZZ"))) {
    		if (!(var.contains(loc))) {
        		var.add(loc);	
        	}
    		}
    	
    	else {
    		break;
    	}
    	
    	
    }
    System.out.println();
    Collections.sort(var);;
    process.processlist(var,a);
   process.dict();
   process.check();
   process.notfound();
   
    
    
  }


}

