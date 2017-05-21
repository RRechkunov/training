/**
*
*
*@author Rechkunov Roman
*@version 20.05
*/

import java.util.Scanner;
import java.util.Arrays;

class TicTacToe{
	final int SIZE	= 3; 
	final char SYMX = 'X';
	final char SYMO = 'O';
	final char SYMBLANC = '.';
	final int WINLENGTH = 3;
	char [][] map = new char[SIZE][SIZE];
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		new TicTacToe().go();

	}

	void go(){
		initMap();
		showMap();
		while (true){
			humanTurn();
			showMap();
			if (checkWinner(SYMX)) {
				System.out.println("You win");
				break;
			}
			if (isFull()) {
				System.out.println("DRAW");
				break;
			}
			aiTurn();
			showMap();
			if (checkWinner(SYMO)) {
				System.out.println("AI win");
				break;
			}
			if (isFull()) {
				System.out.println("DRAW");
				break;
			}	
		}	
	}

	void initMap(){
		System.out.printf("\n***Welcome to Tic Tac Toe game***\n*******The map size is %d *******\n",SIZE);
		for (int i=0 ; i<SIZE; i++){
			for (int y=0; y < SIZE; y++){
				map[i][y] = SYMBLANC;
			}
		}
	}

	void showMap(){
		for (int i=0 ; i<SIZE; i++){
			for (int y=0; y<SIZE; y++){
				System.out.print(map[i][y]+" ");
			}
		System.out.println();
		}	
	}

	void humanTurn(){
		System.out.println("______Your turn______");
		int x,y;
		do {			
			System.out.println("Enter coordinates X Y");	
			x = input.nextInt() - 1;
			y = input.nextInt() - 1;	
		}	
		while (!(checkValue(y,x,SYMX))); 	
			
	}

	boolean checkValue(int x, int y, char sym){
		if ((x < 0) || (y < 0) || (x >= SIZE) || (y >= SIZE)) return false; 
		if (map[x][y] != SYMBLANC) 
		return false; 
		else {
			map[x][y] = sym;		
			return true;
		}
	}
	void aiTurn(){
		System.out.println("______My turn______");
		int x,y;
		do {
			x = (int)(Math.random()*3);
			y = (int)(Math.random()*3);
		}	
		while (!(checkValue(y,x,SYMO)));	
	}

	boolean checkWinner(char sym){
		char [] diag1 = new char[SIZE];
		char [] diag2 = new char[SIZE];
		int sumdiag1=0;
		int sumdiag2=0;
		for (int i = 0;i<SIZE ;i++) {
			int sumline = 0; 
			int sumrow = 0;
			for (int j = 0;j<SIZE ;j++) {		// find hor&vert line with WINLENGTH.length
				if (map[i][j] == sym)
					sumline++;
				else sumline = 0;	
				if (map[j][i] == sym) 
					sumrow++;
				else sumrow = 0;
				if ((sumline == WINLENGTH)||(sumrow == WINLENGTH)) return true;		 	

				if (i==j) diag1[i] = map[i][j];			
				if (i==SIZE-j-1) diag2[i] = map[i][j];		
			}

		} 
		
		for (int i = 0; i< SIZE; i++){
			if (diag1[i] == sym)
				sumdiag1++;
			else sumdiag1 = 0;
			if (diag2[i] == sym)
				sumdiag2++;
			else sumdiag2 = 0;
			
			if (sumdiag1  == WINLENGTH) return true;
			if (sumdiag2 == WINLENGTH) return true;
		}	
		return false;
	}

	boolean isFull(){
		for (int i=0;i<SIZE;i++ ) {
			for (int j=0;j<SIZE ;j++ ) {
				if (map[i][j] == SYMBLANC) return false;				
			}
		}
		return true;	
	}
}