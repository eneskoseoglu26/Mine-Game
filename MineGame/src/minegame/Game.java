package minegame;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		int row,column,level=1;
		int choose = 0;
		MineField mineGame;
		Scanner input = new Scanner(System.in);
		
		System.out.println("--------- Welcome to Mine Game ------------\nGame Introduction\n0 : not chosen field\n-1 : mine field\n-2 : field with no mine neighbour\n1 : field with 1 mine neighbour\n2 : field with 2 mine neighbours\n3 : field with 3 mine neighbours\n4 : field with 4 mine neighbours");
		System.out.println("Please enter size of the game board");
		System.out.print("Row Number = ");
		row = input.nextInt();		
		System.out.print("Column Number = ");
		column = input.nextInt();	
		
		while(!((1 <= choose) && (choose <= 3))) {
		
			System.out.println("Please choose a game level\n1-Easy\n2-Medium\n3-Hard");
			System.out.print("Game Level = ");
			choose = input.nextInt();	
			
			switch(choose) {
			case 1:
				level = (row*column)/6;
				break;
			case 2:
				level = (row*column)/4;
				break;
			case 3:
				level = (row*column)/2;
				break;
			default:
				System.out.println("Please enter a valid level! Try again.");
			}
			
		}
		
		mineGame = new MineField(row,column,level);
		mineGame.runGame();
	
		input.close();
		
	}

}
