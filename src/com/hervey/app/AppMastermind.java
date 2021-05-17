package com.hervey.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppMastermind {
	public static final int numberOfAllowedGuesses = 2;  //should be 8 for production code

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		Mastermind codemaker = new Mastermind();
		displayWelcome(numberOfAllowedGuesses);
		for (int i = 1; i <= numberOfAllowedGuesses; i++) {
			System.out.print("Guess: " + i + ": ");
			String guess = stdin.readLine();
			codemaker.reportMatches(guess);
			if (codemaker.isWin(guess)) {
				System.out.println("You WIN!");
				System.exit(0); // Terminate if the user wins
			}
		}
		System.out.println("The correct code is " + codemaker.getCode());
	}

	private static void displayWelcome(int maxGuesses) {
		System.out.println("There is a secret code consisting of 4 letters\nYou have " + maxGuesses + " guesses to try for a match");
	}
}
