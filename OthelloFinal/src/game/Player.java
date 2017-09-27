package game;

import java.util.Scanner;

/**
 * Contains all of the user interface for the game, such as input and player
 * actions
 * 
 * Input is split into getAction(), which allows for the user to enter
 * coordinates while allowing for the user to pass or quit, and move(), which
 * tests to see if a move is valid then places a disk and flips all legal pieces
 * 
 * @author Garrison Henkle
 * @since 1.8
 *
 */
public class Player {
	@SuppressWarnings("unused")
	private int xCoord; // holds x coordinate for current move
	@SuppressWarnings("unused")
	private int yCoord; // holds y coordinate for current move
	@SuppressWarnings("unused")
	private final String NOPE = "Invalid input. "; // holds invalid input string
	@SuppressWarnings("unused")
	private String input; // temporarily holds input
	@SuppressWarnings("unused")
	private int inputInt; // temporarily holds integers from input

	/*
	 * public void getAction(String userTurn) throws IOException{ int success = 0;
	 * int needY = 0; Scanner in = new Scanner(System.in); System.out.
	 * println("To place a disk, enter the x coordinate of the location.\nTo pass your turn, enter \"p\".\nTo quit the game, enter \"q\"."
	 * ); do { input = in.next();
	 * 
	 * if (isNumber(input) && isValidCoord(inputInt = Integer.parseInt(input))) {
	 * setXCoord(inputInt); success = 1; needY = 1; } else if (input.equals("q"))
	 * quit(); else if (input.equals("p")) { } else { System.out.println(NOPE); } }
	 * while (success != 1);
	 * 
	 * if(needY == 1) { success = 0;
	 * System.out.println("Please enter the y coordinate of the location."); do {
	 * int input2 = in.nextInt(); if (isNumber(input) && isValidCoord(inputInt =
	 * Integer.parseInt(input))) { setYCoord(inputInt); success = 1; } else {
	 * System.out.println(NOPE); } } while(success != 1); } in.close();
	 * 
	 * }
	 */

	/**
	 * Allows for the user to give input into the game
	 * 
	 * Options for the user include entering an X coordinate for disk placement (1,8
	 * inclusive), quitting the game (9), or passsing the turn (10)
	 * 
	 * @param userTurn
	 *            Indicates whose turn it is so that the called move method knows
	 *            who is placing a piece
	 */
	public void getAction(String userTurn) {
		Scanner in = new Scanner(System.in);
		System.out.println(
				"To place a disk, enter the x coordinate of the location (from 1 to 8 inclusive).\nTo pass your turn, enter 10.\nTo quit the game, enter 9.");

		// input for the x coordinate
		int input = in.nextInt();

		// local variables
		int input2;
		int needY = 0;

		// checks if the input is an x coordinate, a quit command, or a pass command
		if (isValidCoord(input)) {
			setXCoord(input);
			needY = 1;
		} else if (input == 9) {
			quit();
		} else if (input == 10) {
		}

		// if an x coordinate was entered into the input, take another integer as input,
		// set it as the y coordinate, and place the disk
		if (needY == 1) {
			System.out.println("Enter the y coordinate of the location (from 1 to 8 inclusive)");
			input2 = in.nextInt();
			setYCoord(input2);
			move(xCoord, yCoord, userTurn);
		}
		in.close();
	}// end method getAction

	/**
	 * Checks the entered coordinates for possible flips, to see if there is an
	 * existing piece, and to see if the move is legal. If all of these checked, the
	 * disk is placed and all possible flips are made.
	 * 
	 * @param x
	 *            the row of the disk (between 0 and 7 inclusive)
	 * @param y
	 *            the column of the disk (between 0 and 7 inclusive)
	 * @param turn
	 *            Indicates the color of the turn
	 */
	public void move(int x, int y, String turn) {
		Rules r = new Rules();
		r.check(x, y, turn);
		if (Board.gb[x][y].isPlaced() == 'N')
			if (r.isMove()) {
				Board.gb[x][y].placeDisk(turn);
				r.flipAll(x, y, turn);
			}
	}// end method move

	/**
	 * Checks to see if the value is within the bounds for valid coordinates within
	 * the board
	 * 
	 * @param x
	 *            input that is checked to see if it is valid
	 * @return returns true if the number is a valid coordinate and false if the
	 *         number is an invalid coordinate
	 */
	private boolean isValidCoord(int x) {
		if (1 <= x && x <= 8)
			return true;
		else
			return false;
	}// end method isValidCoord

	/**
	 * Takes a input string and tests the string to see if it is an integer, then
	 * returns true or false
	 * 
	 * @param stringIn
	 *            input string that the method will attempt to parse into an integer
	 * @return returns false if the number is not an integer and true if the number
	 *         is an integer
	 */
	@SuppressWarnings("unused")
	public boolean isNumber(String stringIn) {
		try {
			int hopefullyANumber = Integer.parseInt(stringIn);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}// end method isNumber

	/**
	 * Sets the variable xCoord to the input integer minus 1
	 * 
	 * 1 is subtracted from the input integer so that the user-friendly input
	 * coordinates can be used in an array
	 * 
	 * @param input
	 *            The x coordinate is set equal to this value
	 */
	private void setXCoord(int input) {
		xCoord = input - 1;
	}// end method setXCoord

	/**
	 * Sets the variable yCoord to the input integer minus 1
	 * 
	 * 1 is subtracted from the input integer so that the user-friendly input
	 * coordinates can be used in an array
	 * 
	 * @param input
	 *            The y coordinate is set equal to this value
	 */
	private void setYCoord(int input) {
		yCoord = input - 1;
	} // end method setYCoord

	/**
	 * Trips the quit flag in the main Othello method, so that the player can leave
	 * the game
	 */
	private void quit() {
		Othello.quit = true;
	}// end method quit

} // end class Player
