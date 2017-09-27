package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayerNew {
	private int xCoord;
	private int yCoord;
	private final String NOPE = "Invalid input. ";
	private String input;
	private int inputInt;
	
	public void getAction(String userTurn){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int success = 0;
		do {
			try {
				input = br.readLine();
			} catch (IOException e) {
			System.out.println(NOPE);
			}
		
			if(isNumber(input) && isValidCoord(inputInt = Integer.parseInt(input))) {
				setXCoord(inputInt);
				success = 1;
			}
			else if(input.equals("q"))
				quit();
			else if(input.equals("p")) {}
			else {
				System.out.println(NOPE);
			}
		} while(success != 1);
	}
	
	
	private boolean isValidCoord(int x) {
		if (1 <= x && x <= 8)
			return true;
		else
			return false;
	}
	
	@SuppressWarnings("unused")
	public boolean isNumber(String stringIn) {
		try {
			int hopefullyANumber = Integer.parseInt(stringIn);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
	
	private void setXCoord(int input) {
		xCoord = input-1;
	}
	private void setYCoord(int input) {
		yCoord = input-1;
	}

	private void quit() {
		Othello.quit = true;
	}
	
	
	
}
