package com.bnpp.kata;

import java.util.Scanner;
import java.util.logging.Logger;

import com.bnpp.kata.tennis.TennisGame;

public class TennisGameApp {

	private static final Logger LOGGER = Logger.getLogger(TennisGameApp.class.getName());
	
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);

		LOGGER.info("Welcome!! Are you ready to play Tennis! \r\nPlease enter the First Player name ('A')");
		String playerOneName = inputScanner.nextLine();

		LOGGER.info("Please enter the First Player name ('B')");
		String playerTwoName = inputScanner.nextLine();

		launchTennisGame(inputScanner, playerOneName, playerTwoName);

		LOGGER.info("*************** Game Over !!! *************");
	}

	private static void launchTennisGame(Scanner inputScanner, String playerOneName, String playerTwoName) {
		char winningIndicator;
		String gameScore;
		
		final String winningIndicatorSysOutMessage = new StringBuilder("Press 'A' to indicate '").append(playerOneName)
				.append("' win the current service or Press 'B' to indicate '").append(playerTwoName)
				.append("' win the current service or Press any other key to quit the game\n").toString();

		TennisGame tennisGame = new TennisGame(playerOneName, playerTwoName);
		LOGGER.info("******************* Lets start the game !!! ********************");
		do {
			LOGGER.info(winningIndicatorSysOutMessage);

			winningIndicator = inputScanner.next().charAt(0);
			tennisGame.addServicePointToWinner(winningIndicator);
			gameScore = tennisGame.calculateGameScore();
			LOGGER.info("Current Game score: " + gameScore);
		} while (isGameInProgress(gameScore));
	}

	private static boolean isGameInProgress(String gameScore) {
		return !gameScore.endsWith("Won the game");
	}
}