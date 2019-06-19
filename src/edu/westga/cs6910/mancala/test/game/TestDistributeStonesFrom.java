package edu.westga.cs6910.mancala.test.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.Game;
import org.junit.jupiter.api.Test;

/**
 * This class tests the distributeStonesFrom method. The Game object 
 * would have been created already and the game would have started.
 * 
 * @author En Yang Pang
 * @version 06/19/2019
 */
public class TestDistributeStonesFrom {
	
	/**
	 * Tests distributing stones from pit 0 as human first.
	 * Pit 0 should have 0 stones.
	 */
	@Test
	public void testWhenDistributeStoneFromPit0Pit0IsEmpty() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer());
		newGame.distributeStonesFrom(0);
		assertEquals(0, newGame.getStones(0));
	}
	
	/**
	 * Tests distributing stones from pit 0 as human first.
	 * Pit 1 should have 2 stones.
	 */
	@Test
	public void testWhenDistributeStoneFromPit0Pit1Has2Stones() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer());
		newGame.distributeStonesFrom(0);
		assertEquals(2, newGame.getStones(1));
	}
	
	/**
	 * Tests distributing the stones from pit 1 after the above test.
	 * Pit 1 should have 0 stones.
	 */
	@Test
	public void testWhenDistributeStoneFromPit1Pit1IsEmpty() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer());
		newGame.distributeStonesFrom(0);
		newGame.distributeStonesFrom(1);
		assertEquals(0, newGame.getStones(1));
	}
	
	/**
	 * Tests distributing the stones from pit 1 after the second test.
	 * Pit 2 should have 2 stones.
	 */
	@Test
	public void testWhenDistributeStoneFromPit1Pit2Has2Stones() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer());
		newGame.distributeStonesFrom(0);
		newGame.distributeStonesFrom(1);
		assertEquals(2, newGame.getStones(2));
	}
	
	/**
	 * Tests distributing the stones from pit 1 after the second test.
	 * Pit 3 should have 1 stone.
	 */
	@Test
	public void testWhenDistributeStoneFromPit1Pit3Has1Stone() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer());
		newGame.distributeStonesFrom(0);
		newGame.distributeStonesFrom(1);
		assertEquals(1, newGame.getStones(3));
	}
}
