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
        tennisGame.incrementFirstPlayerScore();
        assertThat("Fifteen-Love", is(tennisGame.calculateGameScore()));
    }
    
    @Test
    public void gameScoreShouldBeLoveThirtyWhenSecondPlayerGotVeryFirstAndScondScorePointOfTheGame() {
        tennisGame.incrementSecondPlayerScore();
        tennisGame.incrementSecondPlayerScore();
        assertThat("Love-Thirty", is(tennisGame.calculateGameScore()));
    }
    
    @Test
    public void gameScoreShouldBeFifteenAllWhenFirstAndSecondPlayerGotSinglePointOfTheGame() {
        tennisGame.incrementFirstPlayerScore();
        tennisGame.incrementSecondPlayerScore();
        assertThat("Fifteen-All", is(tennisGame.calculateGameScore()));
    }
}