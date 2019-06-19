package edu.westga.cs6910.mancala.test.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.Game;
import org.junit.jupiter.api.Test;

/**
 * This class tests getting the associated game from the different Player types.
 * 
 * @author En Yang Pang
 * @version 06/19/2019
 */
public class TestGetGame {

	/**
	 * Tests getting the game from the ComputerPlayer is the game itself
	 */
	@Test
	public void testComputerPlayerGameShouldBeItself() {
		Game newGame = new Game();
		assertEquals(newGame.getComputerPlayer().getGame(), newGame);
	}
	
	/**
	 * Tests getting the game from the HumanPlayer is the game itself
	 */
	@Test
	public void testHumanPlayerGameShouldBeItself() {
		Game newGame = new Game();
		assertEquals(newGame.getHumanPlayer().getGame(), newGame);
	}
}
