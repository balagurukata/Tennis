package com.bnpp.kata.tennis.model;

public enum PlayerIndicator {
	
	PLAYER1('A'), PLAYER2('B');

	private char value;

	private PlayerIndicator(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}
}
