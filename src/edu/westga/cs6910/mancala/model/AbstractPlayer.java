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
	private boolean stoleOpponentStones;
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
		this.stoleOpponentStones = false;
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
	
	/**
	 * Returns whether the Player managed to land on an empty pit and 
	 * take the opposite stones.
	 * 
	 * @return true if yes; false if no
	 */
	public boolean getStoleOpponentStones() {
		return this.stoleOpponentStones;
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
		int lastPit = this.theGame.distributeStonesFrom(pitChoice);
		if (this.theGame.getCurrentPlayer() == this.theGame.getComputerPlayer() && lastPit == this.theGame.getBoardSize() - 1) {
			this.theGame.getCurrentPlayer().setIsMyTurn(true);
		} else if (this.theGame.getCurrentPlayer() == this.theGame.getHumanPlayer() && lastPit == this.theGame.getBoardSize() / 2 - 1) {
			this.theGame.getCurrentPlayer().setIsMyTurn(true);
		} else {
			this.checkLastPit(lastPit);
			this.isMyTurn = false;
		}
		
	}
	
	private void checkLastPit(int lastPit) {
		int oppositePit = this.theGame.getOppositePit(lastPit);
		int totalStonesWon = 0;
		
		boolean isPitEmpty = this.theGame.getWasPitEmpty(lastPit);
		boolean isOppositePitEmpty = this.theGame.getIsPitEmpty(oppositePit);
		boolean isComputerSide = (lastPit >= this.theGame.getBoardSize() / 2 && lastPit < this.theGame.getBoardSize()) && this.theGame.getCurrentPlayer() == this.theGame.getComputerPlayer();
		boolean isHumanSide = (lastPit >= 0 && lastPit < this.theGame.getBoardSize() / 2) && this.theGame.getCurrentPlayer() == this.theGame.getHumanPlayer();
		this.stoleOpponentStones = false;
		
		if (isPitEmpty && !isOppositePitEmpty && isComputerSide) {
			totalStonesWon = this.theGame.getGameBoard()[lastPit] + this.theGame.getGameBoard()[oppositePit];
			this.theGame.setBoardPitValue(lastPit, 0);
			this.theGame.setBoardPitValue(oppositePit, 0);
			this.theGame.setBoardPitValue(this.theGame.getBoardSize() - 1, this.theGame.getGameBoard()[this.theGame.getBoardSize() - 1] + totalStonesWon);
			this.stoleOpponentStones = true;
		} else if (isPitEmpty && !isOppositePitEmpty && isHumanSide) {
			totalStonesWon = this.theGame.getGameBoard()[lastPit] + this.theGame.getGameBoard()[oppositePit];
			this.theGame.setBoardPitValue(lastPit, 0);
			this.theGame.setBoardPitValue(oppositePit, 0);
			this.theGame.setBoardPitValue(this.theGame.getBoardSize() / 2 - 1, this.theGame.getGameBoard()[this.theGame.getBoardSize() / 2 - 1] + totalStonesWon);
			this.stoleOpponentStones = true;
		}
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
