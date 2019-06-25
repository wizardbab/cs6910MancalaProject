package edu.westga.cs6910.mancala.test.strategies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.strategies.FarStrategy;
import org.junit.jupiter.api.Test;

/**
 * This class tests the FarStrategy strategy for the computer player.
 * 
 * @author En Yang Pang
 * @version 06/25/2019
 */
public class TestFarStrategy {

	/**
	 * Tests whether the strategy selects pit 4 when all playing pits have a stone.
	 */
	@Test
	public void testSelectFarthestPitWhenAllPitsHaveStones() {
		int[] gameBoard = {1, 1, 1, 0, 1, 1, 1, 0};
		FarStrategy currentStrategy = new FarStrategy();
		assertEquals(4, currentStrategy.selectPit(gameBoard));
	}

	/**
	 * Tests whether the strategy selects pit 5 when pit 4 does not have a stone.
	 */
	@Test
	public void testSelectFarthestPitWhenPit4HasNoStone() {
		int[] gameBoard = {1, 1, 1, 0, 0, 1, 1, 0};
		FarStrategy currentStrategy = new FarStrategy();
		assertEquals(5, currentStrategy.selectPit(gameBoard));
	}
	
	/**
	 * Tests whether the strategy selects pit 6 when pits 4 and 5 have no stone.
	 */
	@Test
	public void testSelectFarthestPitWhenPit4And5HaveNoStone() {
		int[] gameBoard = {1, 1, 1, 0, 0, 0, 2, 0};
		FarStrategy currentStrategy = new FarStrategy();
		assertEquals(6, currentStrategy.selectPit(gameBoard));
	}
}
