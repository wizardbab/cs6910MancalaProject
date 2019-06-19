package edu.westga.cs6910.mancala.test.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.cs6910.mancala.model.Game;
import org.junit.jupiter.api.Test;

/**
 * This class tests getting the name from the different Player types.
 * Because the Game class automatically creates a HumanPlayer and a
 * ComputerPlayer in its constructor, we will be using those objects.
 * There is no way to test the object itself, so the accessor methods
 * are used instead.
 * 
 * @author En Yang Pang
 * @version 06/19/2019
 */
public class TestGetName {

	/**
	 * Tests getting the generic "Simple computer" name from the 
	 * ComputerPlayer
	 */
	@Test
	public void testComputerPlayerNameShouldBeSimpleComputer() {
		Game newGame = new Game();
		assertEquals(newGame.getComputerPlayer().getName(), "Simple computer");
	}
	
	/**
	 * Tests getting the "Human" name from the HumanPlayer
	 */
	@Test
	public void testHumanPlayerNameShouldBeHuman() {
		Game newGame = new Game();
		assertEquals(newGame.getHumanPlayer().getName(), "Human");
	}
	
}
