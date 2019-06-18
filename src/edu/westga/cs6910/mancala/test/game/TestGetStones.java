package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.Game;
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
	 * Tests pit 0 is empty
	 */
	@Test
	public void testPit0ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(0));
	}
	/**
	 * Tests pit 1 is empty
	 */
	@Test
	public void testPit1ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(1));
	}
	
	/**
	 * Tests pit 2 is empty
	 */
	@Test
	public void testPit2ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(2));
	}
	
	/**
	 * Tests pit 3 is empty
	 */
	@Test
	public void testPit3ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(3));
	}
	
	/**
	 * Tests pit 4 is empty
	 */
	@Test
	public void testPit4ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(4));
	}
	
	/**
	 * Tests pit 5 is empty
	 */
	@Test
	public void testPit5ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(5));
	}
	
	/**
	 * Tests pit 6 is empty
	 */
	@Test
	public void testPit6ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(6));
	}
	
	/**
	 * Tests pit 7 is empty
	 */
	@Test
	public void testPit7ShouldBeEmpty() {
		Game newGame = new Game();
		assertEquals(0, newGame.getStones(7));
	}

}
