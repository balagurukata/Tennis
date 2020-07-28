package com.bnpp.kata.tennis;

import com.bnpp.kata.tennis.model.Player;
import static com.bnpp.kata.tennis.utils.TennisGameConstants.*;

public class TennisGame {

	private Player firstPlayer;
	private Player secondPlayer;

	private static final String[] GAME_SCORE = { "Love", "Fifteen", "Thirty", "Forty" };

	public TennisGame() {
		firstPlayer = new Player(DEFAULT_FIRST_PLAYER_NAME);
		secondPlayer = new Player(DEFAULT_SECOND_PLAYER_NAME);
	}

	public TennisGame(String firstPlayerName, String secondPlayerName) {
		firstPlayer = new Player(firstPlayerName);
		secondPlayer = new Player(secondPlayerName);
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
		String gameScore = INITIAL_GAME_SCORE;
		if (isPlayersHasEqualScore()) {
			gameScore = isPalyersHasDeuceScore() ? DEUCE_GAME_SCORE
					: GAME_SCORE[firstPlayer.getScoredPoint()] + GAME_SCORE_SEPARATOR + GAME_SCORE_ALL;
		} else if (isAnyPlayerEligibleToWin()) {
			gameScore = isPlayersScoreDifferenceEqualToOne() ? getEligibleWinningPlayerScore(ADVANTAGE_GAME_SCORE)
					: getEligibleWinningPlayerScore(GAME_WON_RESULT);
		} else {
			gameScore = GAME_SCORE[firstPlayer.getScoredPoint()] + GAME_SCORE_SEPARATOR
					+ GAME_SCORE[secondPlayer.getScoredPoint()];
		}
		return gameScore;
	}

	private String getEligibleWinningPlayerScore(String winningScenario) {
		return getPlayerOfTheGame() + winningScenario;
	}

	private boolean isPlayersScoreDifferenceEqualToOne() {
		return Math.abs(firstPlayer.getScoredPoint() - secondPlayer.getScoredPoint()) == ADVANTAGE_DIFFERENCE_POINT;
	}

	private boolean isAnyPlayerEligibleToWin() {
		return firstPlayer.getScoredPoint() >= MINIMUM_WINNING_SCORE
				|| secondPlayer.getScoredPoint() >= MINIMUM_WINNING_SCORE;
	}

	private boolean isPalyersHasDeuceScore() {
		return secondPlayer.getScoredPoint() >= 3;
	}

	private boolean isPlayersHasEqualScore() {
		return firstPlayer.getScoredPoint() == secondPlayer.getScoredPoint();
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

	public void addServicePointToWinner(String winningPlayerIndicator) {
		if ("A".equals(winningPlayerIndicator)) {
			incrementFirstPlayerScore();
		} else if ("B".endsWith(winningPlayerIndicator)) {
			incrementSecondPlayerScore();
		}
	}

}
