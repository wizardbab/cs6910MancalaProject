package edu.westga.cs6910.mancala.model.strategies;

/**
 * SelectStrategy defines the strategy for the computer player.
 * 
 * @author En Yang Pang
 * @version 06/24/2019
 */
public interface SelectStrategy {

	/**
	 * Takes the game board and returns the selected pit number.
	 * 
	 * @param gameBoard The Game Board
	 * @return The pit number selected
	 */
	int selectPit(int[] gameBoard);
}
