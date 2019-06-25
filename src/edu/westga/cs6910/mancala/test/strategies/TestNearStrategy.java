package edu.westga.cs6910.mancala.test.strategies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.strategies.NearStrategy;
import org.junit.jupiter.api.Test;

/**
 * This class tests the NearStrategy strategy for the computer player.
 * 
 * @author En Yang Pang
 * @version 06/25/2019
 */
public class TestNearStrategy {

	/**
	 * Tests whether the strategy selects pit 6 when all playing pits have a stone.
	 */
	@Test
	public void testSelectNearestPitWhenAllPitsHaveStones() {
		int[] gameBoard = {1, 1, 1, 0, 1, 1, 1, 0};
		NearStrategy currentStrategy = new NearStrategy();
		assertEquals(6, currentStrategy.selectPit(gameBoard));
	}

	/**
	 * Tests whether the strategy selects pit 5 when pit 6 does not have a stone.
	 */
	@Test
	public void testSelectNearestPitWhenPit6HasNoStone() {
		int[] gameBoard = {1, 1, 1, 0, 1, 1, 0, 0};
		NearStrategy currentStrategy = new NearStrategy();
		assertEquals(5, currentStrategy.selectPit(gameBoard));
	}
	
	/**
	 * Tests whether the strategy selects pit 4 when pits 5 and 6 have no stone.
	 */
	@Test
	public void testSelectNearestPitWhenPit5And6HaveNoStone() {
		int[] gameBoard = {1, 1, 1, 0, 2, 0, 0, 0};
		NearStrategy currentStrategy = new NearStrategy();
		assertEquals(4, currentStrategy.selectPit(gameBoard));
	}
}
