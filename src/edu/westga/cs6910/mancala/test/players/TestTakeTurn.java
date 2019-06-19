package edu.westga.cs6910.mancala.test.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.Game;
import org.junit.jupiter.api.Test;

/**
 * This class tests the Players' takeTurn method and ensures they take their
 * turn correctly.
 * 
 * @author En Yang Pang
 * @version 06/19/2019
 */
public class TestTakeTurn {

	/**
	 * Tests that the human player distributes the stone from pit 0
	 */
	@Test
	public void testHumanPlayerPlayedTurnDistributedStoneFromPit0() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer());
		newGame.getCurrentPlayer().takeTurn(0);
		assertEquals(newGame.getStones(0), 0);
	}
	
	/**
	 * Tests that the human player's distributed stone ended up in pit 1
	 */
	@Test
	public void testHumanPlayerPlayedTurnStoneIsInPit1() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer());
		newGame.getCurrentPlayer().takeTurn(0);
		assertEquals(newGame.getStones(1), 2);
	}
	
	/**
	 * Tests that the human player has taken the turn and is no longer his turn
	 */
	@Test
	public void testHumanPlayerPlayedNotHisTurnAnymore() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer());
		newGame.getCurrentPlayer().takeTurn(0);
		assertEquals(newGame.getHumanPlayer().getIsMyTurn(), false);
	}

	/**
	 * Tests that the computer player's first taken turn moves a stone from pit 6 to 7.
	 */
	@Test
	public void testComputerPlayerPlayedTurnDistributedStoneFromPit6() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getComputerPlayer());
		newGame.getCurrentPlayer().takeTurn(6);
		assertEquals(newGame.getStones(6), 0);
	}
	
	/**
	 * Tests that the computer player's distributed stone ended up in pit 7
	 */
	@Test
	public void testComputerPlayerPlayedTurnStoneIsInPit7() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getComputerPlayer());
		newGame.getCurrentPlayer().takeTurn(6);
		assertEquals(newGame.getStones(7), 1);
	}
	
	/**
	 * Tests that the computer player has taken the turn and is no longer its turn
	 */
	@Test
	public void testComputerPlayerPlayedNotHisTurnAnymore() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getComputerPlayer());
		newGame.getCurrentPlayer().takeTurn(6);
		assertEquals(newGame.getComputerPlayer().getIsMyTurn(), false);
	}
}
