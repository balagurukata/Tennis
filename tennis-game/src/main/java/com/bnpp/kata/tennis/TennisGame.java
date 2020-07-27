package com.bnpp.kata.tennis;

public class TennisGame {

	private int firstPlayerScoredPoint;
	private int secondPlayerScoredPoint;

	private String firstPlayerName;
	private String secondPlayerName;

	public TennisGame() {
		firstPlayerName = "FirstPlayer";
		secondPlayerName = "SecondPlayer";
	}

	public Object getFirstPlayerScoredPoint() {
		return firstPlayerScoredPoint;
	}

	public Object getSecondPlayerScoredPoint() {
		return secondPlayerScoredPoint;
	}

	public Object getFirstPlayerName() {
		return firstPlayerName;
	}

	public Object getSecondPlayerName() {
		return secondPlayerName;
	}

}
