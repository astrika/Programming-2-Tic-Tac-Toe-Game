//************************************************************
// Astrid Manuel
// 3354122
// COP3337
// Section U04
// Assignment#3
// Semptember 29,2016
// 
// I hereby certify that this collective work is my own 
// and none of it is the work of any other person or entity
//
//
//
//************************************************************ 

/**
*              		   Tic Tac Toe 
*	The purpose of this is to describe a Tic Tac Toe game and 
*	display a Tic Tac Toe board. In this class a three by three
*	board is made with 9 cells or spaces, an introduction of 
*   game is provided that explains instructions of game, a move
*	is applied, a Tic Tac Toe board is displayed and conditions
*	for winning are set.
*	This class is tested by TicTacToeTester class.
*
*	Solves COP3337 Assignment 3
*
*	To compile 
*	javac TicTacToe.java
*
*	To Test:
*	javac TicTacToeTester.java
*	java TicTacToeTester
*
*/


public class TicTacToe {

/*
* Declares array for Tic Tac Toe board with 9 spaces or cells and sets
* initial characters. 
*/
	private char[] space = {'1', '2', '3', '4', '5', '6', '7', '8', '9'}; 

/*
* Constructor for Tic Tac Toe board
*/
	public TicTacToe(){
		
	}

/*
* gameIntro provides an introduction of game with instructions
*/
	
	public void gameIntro(){
		System.out.println("\n================= Welcome to a game of Tic Tac Toe! =================\n" +
		"This is a two player game with first player X and second player O.\n" +
		"Players alternate to make X or O markings on board. \n" +
		"The purpose of this game is to get three of your markings in a row. \n" +
		"To play game first choose who will be player X and who will be player O. \n" +
		"Rememeber player X goes first! You are then ready to begin. \n" +
		"Spaces are labeled with numbers 1-9. Input the number for the space \n" +
		"you would like to fill with your mark. \n"  + "Enjoy the game!");
	}	
	
/*
* applyMove applies a move that player has chosen to make
* decrements move so that the correct value in array is 
* accessed, move is checked so that it is done on a free space
*
* @param playersMark playersMark the mark of current player (X or O)
* @param move the move that player has chosen to make
* @return  
*/
	
	public boolean applyMove(char playersMark, int move) {
		move--;
		boolean freeSpace = false;
		if(space[move] != 'X' && space[move] != 'O'){
			space[move] = playersMark;
			freeSpace = true;
		} else {
			freeSpace = false;
		}
		return freeSpace;
	}
	
/*
* getGameBoard displays Tic Tac Toe board
* accesses array to obtain characters on board
*
* @return gameBoard the Tic Tac Toe board
*/

	public String getGameBoard(){
		String gameBoard = "\n -------------\n | " + space[0] + " | " + space[1] + " | " + space[2] + " |  \n" +
                           " -------------\n | " + space[3] + " | " + space[4] + " | " + space[5] + " |  \n" +
				           "------------- \n | " + space[6] + " | " + space[7] + " | " + space[8] + " |  \n -------------\n";
		return gameBoard;
	}

/*
* checkIfWin checks the criteria for a player to win game
*
* @return win shows if player has won or not
*/
	
	public boolean checkIfWin() {
		boolean win = false;
		if ((space[0] == space[1] && space[1] == space[2]) || // Horizonatal
		    (space[3] == space[4] && space[4] == space[5]) ||
   		    (space[6] == space[7] && space[7] == space[8]) ||
		    (space[0] == space[3] && space[3] == space[6]) || // Vertical
		    (space[1] == space[4] && space[4] == space[7]) ||
		    (space[2] == space[5] && space[5] == space[8]) ||
		    (space[0] == space[4] && space[4] == space[8]) || // Diagonal 
		    (space[6] == space[4] && space[4] == space[2])) {
			win = true;
		} else {
			win = false;
		}
		return win;
	}

}
