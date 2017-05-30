/**
*
*
*@author Rechkunov Roman
*@version 30.05
*/

import java.util.Scanner;
import java.util.Arrays;

class TttOop{
	public static void main(String[] args) {
		Map map = new Map(3);
		Player[] players = {new Humman('X'),new Ai('0')};
		System.out.println("****Tic-Tac-Toe game****");
		map.showMap();
		
		while (!(map.isGameOver())) {		
			for (Player pl:players){
				pl.turn(map);
				map.showMap();
				if (map.checkWinner(pl.getSym())){
					System.out.printf("%s - player WON\n",pl.getSym());
					map.setGameOver(true);
					break;					
				}
				if (map.isFull()) {
					System.out.println("DRAW");
					map.setGameOver(true);
					break;
				}				
			}	
		}		
	}
}	 

class Map {
	final char SYMDOT = '.';
	private int size;
	private boolean gameover = false; 
	char [][] map;
	
	Map(int size){
		this.size = size;
		map = new char[size][size];
		for (int i=0 ; i<size; i++)
			for (int j=0; j < size; j++)
				map[i][j] = SYMDOT;
	}
	
	void showMap(){
		for (int i=0 ; i<size; i++){
			for (int y=0; y<size; y++)
				System.out.print(map[i][y]+" ");
			System.out.println();
		}	
		System.out.println();
	}	

	void setSymOnMap(int x,int y,char sym){						
			map[y][x] = sym;
	}
	char getSymFromMap(int x,int y){							
		return this.map[x][y];
	}	

	boolean checkValue(int x, int y){
		if ((x < 0) || (y < 0) || (x >= size) || (y >= size)) return false; 
		if (getSymFromMap(x,y) != SYMDOT) 
		return false; 
		else return true;
	}	

	boolean isFull(){
		for (int i=0;i<size;i++ ) {
			for (int j=0;j<size ;j++ ) {
				if (getSymFromMap(i,j) == SYMDOT) return false;				
			}
		}
			return true;	
	}

//**        *algorithm for bigger map size*
/*	boolean checkWinner(char sym){					
		char [] diag1 = new char[size];
		char [] diag2 = new char[size];
		int sumdiag1=0;
		int sumdiag2=0;
		for (int i = 0;i<size ;i++) {
			int sumline = 0; 
			int sumrow = 0;
			for (int j = 0;j<size ;j++) {		// find hor&vert line with WINLENGTH.length
				if (map[i][j] == sym)
					sumline++;
				else sumline = 0;	
				if (map[j][i] == sym) 
					sumrow++;
				else sumrow = 0;
				if ((sumline == getWinLength())||(sumrow == getWinLength())) return true;		 		
					if (i==j) diag1[i] = map[i][j];			
				if (i==getSize()-j-1) diag2[i] = map[i][j];		
			}
		} 
		
		for (int i = 0; i< getSize(); i++){
			if (diag1[i] == sym)
				sumdiag1++;
			else sumdiag1 = 0;
				if (diag2[i] == sym)
				sumdiag2++;
			else sumdiag2 = 0;
			
			if (sumdiag1  == getWinLength()) return true;
			if (sumdiag2 == getWinLength()) return true;
		}	
		return false;
	}	*/

	boolean checkWinner(char sym) {
        // check horizontals and verticals
        for (int i = 0; i < size; i++)
            if ((map[i][0] == sym && map[i][1] == sym && map[i][2] == sym) ||
                (map[0][i] == sym && map[1][i] == sym && map[2][i] == sym))
                return true;
        // check diagonals
        if ((map[0][0] == sym && map[1][1] == sym && map[2][2] == sym) ||
            (map[2][0] == sym && map[1][1] == sym && map[0][2] == sym))
            return true;
        return false;
    }



	int getSize (){
		return size;
	}
	
	boolean isGameOver(){
		return gameover;
	}
	void setGameOver(boolean go){
		gameover = go;
	}

}


class Humman extends Player{
	Scanner input = new Scanner(System.in);
	Humman(char s){
		super(s);
	}
	@Override
	void turn(Map m){
		System.out.printf("______Human - %s turn______\n",sym);              // add # of player
		int x,y;
		do {			
			System.out.println("Enter coordinates X Y");	
			x = input.nextInt() - 1;
			y = input.nextInt() - 1;					
		}	
		while (!(m.checkValue(y,x)));
		m.setSymOnMap(x,y,sym);	
	
	}
}	

class Ai extends Player{
	Ai(char s){
		super(s);
	}
	@Override
	void turn(Map m){
		System.out.printf("______AI - %s turn______\n",sym);
			int x,y;
			do {
				x = (int)(Math.random()*m.getSize());
				y = (int)(Math.random()*m.getSize());
			}	
			while (!(m.checkValue(y,x)));	
			m.setSymOnMap(x,y,sym);
	}	
}

abstract class Player {
	char sym;
	Player (char sym){
		this.sym = sym;
	}
	char getSym (){
		return sym;
	}
	abstract void turn(Map m);
}