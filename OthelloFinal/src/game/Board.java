package game;

/**
 * Creates the game board, stores the locations of the disks, and draws the game
 * board to the screen
 * 
 * @author Garrison Henkle
 * @since 1.8
 *
 */
public class Board {

	private int moveNum = 1;
	protected static final int ROW = 8;
	protected static final int COLUMN = 8;
	private final String BORDER = "  ||===============================||";
	private String turn;

	// data structure for the disks
	protected static Disk[][] gb = new Disk[ROW][COLUMN]; // game board(gb) array

	/**
	 * Constructor with no parameters
	 * 
	 * Creates the board and populates it with all blank disks, then places the 4
	 * initial disks on the board
	 */
	public Board() {
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				gb[r][c] = new Disk();
			} // end of column for loop
		} // end of row for loop

		gb[3][4].placeDisk(Othello.B);
		gb[4][3].placeDisk(Othello.B);
		gb[3][3].placeDisk(Othello.W);
		gb[4][4].placeDisk(Othello.W);

	} // end of constructor Board()

	/**
	 * Draws the board to the screen
	 * 
	 * Uses the character representation of the disk color
	 * 
	 * @see Disk#getColorChar()
	 * 
	 * @param userTurn
	 *            Used to indicate which player's turn it is at the bottom of the
	 *            board
	 */
	public void draw(String userTurn) {

		// Draw Board
		System.out.println("     1   2   3   4   5   6   7   8   ");
		System.out.println(BORDER);
		for (int r = 0; r < ROW - 1; r++) {
			System.out.printf((r + 1) + " || %c | %c | %c | %c | %c | %c | %c | %c ||%n", gb[r][0].getColorChar(),
					gb[r][1].getColorChar(), gb[r][2].getColorChar(), gb[r][3].getColorChar(), gb[r][4].getColorChar(),
					gb[r][5].getColorChar(), gb[r][6].getColorChar(), gb[r][7].getColorChar());
			System.out.println("  ||-------------------------------||");
		} // end of row for loop
		System.out.printf("8 || %c | %c | %c | %c | %c | %c | %c | %c ||%n", gb[7][0].getColorChar(),
				gb[7][1].getColorChar(), gb[7][2].getColorChar(), gb[7][3].getColorChar(), gb[7][4].getColorChar(),
				gb[7][5].getColorChar(), gb[7][6].getColorChar(), gb[7][7].getColorChar());
		System.out.println(BORDER);

		// Test for color
		if (userTurn == Othello.B)
			turn = Othello.B;
		else
			turn = Othello.W;
		// Draw the move counter and turn indicator
		System.out.println("     " + turn + "\'s Turn  | Move: " + moveNum++);
	} // end of method drawBoard

	/**
	 * Clears part of the console by printing 5 carriage returns
	 */
	public void clear() {
		System.out.print("\n\n\n\n\n");
	} // end of method clear

} // end of class Board