package com.bnpp.kata.tennis;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TennisGameTest {

	private TennisGame tennisGame;

	@Before
	public void inti() {
		tennisGame = new TennisGame();
	}

	@Test
	public void firstPlayerScoredPointShouldBeEqualToZeroWhenTheGameStarts() {
		assertThat(0, is(tennisGame.getFirstPlayerScoredPoint()));
	}

	@Test
	public void secondPlayerScoredPointShouldBeEqualToZeroWhenTheGameStarts() {
		assertThat(0, is(tennisGame.getSecondPlayerScoredPoint()));
	}

	@Test
	public void playerNamesShouldBeInitializedAsFirstPlayerAndSeconPlayerRespectivelyWhenTheGameStarts() {
		assertThat("FirstPlayer", is(tennisGame.getFirstPlayerName()));
		assertThat("SecondPlayer", is(tennisGame.getSecondPlayerName()));
	}

	@Test
	public void gameScoreShouldBeLoveAllwhenBeforeTheGameStarts() {
		assertThat("Love-All", is(tennisGame.calculateGameScore()));
	}

	@Test
	public void firstPlayerScorePointShouldBeFifteenLoveWhenFirstPlayerGotAVeryFirstPoint() {
		updateFirstPlayerScores(1);
		assertThat("Fifteen-Love", is(tennisGame.calculateGameScore()));
	}

	@Test
	public void gameScoreShouldBeLoveThirtyWhenSecondPlayerGotVeryFirstAndScondScorePointOfTheGame() {
		updateSecondPlayerScores(2);
		assertThat("Love-Thirty", is(tennisGame.calculateGameScore()));
	}

	@Test
	public void gameScoreShouldBeFifteenAllWhenFirstAndSecondPlayerGotSinglePointOfTheGame() {
		updateFirstPlayerScores(1);
		updateSecondPlayerScores(1);
		assertThat("Fifteen-All", is(tennisGame.calculateGameScore()));
	}

	@Test
	public void gameScoreShouldBeFifteenThirtyWhenFirstPlayerGotOnePointAndSecondPlayerGotTwoPointsInAllThreeServicesOfTheGame() {
		updateFirstPlayerScores(1);
		updateSecondPlayerScores(2);
		assertThat("Fifteen-Thirty", is(tennisGame.calculateGameScore()));
	}

	private void updateFirstPlayerScores(int numberOfWins) {
		for (int i = 0; i < numberOfWins; i++) {
			tennisGame.incrementFirstPlayerScore();
		}
	}

	private void updateSecondPlayerScores(int numberOfWins) {
		for (int i = 0; i < numberOfWins; i++) {
			tennisGame.incrementSecondPlayerScore();
		}
	}

	@Test
	@Parameters({ "1, 1, Fifteen-All", "0, 1, Love-Fifteen", "2, 1, Thirty-Fifteen", "2, 3, Thirty-Forty",
			"2, 2, Thirty-All" })
	public void gameScoreShouldBeExpectedResultWhichIsMentionedInPreDefinedParametersWithPlayersPointsOgTheGame(
			int firstPlayerPoints, int secondPlayerPoints, String expectedGameResult) {
		updateFirstPlayerScores(firstPlayerPoints);
		updateSecondPlayerScores(secondPlayerPoints);
		assertThat(expectedGameResult, is(tennisGame.calculateGameScore()));
	}

	@Test
	public void gameShouldBeWonByFirstPlayerWhenFirstPlayerScoreMinimumFourPointsAndSecondPlayerScoreShouldBeMinimumLessThanTwoPointsOfFirstPlayer() {
		updateFirstPlayerScores(4);
		updateSecondPlayerScores(1);
		assertThat("FirstPlayer Won the game", is(tennisGame.calculateGameScore()));
	}

	@Test
	public void gameShouldBeWonBySecondPlayerWhenSecondPlayerScoreMinimumFourPointsAndFirstPlayerScoreShouldBeMinimumLessThanTwoPointsOfSecondPlayer() {
		updateFirstPlayerScores(3);
		updateSecondPlayerScores(5);
		assertThat("SecondPlayer Won the game", is(tennisGame.calculateGameScore()));
	}

	@Test
	public void gameScoreShouldBeDeuceWhenBothPlayersHavingSameScoreAsTheePoints() {
		updateFirstPlayerScores(3);
		updateSecondPlayerScores(3);
		assertThat("Deuce", is(tennisGame.calculateGameScore()));
	}

	@Test
	public void gameScoreShouldBeFirstPlayerHasAdvantageWhenBothPlayersReachedMinimumThreePointsAndFirstPlayerHasOneExtraPointAsLeadPoint() {
		updateFirstPlayerScores(4);
		updateSecondPlayerScores(3);
		assertThat("FirstPlayer has advantage", is(tennisGame.calculateGameScore()));
	}
	
    @Test
    public void bothPlayerNamesShouldBeEqualsToCustomNamesWhichIsInitializedOnGameObjectCreation() {
        tennisGame = new TennisGame("AAA", "BBB");
        assertThat("AAA", is(tennisGame.getFirstPlayerName()));
        assertThat("BBB", is(tennisGame.getSecondPlayerName()));
    }
    
    @Test
    public void gameScoreShouldBeAddedByOneForFirstPlayerWhenPlayerWinnerIndicatorAsA() {
        updateFirstPlayerScores(1);
		updateSecondPlayerScores(1);
        int expectedFirstPlayerPoint = tennisGame.getFirstPlayerScoredPoint() + 1;
        tennisGame.addServicePointToWinner("A");
        assertThat(expectedFirstPlayerPoint, is(tennisGame.getFirstPlayerScoredPoint()));
    }
    
    @Test
    public void gameScoreShouldBeAddedByOneForSecondPlayerWhenPlayerWinnerIndicatorAsB() {
        updateFirstPlayerScores(1);
		updateSecondPlayerScores(2);
        int expectedSecondPlayerPoint = tennisGame.getSecondPlayerScoredPoint() + 1;
        tennisGame.addServicePointToWinner("B");
        assertThat(expectedSecondPlayerPoint, is(tennisGame.getSecondPlayerScoredPoint()));
    }
}