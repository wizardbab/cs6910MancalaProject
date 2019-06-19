package edu.westga.cs6910.mancala.test.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;
import edu.westga.cs6910.mancala.model.ComputerPlayer;
import org.junit.jupiter.api.Test;

/**
 * This class tests the getIsMyTurn method of the Players.
 * 
 * @author En Yang Pang
 * @version 06/19/2019
 */
public class TestGetIsMyTurn {

	/**
	 * Tests that HumanPlayer's getIsMyTurn method returns true
	 * when it is set to true 
	 */
	@Test
	public void testWhenHumanIsMyTurnIsTrue() {
		HumanPlayer newHuman = new HumanPlayer("Bob", new Game());
		newHuman.setIsMyTurn(true);
		assertEquals(newHuman.getIsMyTurn(), true);
	}

	/**
	 * Tests that HumanPlayer's getIsMyTurn method returns false
	 * when it is set to false
	 */
	@Test
	public void testWhenHumanIsMyTurnIsFalse() {
		HumanPlayer newHuman = new HumanPlayer("Bob", new Game());
		newHuman.setIsMyTurn(false);
		assertEquals(newHuman.getIsMyTurn(), false);
	}
	
	/**
	 * Tests that ComputerPlayer's getIsMyTurn method returns true
	 * when it is set to true
	 */
	@Test
	public void testWhenComputerIsMyTurnIsTrue() {
		ComputerPlayer newComputer = new ComputerPlayer(new Game());
		newComputer.setIsMyTurn(true);
		assertEquals(newComputer.getIsMyTurn(), true);
	}
	
	/**
	 * Tests that ComputerPlayer's getIsMyTurn method returns false
	 * when it is set to false
	 */
	@Test
	public void testWhenComputerIsMyTurnIsFalse() {
		ComputerPlayer newComputer = new ComputerPlayer(new Game());
		newComputer.setIsMyTurn(false);
		assertEquals(newComputer.getIsMyTurn(), false);
	}
}
