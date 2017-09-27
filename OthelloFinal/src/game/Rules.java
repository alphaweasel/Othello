package game;

/**
 * Contains all of the rules and checks for the game.
 * 
 * There is a check method for all 8 directions and an accompanying flip method
 * for each
 * 
 * The flipAll() and check() methods utilize all 8 of their directional
 * counterparts to check every direction at once
 * 
 * @author Garrison
 * @since 1.8
 * 
 */
public class Rules {

	protected static int winFlag = 0; // if a user has won, then the flag will be set to 1
	private int xN = -1; // x coordinate negative location
	private int xP = -1; // x coordinate positive location
	private int yN = -1; // y coordinate negative location
	private int yP = -1; // y coordinate positive location
	private int xPyP = -1; // how many times the for loop must loop to get to the positive x positive y
							// location
	private int xNyP = -1; // how many times the for loop must loop to get to the negative x positive y
							// location
	private int xPyN = -1; // how many times the for loop must loop to get to the positive x negative y
							// location
	private int xNyN = -1; // how many times the for loop must loop to get to the negative x negative y
							// location

	/**
	 * The master check method that checks for possible moves in all 8 directions
	 * for a disk placed on the board
	 * 
	 * @param r
	 *            the row of the disk
	 * @param c
	 *            the column of the disk
	 * @param clr
	 *            the color of the disk
	 */
	public void check(int r, int c, String clr) {
		checkXP(r, c, clr);
		checkXN(r, c, clr);
		checkYP(r, c, clr);
		checkYN(r, c, clr);
		checkXPYP(r, c, clr);
		checkXPYN(r, c, clr);
		checkXNYP(r, c, clr);
		checkXNYN(r, c, clr);
	} // end method check

	/**
	 * Method used after the check() function that determines whether there is any
	 * possible moves for a given disk
	 * 
	 * check functions must be used to populate the data field that isMove() relies
	 * on
	 * 
	 * @see Rules#check(int, int, String)
	 * 
	 * @return returns true if there are possible moves and false if there are no
	 *         possible moves
	 */
	public boolean isMove() {
		if (xN + xP + yN + yP + xPyP + xNyP + xPyN + xNyN == -8)
			return false;
		else
			return true;
	} // end method isMove
	/**
	 * Checks to see if there are any possible moves
	 * @return
	 */
	public boolean isAnyMoves() {
		boolean flag = false;
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				check(i,j,Othello.B);
				if(isMove()) {
					flag = true;
					break;
				}
				check(i,j,Othello.W);
				if(isMove()) {
					flag = true;
					break;
				}
			}
		}
		if(flag == false)
			winFlag = 1;
			
		
		return flag;
	}
	
	/**
	 * Method used after the check() function that Flips all possible moves for the
	 * clr colored disk at (r,c)
	 * 
	 * check functions must be used to populate the data field that flipAll() relies
	 * on
	 * 
	 * @see Rules#check(int, int, String)
	 * 
	 * @param r
	 *            the row of the disk
	 * @param c
	 *            the column of the disk
	 * @param clr
	 *            the color of the disk
	 */
	public void flipAll(int r, int c, String clr) {
		if (xP != -1)
			flipXP(r, c, clr);
		if (xN != -1)
			flipXN(r, c, clr);
		if (yP != -1)
			flipYP(r, c, clr);
		if (yN != -1)
			flipYN(r, c, clr);
		if (xPyP != -1)
			flipXPYP(r, c, clr);
		if (xPyN != -1)
			flipXPYN(r, c, clr);
		if (xNyP != -1)
			flipXNYP(r, c, clr);
		if (xNyN != -1)
			flipXNYN(r, c, clr);
	}// end method flipAll

	/**
	 * Checks for any possible flips in the positive x direction
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void checkXP(int row, int col, String colorIn) {
		for (int i = (col + 1); i < 8; i++) {
			if (Board.gb[row][i].getColor() == null) {
				break;
			} else if (Board.gb[row][i].getColor() == colorIn) {
				if (i != col + 1)
					xP = i;
				else {
					xP = -1;
					break;
				}
			}
		}
	}// end method checkXP

	/**
	 * Makes any possible flips in the positive x direction
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void flipXP(int row, int col, String colorIn) {
		String color;
		if (colorIn == Othello.B)
			color = Othello.W;
		else
			color = Othello.B;

		for (int i = (col + 1); i < xP; i++) {
			if (Board.gb[row][i].getColor() == color)
				Board.gb[row][i].switchColor();
		}
		xP = -1;
	}// end method flipXP

	/**
	 * Checks for any possible flips in the negative x direction
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void checkXN(int row, int col, String colorIn) {
		for (int i = (col - 1); i >= 0; i--) {
			if (Board.gb[row][i].getColor() == null) {
				break;
			} else if (Board.gb[row][i].getColor() == colorIn) {
				if (i != col - 1)
					xN = i;
				else {
					xN = -1;
					break;
				}

			}
		}
	}// end method checkXN

	/**
	 * Makes any possible flips in the negative x direction
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void flipXN(int row, int col, String colorIn) {
		String color;
		if (colorIn == Othello.B)
			color = Othello.W;
		else
			color = Othello.B;

		for (int i = (col - 1); i > xN; i--) {
			if (Board.gb[row][i].getColor() == color)
				Board.gb[row][i].switchColor();
		}
		xN = -1;
	} // end method flipXN

	/**
	 * Checks for any possible flips in the positive y direction
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void checkYP(int row, int col, String colorIn) {
		for (int i = (row - 1); i >= 0; i--) {
			if (Board.gb[i][col].getColor() == null) {
				break;
			} else if (Board.gb[i][col].getColor() == colorIn) {
				if (i != row - 1)
					yP = i;
				else {
					yP = -1;
					break;
				}
			}
		}
	}// end method checkYP

	/**
	 * Makes any possible flips in the positive y direction
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void flipYP(int row, int col, String colorIn) {
		String color;
		if (colorIn == Othello.B)
			color = Othello.W;
		else
			color = Othello.B;

		for (int i = (row - 1); i > yP; i--) {
			if (Board.gb[i][col].getColor() == color)
				Board.gb[i][col].switchColor();
		}
		yN = -1;
	}// end method flipYP

	/**
	 * Checks for any possible flips in the negative y direction
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void checkYN(int row, int col, String colorIn) {
		for (int i = (row + 1); i < 8; i++) {
			if (Board.gb[i][col].getColor() == null) {
				break;
			} else if (Board.gb[i][col].getColor() == colorIn) {
				if (i != row + 1)
					yN = i;
				else {
					yN = -1;
					break;
				}
			}
		}
	}// end method checkYN

	/**
	 * Makes any possible flips in the negative y direction
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void flipYN(int row, int col, String colorIn) {
		String color;
		if (colorIn == Othello.B)
			color = Othello.W;
		else
			color = Othello.B;

		for (int i = (row + 1); i < yN; i++) {
			if (Board.gb[i][col].getColor() == color)
				Board.gb[i][col].switchColor();
		}
		yN = -1;
	}// end method flupYN

	/**
	 * Checks for any possible flips in the first quadrant
	 * 
	 * Checks for out of bounds errors so that row can be greater than, equal to, or
	 * less than column
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void checkXPYP(int row, int col, String colorIn) {

		for (int i = 1; i <= 8; i++) {
			if (Board.gb[row - i][col + i].getColor() == null)
				break;
			else if (Board.gb[row - i][col + i].getColor() == colorIn) {
				if (i != 1)
					xPyP = i;
				else {
					xPyP = -1;
					break;
				}
			}
			if (row - (i + 1) == -1 || col + (1 + i) == 8)
				break;
		}
	}// end method checkXPYP

	/**
	 * Makes any possible flips in the first quadrant
	 * 
	 * Checks for out of bounds errors so that row can be greater than, equal to, or
	 * less than column
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void flipXPYP(int row, int col, String colorIn) {
		String color;
		if (colorIn == Othello.B)
			color = Othello.W;
		else
			color = Othello.B;

		for (int i = 1; i < xPyP; i++) {
			if (Board.gb[row - i][col + i].getColor() == color)
				Board.gb[row - i][col + i].switchColor();
			if (row - (i + 1) == -1 || col + (i + 1) == 8)
				break;
		}
		xPyP = -1;
	}// end method flipXPYP

	/**
	 * Checks for any possible flips in the second quadrant
	 * 
	 * Checks for out of bounds errors so that row can be greater than, equal to, or
	 * less than column
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void checkXNYP(int row, int col, String colorIn) {
		for (int i = 1; i <= 8; i++) {
			if (Board.gb[row - i][col - i].getColor() == null)
				break;
			else if (Board.gb[row - i][col - i].getColor() == colorIn) {
				if (i != 1)
					xNyP = i;
				else {
					xNyP = -1;
					break;
				}
			}
			if (row - (i + 1) == -1 || col - (i + 1) == -1)
				break;
		}
	}// end method checkXNYP

	/**
	 * Makes any possible flips in the second quadrant
	 * 
	 * Checks for out of bounds errors so that row can be greater than, equal to, or
	 * less than column
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void flipXNYP(int row, int col, String colorIn) {
		String color;
		if (colorIn == Othello.B)
			color = Othello.W;
		else
			color = Othello.B;

		for (int i = 1; i < xNyP; i++) {
			if (Board.gb[row - i][col - i].getColor() == color)
				Board.gb[row - i][col - i].switchColor();
			if (row - (i + 1) == -1 || col - (i + 1) == -1)
				break;
		}
		xNyP = -1;
	} // end method flipXNYP

	/**
	 * Checks for any possible flips in the third quadrant
	 * 
	 * Checks for out of bounds errors so that row can be greater than, equal to, or
	 * less than column
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void checkXNYN(int row, int col, String colorIn) {
		for (int i = 1; i <= 8; i++) {
			if (Board.gb[row + i][col - i].getColor() == null)
				break;
			else if (Board.gb[row + i][col - i].getColor() == colorIn) {
				if (i != 1)
					xNyN = i;
				else {
					xNyN = -1;
					break;
				}
			}
			if (row + (i + 1) == 8 || col - (i + 1) == -1)
				break;
		}
	} // end method checkXNYN

	/**
	 * Makes any possible flips in the third quadrant
	 * 
	 * Checks for out of bounds errors so that row can be greater than, equal to, or
	 * less than column
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void flipXNYN(int row, int col, String colorIn) {
		String color;
		if (colorIn == Othello.B)
			color = Othello.W;
		else
			color = Othello.B;

		for (int i = 1; i < xNyN; i++) {
			if (Board.gb[row + i][col - i].getColor() == color)
				Board.gb[row + i][col - i].switchColor();
			if (row + (i + 1) == 8 || col - (i + 1) == -1)
				break;
		}
		xNyN = -1;
	}// end method flipXNYN

	/**
	 * Checks for any possible flips in the fourth quadrant
	 * 
	 * Checks for out of bounds errors so that row can be greater than, equal to, or
	 * less than column
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void checkXPYN(int row, int col, String colorIn) {
		for (int i = 1; i <= 8; i++) {
			if (Board.gb[row + i][col + i].getColor() == null)
				break;
			if (Board.gb[row + i][col + i].getColor() == colorIn) {
				if (i != 1)
					xPyN = i;
				else {
					xPyN = -1;
					break;
				}
			}
			if (row + (i + 1) == 8 || col + (i + 1) == 8)
				break;
		}
	}// end method checkXPYN

	/**
	 * Makes any possible flips in the fourth quadrant
	 * 
	 * Checks for out of bounds errors so that row can be greater than, equal to, or
	 * less than column
	 * 
	 * @param row
	 *            the row of the disk to check
	 * @param col
	 *            the column of the disk to check
	 * @param colorIn
	 *            the color of the disk to check
	 */
	public void flipXPYN(int row, int col, String colorIn) {
		String color;
		if (colorIn == Othello.B)
			color = Othello.W;
		else
			color = Othello.B;

		for (int i = 1; i < xPyN; i++) {
			if (Board.gb[row + i][col + i].getColor() == color)
				Board.gb[row + i][col + i].switchColor();
			if (row + (i + 1) == 8 || col + (i + 1) == 8)
				break;
		}
		xPyN = -1;
	}// end method flipXPYN
}// end class Rules
