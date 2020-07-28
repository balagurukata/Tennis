package com.bnpp.kata.tennis;

import com.bnpp.kata.tennis.model.Player;

public class TennisGame {

	private Player firstPlayer;
	private Player secondPlayer;

	private static final String[] GAME_SCORE = { "Love", "Fifteen" };

	public TennisGame() {
		firstPlayer = new Player("FirstPlayer");
		secondPlayer = new Player("SecondPlayer");
	}

	public Object getFirstPlayerScoredPoint() {
		return firstPlayer.getScoredPoint();
	}

	public Object getSecondPlayerScoredPoint() {
		return secondPlayer.getScoredPoint();
	}

	public Object getFirstPlayerName() {
		return firstPlayer.getName();
	}

	public Object getSecondPlayerName() {
		return secondPlayer.getName();
	}

	public Object calculateGameScore() {
		String gameScore = "";
		if (firstPlayer.getScoredPoint() == secondPlayer.getScoredPoint()) {
			gameScore = "Love-All";
		} else {
			gameScore = GAME_SCORE[firstPlayer.getScoredPoint()] + "-" + GAME_SCORE[secondPlayer.getScoredPoint()];
		}
		return gameScore;
	}

	public void incrementFirstPlayerScore() {
		firstPlayer.incrementPlayerScore();
	}

}
