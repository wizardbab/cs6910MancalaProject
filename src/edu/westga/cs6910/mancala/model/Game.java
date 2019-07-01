package edu.westga.cs6910.mancala.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Game represents a Mancala game.
 * @author	En Yang Pang
 * @version	06/12/2019
 */
public class Game implements Observable {
	private int[] theBoard;
	
	private ObjectProperty<Player> currentPlayerObject;	
	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;
	
	private Player theWinner;
	private boolean isGameOver;

	/**
	 * Creates a Mancala Game with the specified Players
	 * 
	 */
	public Game() {
		this.theHuman = new HumanPlayer("Human", this);
		this.theComputer = new ComputerPlayer(this);
		
		this.currentPlayerObject = new SimpleObjectProperty<Player>();

		this.theBoard = new int[8];
	}

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer	 	the Player who takes the first turn
	 * 
	 * @require 					firstPlayer != null && 
	 * 
	 * @ensures 					whoseTurn().equals(firstPlayer)
	 */
	public void startNewGame(Player firstPlayer) {
		this.resetBoard();
		this.currentPlayerObject.setValue(firstPlayer);
	}
	
	/**
	 * Distributes the stones located in pitNumber
	 * 	to all subsequent pits, one at a time in 
	 * 	counter-clockwise order
	 * 
	 * @param pitNumber	The pit number where the stones
	 * 					are to be taken
	 * @return The pit number of the last stone
	 */
	public int distributeStonesFrom(int pitNumber) {
		if (pitNumber < 0) {
			throw new IllegalArgumentException("Pit number cannot be negative");
		}

		int numberOfStones = this.theBoard[pitNumber];
		this.theBoard[pitNumber] = 0;
		for (int count = 0; count < numberOfStones; count++) {
			pitNumber++;
			if (pitNumber >= this.getBoardSize()) {
				pitNumber = 0;
			}
			this.theBoard[pitNumber] += 1;
		}
		return pitNumber;
	}

	/**
	 * Returns the number of slots (pits and stores) on the board
	 * 
	 * @return	The number of slots on the board
	 */
	public int getBoardSize() {
		return this.theBoard.length;
	}
	
	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}
	
	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return	the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayerObject.getValue();
	}

	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public HumanPlayer getHumanPlayer() {
		return this.theHuman;
	}
	
	/**
	 * Returns whether the game has completed yet or not
	 * 
	 * @return	true iff the game is over; false otherwise
	 */
	public boolean getIsGameOver() {
		return this.isGameOver;
	}

	/**
	 * Returns the number of stones in the specified pit
	 * 
	 * @param pitNumber	The pit location that is potentially
	 * 					holding stones
	 * @return	The number of stones in the specified pit
	 */
	public int getStones(int pitNumber) {
		if (pitNumber < 0) {
			throw new IllegalArgumentException("Pit number cannot be negative");
		}
		return this.theBoard[pitNumber];
	}
	
	/**
	 * Conducts a move in the game, allowing the appropriate Player to
	 * take a turn. Has no effect if the game is over.
	 * 
	 * @param	pitChoice	The pit number where the stones will
	 * 						be taken from
	 * 
	 * @requires	!isGameOver()
	 * 
	 * @ensures		!whoseTurn().equals(whoseTurn()@prev)
	 */
	public void play(int pitChoice) {
		Player currentPlayer = this.currentPlayerObject.getValue();
		
		currentPlayer.takeTurn(pitChoice);
		
		Player winner = this.getFinisher();
		if (winner != null) {
			this.finishGame(winner);
		} else if (!this.currentPlayerObject.getValue().getIsMyTurn()) {
			this.swapWhoseTurn();
		} else {
			this.swapWhoseTurn();
			this.swapWhoseTurn();
		}
	}

	private Player getFinisher() {
		int humanStoneCount = 0;
		for (int index = 0; index < this.theBoard.length / 2 - 1; index++) {
			humanStoneCount += this.theBoard[index];
		}
		if (humanStoneCount == 0) {
			return this.theHuman;
		}
		
		int computerStoneCount = 0;
		for (int index = this.theBoard.length / 2; index < this.theBoard.length - 1; index++) {
			computerStoneCount += this.theBoard[index];
		}
		if (computerStoneCount == 0) {
			return this.theComputer;
		}
		return null;		
	}
	
	private void finishGame(Player finisher) {
		int humanStore = this.theBoard.length / 2 - 1;
		int computerStore = this.theBoard.length - 1;
		if (finisher.equals(this.theHuman)) {
			int storeIndex = humanStore;
			for (int index = this.theBoard.length / 2; index < this.theBoard.length - 1; index++) {
				this.theBoard[storeIndex] += this.theBoard[index];
				this.theBoard[index] = 0;
			}
		} else {
			int storeIndex = computerStore;
			for (int index = 0; index < this.theBoard.length / 2 - 1; index++) {
				this.theBoard[storeIndex] += this.theBoard[index];
				this.theBoard[index] = 0;
			}
		}
		if (this.theBoard[humanStore] > this.theBoard[computerStore]) {
			this.theWinner = this.theHuman;
		} else if (this.theBoard[computerStore] > this.theBoard[humanStore]) {
			this.theWinner = this.theComputer;
		}
		this.isGameOver = true;
		this.currentPlayerObject.setValue(null);
	}
	
	/**
	 * Returns a copy of the game board keeping track
	 * 	of the number of stones in each pit
	 * 
	 * @return	The game board
	 */
	public int[] getGameBoard() {
		return this.theBoard.clone();
	}
	
	/**
	 * Sets up the board such that there is exactly 1 stone
	 * 	in each pit
	 */
	private void resetBoard() {
		for (int index = 0; index < this.theBoard.length / 2 - 1; index++) {
			this.theBoard[index] = 1;
			this.theBoard[index + this.theBoard.length / 2] = 1;
		}
	}

	private void swapWhoseTurn() {
		if (this.getCurrentPlayer().equals(this.theHuman)) {
			this.currentPlayerObject.setValue(this.theComputer);
		} else if (this.getCurrentPlayer().equals(this.theComputer)) {
			this.currentPlayerObject.setValue(this.theHuman);
		}
	}
	
	/**
	 * Returns a String showing the current score, or, if
	 * the game is over, the name of the winner.
	 * 
	 * @return a String representation of this Game
	 */
	public String toString() {	
		String result = this.theHuman.getName() + ": " 
				+ this.theBoard[this.theBoard.length / 2 - 1] + System.getProperty("line.separator");
		result += this.theComputer.getName() + ": " 
				+ this.theBoard[this.theBoard.length - 1];
		if (this.isGameOver && this.theWinner != null) {
			result += System.getProperty("line.separator") + this.theWinner.getName() + " wins";
		} else if (this.isGameOver && this.theWinner == null) {
			result += "Tie game";
		}

		return result;
	}

	@Override
	public void addListener(InvalidationListener theListener) {
		this.currentPlayerObject.addListener(theListener);
	}

	@Override
	public void removeListener(InvalidationListener theListener) {
		this.currentPlayerObject.removeListener(theListener);
	}
}
