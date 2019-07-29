// Akanshu Singh
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceTray {

	/**
	 * Construct a tray of dice using a hard coded 2D array of chars. Use this for
	 * testing
	 * 
	 * @param newBoard The 2D array of characters used in testing
	 * 
	 */

	private char[][] board;
	private boolean[][] check;
		public DiceTray(char[][] newBoard) {
		// TODO Implement this constructor
		board = newBoard;
		check = new boolean[newBoard.length][newBoard[0].length];
		
	}

	/**
	 * Return true if search is word that can found on the board following the rules
	 * of Boggle
	 * 
	 * @param str A word that may be in the board by connecting consecutive letters
	 * @return True if search is found
	 */
	public boolean found(String attempt) {
		// TODO: Implement this method
		if (attempt.substring(0, 2).equals("Qu")) {
			attempt = "Q" + attempt.substring(2, attempt.length());
		}
		attempt=attempt.toUpperCase();
		ArrayList<Integer>[] loc = Locationlist(attempt);
		
		boolean val=checklist(loc,attempt);

		return val;
	}
	// need to set up a loop to go through all the loc elements 
	// if recur return false check for another value of loc
	private boolean checklist(ArrayList<Integer>[] loc, String attempt) {
		boolean val=false;
		//System.out.println(loc.length+"loc length reps");
		for (int i=0;i<loc.length;i++) {
			//System.out.println("processing"+loc[i].get(0)+" processing"+loc[i].get(1));
		boolean[][] var=new boolean[board.length][board[0].length];
		val=recur("",loc[i].get(0),loc[i].get(1),var,attempt,0);
		if (val==true) {
			var=new boolean[board.length][board[0].length];
			//System.out.println(val+"checklist");
			return true;
		}}
		return val;
	}
	
	private boolean recur(String speci,Integer int1, Integer int2, boolean[][] var,String attempt, int i) {
		speci+=board[int1][int2];
		System.out.println(speci);
		if (attempt.charAt(i)!=board[int1][int2])
		{	//System.out.println(speci);
			return false;}
		if (i==attempt.length()-1)
			return true;
		var[int1][int2]=true;
		 if (validloc(int1-1,int2-1,var) && recur(speci,int1-1,int2-1,var,attempt,i+1)) {
			
			return true;
		 
	}
	 if (validloc(int1-1,int2,var) && recur(speci,int1-1,int2,var,attempt,i+1)) {
		
			return true;
	}
	 if (validloc(int1-1,int2+1,var) && recur(speci,int1-1,int2+1,var,attempt,i+1)) {
			return true;
	}
	  if (validloc(int1,int2+1,var) && recur(speci,int1,int2+1,var,attempt,i+1)) {
		
		
			return true;
	}
	  if (validloc(int1+1,int2+1,var) &&	recur(speci,int1+1,int2+1,var,attempt,i+1)) {

				return true;
	}
	  if (validloc(int1+1,int2,var) && recur(speci,int1+1,int2,var,attempt,i+1)) {
		
				return true;
	}
	  if (validloc(int1+1,int2-1,var) && recur(speci,int1+1,int2-1,var,attempt,i+1)) {
		
				return true;
	}
	  if (validloc(int1,int2-1,var) && recur(speci,int1,int2-1,var,attempt,i+1)) {
		
				return true;
	}
	  //System.out.println(speci);
	  	var[int1][int2]=false;
		return false;
	}		
			

	private boolean validloc(Integer int1, Integer int2, boolean[][] var) {
		//System.out.println(int1+" "+int2+"before");
		if (int1>=0&&int1<board.length&&int2>=0&&int2<board[0].length)
			{//System.out.println(int1+" "+int2+" "+board.length+var[int1][int2]);
			if (var[int1][int2]==false) {
				return true;
			}
		
	}
		return false;
		}

	private ArrayList<Integer>[] Locationlist(String attempt) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// System.out.println(attempt.substring(0,1)+board[i][j]+attempt.substring(0,1).equals(board[i][j]));
				if (attempt.charAt(0) == (board[i][j]))
					count++;

			}
		}
		//System.out.println(Arrays.deepToString(board) + count + attempt);
		int specvar=0;
		ArrayList<Integer>[] alist = new ArrayList[count];
		for (int k = 0; k < count; k++) {
			alist[k] = new ArrayList<Integer>();
			outerloop:
				
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					// System.out.println(attempt.substring(0,1)+board[i][j]+attempt.substring(0,1).equals(board[i][j]));
					int[] var=new int[] {i,j};
					//System.out.println(Arrays.deepToString(alist));
					//System.out.println("before"+board[i][j]);
					if (attempt.charAt(0) == (board[i][j]) && doesnotcontain(var,specvar,alist)) {
						alist[k].add(i);
						alist[k].add(j);
						specvar++;
						//System.out.println(Arrays.deepToString(alist));
						break outerloop;
						
					}

				}

			}

		}
		//System.out.println(Arrays.deepToString(alist));
		return alist;

	}

	private boolean doesnotcontain(int[] var,int count,ArrayList<Integer>[] alist) {
		//System.out.println(count);
		for (int k = 0; k < count; k++) {
			if (alist[k].get(0)==var[0]&&alist[k].get(1)==var[1]) {
				return false;
			}
		
	}
		return true;

}}