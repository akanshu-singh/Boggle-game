package model;

import java.util.ArrayList;
import java.util.Scanner;

import view_controller.process;

public abstract class Boggle {
	protected char[][] a;
	
	public Boggle(char[][] var) {
		a = var;
		

	}
	public abstract void constructinput1();
	
	public abstract void constructdict(); 
	
	public abstract void constructsum(); 
		

	public abstract void constructmissed(); 	

	public abstract boolean process();}



// TODO: Complete a Boggle game that will be used with two views
// 1. A console based game with standard IO (Boggle Two)
// 2. An event-driven program with a graphical user interface (Boggle Three)
