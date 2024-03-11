package minegame;

import java.util.Random;
import java.util.Scanner;

public class MineField {
	
	int row, column, size, level;
	int map[][];
	int board[][];
	boolean game = true;
	Random random = new Random();
	Scanner input = new Scanner(System.in);
	
	public MineField(int row, int column, int level) {
		this.row = row;
		this.column = column;
		this.map = new int[row][column];
		this.board = new int[row][column];
		this.size = row * column;
		this.level = level;
	}
	
	public void runGame() {
		int row, column;
		int chosen = 0;
		
		addMine();
		print(map);
		System.out.println("Game Started, Good Luck!!");
		
		while(game) {
			print(board);
			
			System.out.print("Row = ");
			row = input.nextInt();
			System.out.print("Column = ");
			column = input.nextInt();
			
			while(!(((0<=row) && (row<=this.row-1)) && ((0<=column) && (column <= this.column-1)))) {
				
				System.out.println("Invalid row and column values, please try again!\n");
				System.out.print("Row = ");
				row = input.nextInt();
				System.out.print("Column = ");
				column = input.nextInt();
				
			}
			
			if((map[row][column] != -1) && (board[row][column] == 0)) {
				checkMine(row,column);
				chosen++;
				
				if(chosen == (size - level)) {
					game = false;
					print(board);
					System.out.println("\nYou WON, Congratulations!!");
				}
				
			} else if(map[row][column] == -1) {
				game = false;
				System.out.println("\nYou chose a MINE! Game Over!");
				System.out.print("\nGame Map :");
				print(map);
			} else if(board[row][column] != 0) {
				System.out.println("This field already chosen! Please enter new row and column values");
			}
			
			
		}
			
	}
	
	public void addMine() {
		int randRow, randCol, mineCount;
		
		mineCount = 0;
		
		while(mineCount < level) {
			randRow = random.nextInt(row);
			randCol = random.nextInt(column);
			
			if(map[randRow][randCol] != -1) {
				map[randRow][randCol] = -1;
				mineCount++;
			}			
		}
	}

	public void checkMine(int row, int column) {
		
		if((row > 0) && (map[row-1][column] == -1)) {
			board[row][column]++;
		}
		if((row < (this.row-1)) && (map[row+1][column] == -1)) {
			board[row][column]++;
		}
		if((column > 0) && (map[row][column-1] == -1)) {
			board[row][column]++;
		}
		if((column < (this.column-1)) && (map[row][column+1] == -1)) {
			board[row][column]++;
		}
		if(board[row][column] == 0) {
			board[row][column] = -2;
		}
		
	}
	
	public void print(int matrix[][]) {
		System.out.println();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
