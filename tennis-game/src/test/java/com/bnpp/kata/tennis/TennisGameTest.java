package com.bnpp.kata.tennis;

import static org.junit.Assert.assertThat;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

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
}