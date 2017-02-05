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
*                 Tic Tac Toe Tester
*	The purpose of this class is to test Tic Tac Toe class.
*	This class prompts user for an input and contains game
*	loop that executes game. The user's input is validated
*	so that it is an integer and is within the range of
*	maximum spaces on board.
*
*	Solves COP3337 Assignment 3
*
*	To compile and run:
*	javac TicTacToe.java
*	javac TicTacToeTester.java
*	java TicTacToeTester
*
*/

import java.util.Scanner; //used for obtaining input from user

public class TicTacToeTester {

	public static void main(String[] args){		
		TicTacToe board = new TicTacToe();	
		board.gameIntro();
		gameLoop(board);
	}
	
/*
* gameLoop executes game
* in this loop the board is displayed, a turn is checked so that a 
* move is not made on an occupied space, a turn is checked for
* winning criteria and a turn is checked for tie
* loop runs if player has not won in turn and if max amount of 
* turns is not satisfied
*
* @param board Tic Tac Toe board for game
*/

	public static void gameLoop(TicTacToe board){
		char playersMark = 'X';
		boolean successfulTurn = false;
		boolean win = false;
		int turn = 1;
		final int MAX_TURNS = 9;		
		do {
			System.out.println(board.getGameBoard());
			successfulTurn = checkTurn(board, playersMark);		
			win = board.checkIfWin();			
			if(win) {
				System.out.println(board.getGameBoard() + "\n*************************** Player " + playersMark + " wins! ***************************\n");
			}			
			if(turn == MAX_TURNS && !win){
				System.out.println(board.getGameBoard());
				System.out.println("\n******************************** Tie!!!! ******************************\n");
			}			
			if(playersMark == 'X'){
				playersMark = 'O';
			} else if(playersMark =='O'){
				playersMark = 'X';
			}				 
			turn ++;			
		} while(!win && turn < (MAX_TURNS+1) );
	}

/*
* promptMove prompts player to make a move
* this method displays whose turn it is (player X or player O) 
* and asks player to input a move. validInput input method is
* called to validate the move made
*
* @param board Tic Tac Toe board for game
* @param playersMark the mark of current player (X or O)
* @return move the move that player has chosen to make
*/

	public static int promptMove(TicTacToe board, char playersMark){
		System.out.println("========================== Player " + playersMark + "'s turn ==========================");
		System.out.println("Please indicate on which space 1-9 you would like to make your mark.");
		int move = validateInput();
		return move;
	}
	
/*
* validateInput validates input of player 
* the input of player is validated so that it is an
* integer and so that it is within the range of 
* minimum and maximum spaces on board.
*
* @return move the move that player has input
*/
	
	public static int validateInput(){
		int input = 0;
		final int MIN_SPACE = 1;
		final int MAX_SPACE = 9;
		boolean validInput = false;
		Scanner scanner = new Scanner(System.in);	
		do {
		
			if(scanner.hasNextInt()){
				input = scanner.nextInt();				
				if (input >= MIN_SPACE && input <= MAX_SPACE){
					validInput = true;
				}else{
					System.out.println("Invalid input. Please input number 1-9.");
				}				
			}else {
				scanner.next();
				System.out.println("Invalid input. Please input a number.");
			}
		} while(!validInput);
		int move = input;
		return move;
	}
	
/*
* checkTurn executes turn and checks if the turn made 
* is on a free space if the player has chosen to make a 
* move on a free space then the turn is succesful
*
* @param Tic Tac Toe board for game
* @param playersMark the mark of current player (X or O)
* @return successfulTurn checks if turn is successful or not
*/
	
	public static boolean checkTurn(TicTacToe board, char playersMark){	
		boolean freeSpace = false;
		boolean successfulTurn = false;	
		do{
			int move = promptMove(board, playersMark);
			freeSpace = board.applyMove(playersMark, move);		
			if(!freeSpace){
				System.out.println(board.getGameBoard());
				System.out.println("That is not a free space. Please choose free space to make your mark below.");
			} else {
				successfulTurn = true;
			}		
		}while(!freeSpace);	
		return successfulTurn;
	}


}
