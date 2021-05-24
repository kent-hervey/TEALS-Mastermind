import java.io.*;

/**
* This class implements the Mastermind game. It will generate a random
* code and the user has up to 8 chances to guess the correct code.
*/
public class Mastermind {
	// DATA MEMBERS //
	private String code; // the code

	// CONSTRUCTOR //
	/**
	* randomly generate the code (a string with 4 letters
	* chosen from ’a’ to ’f’)
	*/
	public Mastermind() {
		code = new String();
		
		for (int i = 0; i < 4; i++) {
			char ch = (char)(int)(Math.random() * 6 + 'a');
			code = code + ch;
		}
	
	}

	// PUBLIC METHODS
	/**
	* return the code
	*/
	public String getCode() {
		return code;
	}
	
	/**
	* print the number of exact and near matches
	*/
	public void reportMatches(String guess) {
		System.out.println("Number of exact matches:  " + exactMatches(guess));
		System.out.println("Number of near matches:  " + nearMatches(guess));
	}
	
	/**
	* return true if the guess is correct; otherwise, return false
	*/
	public boolean isWin(String guess) {
		return this.code.equals(guess);
	}

	// PRIVATE METHODS
	/**
	* return the number of exact matches
	*/
	private int exactMatches(String guess) {
		int result =0;
		for(int i = 0; i < this.code.length(); i++) {
			if (this.code.charAt(i)==guess.charAt(i)) {
				result++;
			}
		}
		
		return result;
	}
	
	/**
	* return the number of near matches
	*/
	private int nearMatches(String guess) {
		int numNearMatches = 0;
		char space = ' ';
		
		StringBuilder builderGuess = new StringBuilder(guess);
		StringBuilder builderCode = new StringBuilder(this.code);
		
		System.out.println("in nearMatch, here is guess and code: " + builderGuess + " " + builderCode);
		
		// Find exact matches and remove from builderCode
		for (int i = 0; i < 4; i++) {
			if(builderCode.charAt(i)==builderGuess.charAt(i)) {
				builderCode.setCharAt(i, space);

				// Remove any other occurrences of guess
				for(int j = 0; j < 4; j++) {
					if (builderCode.charAt(j) == builderGuess.charAt(i)) {
						builderCode.setCharAt(j, space);
					}
				}
			}
		}

		// Find near matches
		for (int i = 0; i < 4; i++) {
			String stringOfCharAtIndex = Character.toString(builderGuess.charAt(i));
			int indexOfMatchingChar = builderCode.indexOf(stringOfCharAtIndex);

			if (indexOfMatchingChar != -1 && builderGuess.charAt(i) != space) {
				numNearMatches++;
				System.out.println("in nearMatch loop, this letter matched:  " + stringOfCharAtIndex);
				System.out.println("index for code:  " + indexOfMatchingChar);

				// Clear out near match (for additional passes with same char)
				builderCode.setCharAt(indexOfMatchingChar, space);
			}
		}
		
		return numNearMatches;
	}
	
	
	public void displayWelcome(int maxGuesses) {
		System.out.println("There is a secret code consisting of 4 letters\nYou have " + maxGuesses + " guesses to try for a match>>Please enter exactly 4 letters");
		System.out.println("After each guess you make, the display will show:  \n\t1) Number of exact matches which means right letters in the right position");
		System.out.println("\t2) Number of near matches which are right letters, but in wrong position");
		System.out.println("If you guess right, or run out of allowable guesses, you will be notified");
		
	}
	
	//////////////////////////////////////////////////////////////////////
	// MAIN METHOD: EXECUTION BEGINS HERE
	//////////////////////////////////////////////////////////////////////
	public static void main( String [] args ) throws IOException {
		int numberOfAllowedGuesses = 8;
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		Mastermind codemaker = new Mastermind();
		codemaker.displayWelcome(numberOfAllowedGuesses);
		
		for (int i = 1; i <= numberOfAllowedGuesses; i++) {
			System.out.print("---\n>>Guess: " + i + ": ");
			String guess = stdin.readLine();
			
			while(guess.length()!=4) {
				System.out.println("please enter exactly four letters");
				guess = stdin.readLine();
			}
			
			codemaker.reportMatches(guess);
			if (codemaker.isWin(guess)) {
				System.out.println("You WIN!");
				System.exit(0); // Terminate if the user wins
			}
		}
		
		System.out.println("Sorry, you did not win; plese try again");
		System.out.println("The correct code is " + codemaker.getCode());
		}
}
