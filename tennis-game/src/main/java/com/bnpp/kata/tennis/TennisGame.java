package com.bnpp.kata.tennis;

import com.bnpp.kata.tennis.model.Player;

public class TennisGame {

	private Player firstPlayer;
	private Player secondPlayer;

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

}
