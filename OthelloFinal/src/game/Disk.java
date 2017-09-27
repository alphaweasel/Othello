package game;

/**
 * Contains the object Disk and its constructors and methods
 * 
 * Disk consists of 2 main fields: color and placed. Every other field is
 * derived from color or placed.
 * 
 * @author Garrison Henkle
 * @since 1.8
 */
public class Disk {

	private String color;
	private char placed;

	/**
	 * Constructor with no parameters
	 * 
	 * Creates a disk with no color that is not placed
	 */
	public Disk() {
		color = null;
		placed = 'N';
	} // end constructor Disk()

	/**
	 * Constructor with a string parameter
	 * 
	 * Creates a disk with the color, colorIn, that is placed
	 * 
	 * @param colorIn
	 *            color that is assigned to the disk when it is created
	 */
	public Disk(String colorIn) {
		color = colorIn;
		placed = 'Y';
	} // end contructor Disk(string)

	/**
	 * Used to make a blank, unplaced disk into a a placed disk of a certain color
	 * 
	 * @param colorIn
	 *            the color that the disk is set to
	 */
	public void placeDisk(String colorIn) {
		if (colorIn == Othello.B || colorIn == Othello.W) {
			color = colorIn;
			placed = 'Y';
		}
	}// end method placeDisk

	/**
	 * Used to switch the color of a disk from black to white or vice versa
	 */
	public void switchColor() {
		if (placed == 'Y') {
			if (color == Othello.W)
				color = Othello.B;
			else
				color = Othello.W;
		}
	}// end method switchColor

	/**
	 * Used to get the color of a disk
	 * 
	 * @return returns the color of the disk as a string
	 */
	public String getColor() {
		if (placed == 'Y')
			return color;
		else
			return null;
	}/// end method getColor

	/**
	 * Gives the character representation of a disk's color
	 * 
	 * 'W' represents "White", 'B' represents "Black", and ' ' represents null
	 * 
	 * Useful for representing the color of the disks in the board class
	 * 
	 * @see Board#clear()
	 * 
	 * @return returns the character representing the color of a disk
	 */
	public char getColorChar() {
		if (color == Othello.B)
			return 'B';
		else if (color == Othello.W)
			return 'W';
		else
			return ' ';
	}// end method getColorChar

	/**
	 * Checks to see if a disk is placed
	 * 
	 * @return returns the character 'Y' if the disk is placed and 'N' if the disk
	 *         is not placed
	 */
	public char isPlaced() {
		return placed;
	}// end method isPlaced
}// end class Disk