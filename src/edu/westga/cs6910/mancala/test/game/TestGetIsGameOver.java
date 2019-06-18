package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

import org.junit.jupiter.api.Test;

/**
 * This class tests the game over state of the Game class before the game starts.
 * 
 * @author En Yang Pang
 * @version 06/18/2019
 */
public class TestGetIsGameOver {

	/**
	 * Tests that the game state is not game over before the game starts
	 */
	@Test
	public void testBeforeGameStartIsNotOver() {
		Game newGame = new Game();
		assertEquals(false, newGame.getIsGameOver());
	}

	/**
	 * Tests that the game state is not game over after a new game is started
	 */
	@Test
	public void testWhenGameFirstStartsIsNotOver() {
		Game newGame = new Game();
		newGame.startNewGame(new HumanPlayer("Bob", newGame));
		assertEquals(newGame.getIsGameOver(), false);
	}
}
