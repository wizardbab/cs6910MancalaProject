package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.Game;
import org.junit.jupiter.api.Test;

/**
 * This class tests the creating of the Game class of Mancala.
 * 
 * @author En Yang Pang
 * @version 06/18/2019
 */
public class TestCreateGame {

	/**
	 * Tests creating a game with no score
	 */
	@Test
	public void testShouldProduceGameWithNoScore() {
		Game newGame = new Game();
		assertEquals("Human: 0" + System.getProperty("line.separator") + "Simple computer: 0", newGame.toString());
	}
	
	/**
	 * Tests getting the board size
	 */
	@Test
	public void testNewGameShouldHaveBoardSize8() {
		Game newGame = new Game();
		assertEquals(8, newGame.getBoardSize());
	}
	
}
