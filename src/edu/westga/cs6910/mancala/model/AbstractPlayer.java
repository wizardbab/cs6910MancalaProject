package edu.westga.cs6910.mancala.model;

/**
 * This class is an abstraction of a kind of player of Mancala.
 * 
 * @author En Yang Pang
 * @version 06/12/2019
 */
public abstract class AbstractPlayer implements Player {
	private String name;
	private boolean isMyTurn;
	private Game theGame;
	
	/**
	 * Creates a new AbstractPlayer with the specified name.
	 * 
	 * @param name		this Player's name
	 * @param theGame	The Game that this player represents
	 */
	public AbstractPlayer(String name, Game theGame) {
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid Game object");
		}
		if (name == null) {
			throw new IllegalArgumentException("Invalid player name");
		}
		
		this.name = name;
		this.theGame = theGame;
	}
	
	@Override
	/**
	 * @see Player#getIsMyTurn()
	 */
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}
	
	@Override
	/**
	 * @see Player#getName()
	 */
	public String getName() {
		return this.name;
	}
	
	@Override
	/**
	 * @see Player#setIsMyTurn()
	 */
	public void setIsMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}
	
	@Override
	/**
	 * @see Player#takeTurn()
	 */
	public void takeTurn(int pitChoice) {
		this.theGame.distributeStonesFrom(pitChoice);
		
		this.isMyTurn = false;
	}
	
	/**
	 * Returns the Game that is being played.
	 * 
	 * @return The Game being played
	 */
	public Game getGame() {
		return this.theGame;
	}
}
