package edu.westga.cs6910.mancala.model;

import edu.westga.cs6910.mancala.model.strategies.NearStrategy;
import edu.westga.cs6910.mancala.model.strategies.SelectStrategy;

/**
 * ComputerPlayer represents a very simple automated player in the game Mancala.
 * 
 * @author	En Yang Pang
 * @version	06/12/2019
 */
public class ComputerPlayer extends AbstractPlayer implements Player {
	private static final String NAME = "Simple computer";
	private SelectStrategy currentStrategy;
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param	theGame	The Game that this player represents
	 * 
	 */
	public ComputerPlayer(Game theGame) {
		super(NAME, theGame);
		this.currentStrategy = new NearStrategy();
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */	
	public void takeTurn(int pitChoice) {
		super.takeTurn(this.currentStrategy.selectPit(this.getGame().getGameBoard()));
	}
	
	/**
	 * Sets the strategy to be used by the computer.
	 * 
	 * @param strategy Strategy used
	 */
	public void setStrategy(SelectStrategy strategy) {
		this.currentStrategy = strategy;
	}
}
