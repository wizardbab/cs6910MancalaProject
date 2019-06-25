package edu.westga.cs6910.mancala.model.strategies;

/**
 * This class implements a pit selection strategy for the 
 * ComputerPlayer where the AI always selects the pit furthest 
 * the store with a stone in it.
 * 
 * @author En Yang Pang
 * @version 06/25/2019
 */
public class FarStrategy implements SelectStrategy {

	@Override
	public int selectPit(int[] gameBoard) {
		int pitChoice = gameBoard.length / 2;
		while (gameBoard[pitChoice] == 0) {
			pitChoice++;
		}
		return pitChoice;
	}

}
