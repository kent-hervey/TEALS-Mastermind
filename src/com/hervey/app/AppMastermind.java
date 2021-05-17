package com.hervey.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppMastermind {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		Mastermind codemaker = new Mastermind();
		for (int i = 1; i <= 8; i++) {
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
}
