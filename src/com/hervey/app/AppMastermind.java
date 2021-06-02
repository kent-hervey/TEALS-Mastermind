package com.hervey.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppMastermind {
	public static final int numberOfAllowedGuesses = 8;  //should be 8 for production code

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		Mastermind codemaker = new Mastermind();
		displayWelcome(numberOfAllowedGuesses);
		for (int i = 1; i <= numberOfAllowedGuesses; i++) {
			System.out.print("---\n>>Guess: " + i + ": ");
			String guess = stdin.readLine();
//			while(guess.length()!=4) {
//				System.out.println("please enter exactly four letters");
//				guess = stdin.readLine();
//			}
			for(; ; ) {
				if(guess.length()==4) {break;}
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

	private static void displayWelcome(int maxGuesses) {
		System.out.println("There is a secret code consisting of 4 letters\nYou have " + maxGuesses + " guesses to try for a match>>Please enter exactly 4 letters");
		System.out.println("After each guess you make, the display will show:  \n\t1) Number of exact matches which means right letters in the right position");
		System.out.println("\t2) Number of near matches which are right letters, but in wrong position");
		System.out.println("If you guess right, or run out of allowable guesses, you will be notified");
		
	}
}
