package game;

import java.util.Scanner;

/**
 * Main class for the Othello game
 * 
 * Contains the main method and critical variables (labeled as static) that are
 * used throughout the program
 * 
 * @author Garrison Henkle
 * @since 1.8
 */
public class Othello {
	public static final String B = "Black";
	public static final String W = "White";
	protected static boolean quit = false;
	protected static String turn = B;

	/**
	 * Main method
	 * 
	 * Loops to continue the game until there is a winner or a player quits
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		// creates objects of other classes
		Board b = new Board();
		Player p = new Player();
		Othello o = new Othello();
		Rules r = new Rules();
		// while loop that runs entire game
		while (true) {
			// loop that runs one instance of the game
			while (quit == false) {
				b.draw(turn);
				p.getAction(turn);
				o.switchTurn();
				if(Rules.winFlag == 1) {
					r.winner();
					break;
				}
			}
			// Asks the user if they want to play again
			System.out.println("Do you want to play again?");
			Scanner scan = new Scanner(System.in);
			String yesno = scan.nextLine();
			// if the user replies yes the nested while loop will begin, if the user replies
			// no the game will end completely
			if (yesno == "yes") {
				scan.close();
				continue;
			} else {
				scan.close();
				break;
			}

		}
	}// end method main

	/**
	 * Changes whose turn it is to play
	 */
	public void switchTurn() {
		if (turn == B)
			turn = W;
		else
			turn = B;
	} // end method switchTurns
}
