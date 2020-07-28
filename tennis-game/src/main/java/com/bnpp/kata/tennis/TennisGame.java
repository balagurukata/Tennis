package com.bnpp.kata.tennis;

import com.bnpp.kata.tennis.model.Player;

public class TennisGame {

	private Player firstPlayer;
	private Player secondPlayer;

	private static final String[] GAME_SCORE = { "Love", "Fifteen", "Thirty", "Forty" };

	public TennisGame() {
		firstPlayer = new Player("FirstPlayer");
		secondPlayer = new Player("SecondPlayer");
	}

	public int getFirstPlayerScoredPoint() {
		return firstPlayer.getScoredPoint();
	}

	public int getSecondPlayerScoredPoint() {
		return secondPlayer.getScoredPoint();
	}

	public String getFirstPlayerName() {
		return firstPlayer.getName();
	}

	public String getSecondPlayerName() {
		return secondPlayer.getName();
	}

	public String calculateGameScore() {
		String gameScore = "";
		if (firstPlayer.getScoredPoint() == secondPlayer.getScoredPoint()) {
			gameScore = GAME_SCORE[firstPlayer.getScoredPoint()] + "-All";
		} else if (isGameWonByAnyPlayer()) {
			gameScore = getPlayerOfTheGame() + " Won the game";
		} else {
			gameScore = GAME_SCORE[firstPlayer.getScoredPoint()] + "-" + GAME_SCORE[secondPlayer.getScoredPoint()];
		}
		return gameScore;
	}

	private boolean isGameWonByAnyPlayer() {
		return (firstPlayer.getScoredPoint() >= 4 || secondPlayer.getScoredPoint() >= 4)
				&& Math.abs(secondPlayer.getScoredPoint() - firstPlayer.getScoredPoint()) >= 2;
	}

	private String getPlayerOfTheGame() {
		return firstPlayer.getScoredPoint() > secondPlayer.getScoredPoint() ? firstPlayer.getName()
				: secondPlayer.getName();
	}

	public void incrementFirstPlayerScore() {
		firstPlayer.incrementPlayerScore();
	}

	public void incrementSecondPlayerScore() {
		secondPlayer.incrementPlayerScore();
	}

}
