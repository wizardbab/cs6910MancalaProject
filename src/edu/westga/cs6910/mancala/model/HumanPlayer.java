package edu.westga.cs6910.mancala.model;

/**
 * HumanPlayer represents a human player in the game Mancala.
 * 
 * @author	En Yang Pang
 * @version 06/12/2019
 */
public class HumanPlayer extends AbstractPlayer implements Player {
	
	/**
	 * Creates a new HumanPlayer with the specified name.
	 * 
	 * @param 	name	this Player's name
	 * @param	theGame	The Game that this player represents
	 * 
	 * @requires	name != null
	 * @ensure		name().equals(name) && getTotal() == 0
	 */
	public HumanPlayer(String name, Game theGame) {
		super(name, theGame);
	}
}
