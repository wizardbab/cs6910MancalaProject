package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

import org.junit.jupiter.api.Test;

/**
 * This class tests whether the getStones method works correctly and
 * the number of stones in each pit when a Game is created.
 * 
 * @author En Yang Pang
 * @version 06/18/2019
 */
public class TestGetStones {

	/**
	 * Tests pit 0 is empty before the game starts
	 */
	@Test
	public void testBeforeGameStartPit0ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(0));
	}
	/**
	 * Tests pit 1 is empty before the game starts
	 */
	@Test
	public void testBeforeGameStartPit1ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(1));
	}
	
	/**
	 * Tests pit 2 is empty before the game starts
	 */
	@Test
	public void testBeforeGameStartPit2ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(2));
	}
	
	/**
	 * Tests pit 3 is empty before the game starts
	 */
	@Test
	public void testBeforeGameStartPit3ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(3));
	}
	
	/**
	 * Tests pit 4 is empty before the game starts
	 */
	@Test
	public void testBeforeGameStartPit4ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(4));
	}
	
	/**
	 * Tests pit 5 is empty before the game starts
	 */
	@Test
	public void testBeforeGameStartPit5ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(5));
	}
	
	/**
	 * Tests pit 6 is empty before the game starts
	 */
	@Test
	public void testBeforeGameStartPit6ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(6));
	}
	
	/**
	 * Tests pit 7 is empty before the game starts
	 */
	@Test
	public void testBeforeGameStartPit7ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(7));
	}
	
	/**
	 * Tests pit 0 has 1 stone after new game starts
	 */
	@Test
	public void testWhenGameFirstStartsPit0Has1Stone() {
		Game newGame = new Game();
		newGame.startNewGame(new HumanPlayer("Bob", newGame));
		assertEquals(newGame.getStones(0), 1);
	}

	/**
	 * Tests pit 1 has 1 stone after new game starts
	 */
	@Test
	public void testWhenGameFirstStartsPit1Has1Stone() {
		Game newGame = new Game();
		newGame.startNewGame(new HumanPlayer("Bob", newGame));
		assertEquals(newGame.getStones(1), 1);
	}
	
	/**
	 * Tests pit 2 has 1 stone after new game starts
	 */
	@Test
	public void testWhenGameFirstStartsPit2Has1Stone() {
		Game newGame = new Game();
		newGame.startNewGame(new HumanPlayer("Bob", newGame));
		assertEquals(newGame.getStones(2), 1);
	}
	
	/**
	 * Tests pit 3 has 0 stones after new game starts
	 */
	@Test
	public void testWhenGameFirstStartsPit3Has0Stones() {
		Game newGame = new Game();
		newGame.startNewGame(new HumanPlayer("Bob", newGame));
		assertEquals(newGame.getStones(3), 0);
	}
	
	/**
	 * Tests pit 4 has 1 stone after new game starts
	 */
	@Test
	public void testWhenGameFirstStartsPit4Has1Stone() {
		Game newGame = new Game();
		newGame.startNewGame(new HumanPlayer("Bob", newGame));
		assertEquals(newGame.getStones(4), 1);
	}	/**
	 * Tests pit 5 has 1 stone after new game starts
	 */
	@Test
	public void testWhenGameFirstStartsPit5Has1Stone() {
		Game newGame = new Game();
		newGame.startNewGame(new HumanPlayer("Bob", newGame));
		assertEquals(newGame.getStones(5), 1);
	}
	
	/**
	 * Tests pit 6 has 1 stone after new game starts
	 */
	@Test
	public void testWhenGameFirstStartsPit6Has1Stone() {
		Game newGame = new Game();
		newGame.startNewGame(new HumanPlayer("Bob", newGame));
		assertEquals(newGame.getStones(6), 1);
	}
	
	/**
	 * Tests pit 7 has 0 stones after new game starts
	 */
	@Test
	public void testWhenGameFirstStartsPit7Has0Stones() {
		Game newGame = new Game();
		newGame.startNewGame(new HumanPlayer("Bob", newGame));
		assertEquals(newGame.getStones(7), 0);
	}
	
}
