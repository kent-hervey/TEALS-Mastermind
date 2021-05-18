package com.hervey.app;

import java.io.*;

/**
 * This class implements the Mastermind game. It will generate a random code and
 * the user has up to 8 chances to guess the correct code.
 */
public class Mastermind {
	// DATA MEMBERS //
	private String code; // the code
	// CONSTRUCTOR //

	/**
	 * randomly generate the code (a string with 4 letters chosen from ’a’ to ’f’)
	 */
	public Mastermind() {
		code = new String();
		for (int i = 0; i < 4; i++) {
			char ch = (char) (int) (Math.random() * 6 + 'a');
			code = code + ch;
		}
		System.out.println("Delete after project complete\nGenerated code:  " + this.code);
	}

	// PUBLIC METHODS
	/**
	 * return the code
	 */
	public String getCode() {
		System.out.println("code is:  " + this.code);
		return this.code;
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
		// NOT IMPLEMENTED YET
		return -99999;
	}

}
