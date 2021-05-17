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
	}

	// PUBLIC METHODS
	/**
	 * return the code
	 */
	public String getCode() {
		String code = "fake";
		return code;
	}

	/**
	 * print the number of exact and near matches
	 */
	public void reportMatches(String guess) {
		// NOT IMPLEMENTED YET
	}

	/**
	 * return true if the guess is correct; otherwise, return false
	 */
	public boolean isWin(String guess) {
		// NOT IMPLEMENTED YET
		return false;
	}

	// PRIVATE METHODS
	/**
	 * return the number of exact matches
	 */
	private int exactMatches(String guess) {
		// NOT IMPLEMENTED YET
		return 0;
	}

	/**
	 * return the number of near matches
	 */
	private int nearMatches(String guess) {
		// NOT IMPLEMENTED YET
		return 0;
	}

}
