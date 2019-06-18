package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.Game;

import org.junit.jupiter.api.Test;

/**
 * This class tests getting the current player in the Game class under various circumstances.
 * 
 * @author En Yang Pang
 * @version 06/18/2019
 */
public class TestGetCurrentPlayer {

	/**
	 * Tests that the current player is Human
	 */
	@Test
	public void testGetCurrentPlayerShouldBeHuman() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer());
		assertEquals(newGame.getCurrentPlayer(), newGame.getHumanPlayer());
	}
	
	/**
	 * Tests that the current player is Computer
	 */
	@Test
	public void testGetCurrentPlayerShouldBeComputer() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getComputerPlayer());
		assertEquals(newGame.getCurrentPlayer(), newGame.getComputerPlayer());
	}

}
