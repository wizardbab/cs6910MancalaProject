package edu.westga.cs6910.mancala.model;

/**
 * ComputerPlayer represents a very simple automated player in the game Mancala.
 * It always selects the closest pit for stones to be distributed
 * 
 * @author	En Yang Pang
 * @version	06/12/2019
 */
public class ComputerPlayer extends AbstractPlayer implements Player {
	private static final String NAME = "Simple computer";
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param	theGame	The Game that this player represents
	 * 
	 */
	public ComputerPlayer(Game theGame) {
		super(NAME, theGame);
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */	
	public void takeTurn(int pitChoice) {				
		pitChoice = this.getGame().getBoardSize() - 2;
		super.takeTurn(pitChoice);
	}
}
